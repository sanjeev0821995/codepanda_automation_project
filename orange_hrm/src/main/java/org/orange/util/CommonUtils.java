package org.orange.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CommonUtils {

    public WebDriver driver;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
