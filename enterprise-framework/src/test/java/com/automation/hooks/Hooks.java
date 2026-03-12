package com.automation.hooks;

import com.automation.core.DriverManager;
import com.automation.reporting.ExtentManager;
import com.automation.utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;

public class Hooks {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Before
    public void setUp(Scenario scenario) {
        DriverManager.initDriver();
        test.set(extent.createTest(scenario.getName()));
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] screenshot = ScreenshotUtil.captureScreenshot();
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
            test.get().fail("Test Failed");
        } else {
            test.get().pass("Test Passed");
        }

        DriverManager.quitDriver();
        extent.flush();
    }
}