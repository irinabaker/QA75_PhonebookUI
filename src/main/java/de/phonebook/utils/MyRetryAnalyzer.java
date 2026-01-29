package de.phonebook.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    private static final int maxTry = 3;
    private int count = 0;

    Logger logger = LoggerFactory.getLogger(MyDataProviders.class);

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (this.count<maxTry) {
                logger.info("Retrying test " + iTestResult.getName() + "with status " +
                       getResultStatusName(iTestResult.getStatus()) + " for " + (this.count + 1)
                + " time(s)");
                this.count++;
                return true;
            }
        }
        return false;
    }

    public String getResultStatusName(int status) {
        String resultName = null;
        if (status==1) {
            resultName = "SUCCESS";
        } if (status==2){
            resultName = "FAILURE";
        } if (status==3) {
            resultName="SKIP";
        }
        return resultName;
    }
}
