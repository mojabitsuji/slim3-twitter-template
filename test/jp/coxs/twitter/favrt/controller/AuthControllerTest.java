package jp.coxs.twitter.favrt.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

public class AuthControllerTest extends ControllerTestCase {
    @Test
    public void run() throws Exception {
        tester.start("/auth");
        AuthController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/top/top.jsp"));
    }
}
