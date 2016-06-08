package com.a1systems.utils;

import org.apache.log4j.Logger;
import org.testng.*;

/**
 * Created by Aristarkhov on 07.06.2016.
 */
public class ListenerClass extends TestListenerAdapter {
    final static Logger logger = Logger.getLogger(ListenerClass.class);
    @Override
    public void onTestStart(ITestResult tr) {
        logger.info("********************************");
        logger.info("Test Started: " + tr.getName());
        logger.info("Description: " + tr.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        logger.info("Test '" + tr.getName() + "' PASSED");
        logger.info(tr.getTestClass());
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        logger.info("Test '" + tr.getName() + "' FAILED", tr.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        logger.info("Test '" + tr.getName() + "' SKIPPED");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        logger.info("********************************");
    }
}
