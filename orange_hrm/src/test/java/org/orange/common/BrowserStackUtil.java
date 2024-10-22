package org.orange.common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserStackUtil {
    private static final String USERNAME = "sanjeevkumar_hM4bBo";  // Update with your BrowserStack username
    private static final String AUTOMATE_KEY = "gGYXRsyBffpwomAmgpzj";  // Update with your BrowserStack access key
    private static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createDriver(String browser, String browserVersion, String os, String osVersion,String device) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        if(browserVersion!=null) {
            capabilities.setCapability("browserVersion", browserVersion);
        }

        // Set BrowserStack specific options
        HashMap<String, Object> bstackOptions = new HashMap<>();
        if(os!=null) {
            bstackOptions.put("os", os);  // OS name
        }
        bstackOptions.put("osVersion", osVersion);  // OS version
        bstackOptions.put("projectName", "Orange_HRM"); // Project name
        bstackOptions.put("buildName", "Build 1.0"); // Optional: Set your build name
        bstackOptions.put("sessionName", "CodePanda Automation Test Running on " + device);
        if(device!=null) {
            bstackOptions.put("deviceName", device);
        }



        capabilities.setCapability("bstack:options", bstackOptions);

        return new RemoteWebDriver(new URL(URL), capabilities);
    }
}
