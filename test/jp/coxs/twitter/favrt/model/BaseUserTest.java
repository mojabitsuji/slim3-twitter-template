package jp.coxs.twitter.favrt.model;

import jp.coxs.twitter.favrt.model.BaseUser;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class BaseUserTest extends AppEngineTestCase {

    private BaseUser model = new BaseUser();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
