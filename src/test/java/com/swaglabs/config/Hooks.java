package com.swaglabs.config;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp() {
        BaseTest.getDriver().get("https://www.saucedemo.com/");
    }

    @After
    public void afterScenario() {
        BaseTest.tearDown();
    }
}
