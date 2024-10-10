package org.orange.admintestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.orange.common.BaseTest;
import org.orange.pagemodels.AdminUserManagement;
import org.orange.pagemodels.DashboardPage;
import org.orange.pagemodels.LandingPage;
import org.testng.annotations.Test;

import java.util.List;

public class AdminFunctionalityTest extends BaseTest {

    String url = "https://opensource-demo.orangehrmlive.com/";

    @Test
    public void createSystemUser() {
        LandingPage landingPage = startApplication();
        landingPage.loadUrl(url);
        String username = "Admin";
        String password = "admin123";
        DashboardPage dashboardPage = landingPage.applicationLogin(username, password);
        AdminUserManagement adminUserManagement = dashboardPage.goToAdminUserManagement();
        adminUserManagement.click();
        WebElement userRoleDropdown= adminUserManagement.getUserRoledropdown();
        List<WebElement> userRoleOptions= adminUserManagement.clickDropdown(userRoleDropdown);
        selectOptionFromDropdown(userRoleOptions,"Admin");
        WebElement statusDropdown= adminUserManagement.getStatusDropdown();
        List<WebElement> statusOptions= adminUserManagement.clickDropdown(statusDropdown);
        selectOptionFromDropdown(statusOptions,"Enabled");





    }





}
