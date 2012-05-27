package jp.coxs.twitter.favrt.controller;

import jp.coxs.twitter.favrt.controller.LoginController;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class LoginControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/twh/login");
        LoginController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));
    }
}
