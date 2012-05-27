package jp.coxs.twitter.favrt.controller;

import jp.coxs.twitter.favrt.controller.KujiraController;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class KujiraControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/kujira");
        KujiraController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/kujira.jsp"));
    }
}
