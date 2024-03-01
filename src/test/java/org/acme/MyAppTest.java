package org.acme;

import org.acme.svc.MyApp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyAppTest {

    @Test
    void run() throws Exception {
        MyApp myApp = new MyApp();
        assertEquals(0, myApp.run());
    }

    @Test
    void title_p0() {
        MyApp myApp = new MyApp();
        assertEquals("##carmageddo", myApp.title("carmageddo", 0));
    }

    @Test
    void title_p2() {
        MyApp myApp = new MyApp();
        assertEquals("##carmageddo", myApp.title("carmageddo", 2));
    }

    @Test
    void title_p5() {
        MyApp myApp = new MyApp();
        assertEquals("#####carmageddo", myApp.title("carmageddo", 5));
    }

    @Test
    void title_p6() {
        MyApp myApp = new MyApp();
        assertEquals("#####carmageddo", myApp.title("carmageddo", 6));
    }

    @Test
    void title_minus_3() {
        MyApp myApp = new MyApp();
        assertEquals("##carmageddo", myApp.title("carmageddo", -3));
    }

    @Test
    void title_maxValue() {
        MyApp myApp = new MyApp();
        assertEquals("#####carmageddo", myApp.title("carmageddo", Integer.MAX_VALUE));
    }

    @Test
    void title_minValue() {
        MyApp myApp = new MyApp();
        assertEquals("##carmageddo", myApp.title("carmageddo", Integer.MIN_VALUE));
    }

    @Test
    void title() {
        MyApp myApp = new MyApp();
        assertEquals("#####carmageddo", myApp.title());
    }
}