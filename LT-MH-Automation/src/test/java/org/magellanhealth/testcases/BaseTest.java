package org.magellanhealth.testcases;

import org.magellanhealth.driverManager.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.util.Map;

public class BaseTest {


    @BeforeMethod
    public void setUpTest(Object[] data) throws MalformedURLException {
        Map<String, String> map = (Map<String, String>) data[0];
        Driver.initDriver(map);

    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}
