package org.listeners;

import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        BaseTest test = (BaseTest) result.getInstance();

        byte[] screenshot = test.getPage().screenshot();

        Allure.addAttachment(
                "Screenshot on failure",
                new ByteArrayInputStream(screenshot)
        );
    }
}