package org.orange.admintestcases;

import org.openqa.selenium.WebElement;
import org.orange.common.BaseTest;
import org.orange.pagemodels.AdminUserManagement;
import org.orange.pagemodels.DashboardPage;
import org.orange.pagemodels.LandingPage;
import org.testng.annotations.Test;

import java.util.List;

public class AdminFunctionalityTest extends BaseTest {


    @Test
    public void createSystemUser() {
        DashboardPage dashboardPage = landingPage.applicationLogin(username,appPassword);
        AdminUserManagement adminUserManagement = dashboardPage.goToAdminUserManagement();
        adminUserManagement.click();
        WebElement userRoleDropdown= adminUserManagement.getUserRoledropdown();
        List<WebElement> userRoleOptions= adminUserManagement.clickDropdown(userRoleDropdown);
        selectOptionFromDropdown(userRoleOptions,"Admin");
        WebElement statusDropdown= adminUserManagement.getStatusDropdown();
        List<WebElement> statusOptions= adminUserManagement.clickDropdown(statusDropdown);
        selectOptionFromDropdown(statusOptions,"Enabled");
        adminUserManagement.saveUser(empName,pasword,confirmPassword);





    }





}
