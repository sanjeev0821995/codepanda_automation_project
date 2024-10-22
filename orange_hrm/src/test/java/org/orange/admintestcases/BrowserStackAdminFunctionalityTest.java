package org.orange.admintestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.orange.common.BrowserStackUtil;
import org.orange.pagemodels.AdminUserManagement;
import org.orange.pagemodels.DashboardPage;
import org.orange.pagemodels.LandingPage;
import org.orange.util.ReadConfig;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class BrowserStackAdminFunctionalityTest {
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


    @Parameters({"browser", "browser_version", "os", "os_version","device"})
    @BeforeTest
    public void setUp(String browser, @Optional String browserVersion, @Optional String os, String osVersion, @Optional String device) throws MalformedURLException {
        driver = BrowserStackUtil.createDriver(browser, browserVersion, os, osVersion,device);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @BeforeClass
    public void startApplication(){
        landingPage=new LandingPage(driver);
        softAssert=new SoftAssert();
    }

    @Test
    public void createSystemUser() {
        DashboardPage dashboardPage = landingPage.applicationLogin(username, appPassword);
        AdminUserManagement adminUserManagement = dashboardPage.goToAdminUserManagement();
        adminUserManagement.click();
        WebElement userRoleDropdown = adminUserManagement.getUserRoledropdown();
        List<WebElement> userRoleOptions = adminUserManagement.clickDropdown(userRoleDropdown);
        selectOptionFromDropdown(userRoleOptions, "Admin");
        WebElement statusDropdown = adminUserManagement.getStatusDropdown();
        List<WebElement> statusOptions = adminUserManagement.clickDropdown(statusDropdown);
        selectOptionFromDropdown(statusOptions, "Enabled");
        adminUserManagement.saveUser(empName, pasword, confirmPassword);
    }

    public void selectOptionFromDropdown(List<WebElement> options, String text){
        for(WebElement option:options){
            if(option.getText().equals(text)){
                option.click();
                break;
            }
        }
    }
}
