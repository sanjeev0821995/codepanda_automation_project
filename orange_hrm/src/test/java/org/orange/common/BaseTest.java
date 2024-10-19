package org.orange.common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.orange.pagemodels.LandingPage;
import org.orange.util.ReadConfig;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class BaseTest {
    public WebDriver driver;
    ReadConfig readConfig=new ReadConfig();
    String baseUrl= readConfig.getApplicationUrl();
    public String username= readConfig.getUserName();
    public String appPassword=readConfig.getApplicationPassword();
    public String empName= readConfig.getEmployeeName();
    public String pasword=readConfig.getPassword();
    public String confirmPassword= readConfig.getConfirmPassword();
    public LandingPage landingPage;
    public SoftAssert softAssert;

    @BeforeTest
    @Parameters("browser")
    public void setup(@Optional("Chrome") String browserName){
        if(browserName.equalsIgnoreCase("Chrome"))
            driver=new ChromeDriver();
        else if (browserName.equalsIgnoreCase("firefox")) {
            driver=new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver=new EdgeDriver();
        }
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @BeforeClass
    public void startApplication(){
        landingPage=new LandingPage(driver);
        softAssert=new SoftAssert();
    }

    public void selectOptionFromDropdown(List<WebElement> options,String text){
        for(WebElement option:options){
            if(option.getText().equals(text)){
                option.click();
                break;
            }
        }
    }
}
