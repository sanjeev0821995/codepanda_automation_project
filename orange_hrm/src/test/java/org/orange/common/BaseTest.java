package org.orange.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.orange.pagemodels.LandingPage;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    public WebDriver initializeDriver(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    public LandingPage startApplication(){
        driver=initializeDriver();
        return new LandingPage(driver);
    }
}
