package com.eug.springboottestngallure.listener;

import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestNgListener implements ITestListener {

  @Override
  public void onStart(ITestContext context) {
    log.info("Starting... ");
  }

  @Override
  public void onTestStart(ITestResult result) {
    log.info(result.getMethod().getMethodName() + " STARTED");
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    log.info(result.getMethod().getMethodName() + " PASSED");
  }

  @Override
  public void onTestFailure(ITestResult result) {
    log.info(result.getMethod().getMethodName() + " FAILED");
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    log.info(result.getMethod().getMethodName() + " SKIPPED");
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    log.info(result.getMethod().getMethodName() + " FAILED_BUT_WITHIN_SUCCESS_PERCENTAGE");
  }

  @Override
  public void onFinish(ITestContext context) {
    log.info("FINISHED");
  }
}
