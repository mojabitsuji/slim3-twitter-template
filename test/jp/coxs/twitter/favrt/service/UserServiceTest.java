package jp.coxs.twitter.favrt.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import jp.coxs.twitter.favrt.util.ServiceProvider.Processor;
import jp.coxs.twitter.favrt.util.TwitterServiceProvider;
import jp.coxs.twitter.favrt.util.TwitterServiceProvider.TwitterVoid;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

public class UserServiceTest extends AppEngineTestCase {
    private UserService service = new UserService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }

    @Test
    public void testStatusesHomeTimeline() throws Exception {
        Processor<TwitterVoid> proc = TwitterServiceProvider.instanceOfFriendshipsCreate();
        TwitterVoid twitterVoid = proc.parseResponse(getJsonResources());
    }

    @Test
    public void testStatusesFriendsTimeline() throws Exception {
        Processor<TwitterVoid> proc = TwitterServiceProvider.instanceOfStatusesFriendsTimeline();
        TwitterVoid twitterVoid = proc.parseResponse(getJsonResources());
    }

    private String getJsonResources() throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        BufferedReader br = null;
        StringBuilder builder = new StringBuilder();
        try {
            br =
                new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(
                    "resources/" + methodName)));
            String string = null;
            while ((string = br.readLine()) != null) {
                builder.append(string);
            }
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
            }
        }
        return builder.toString();
    }
}
