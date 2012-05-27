package jp.coxs.twitter.favrt.model;

import jp.coxs.twitter.favrt.model.TwitterUser;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TwihoUserTest extends AppEngineTestCase {

    private TwitterUser model = new TwitterUser();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
