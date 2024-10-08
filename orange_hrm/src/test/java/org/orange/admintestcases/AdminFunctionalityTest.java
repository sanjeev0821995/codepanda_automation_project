package org.orange.admintestcases;

import org.orange.common.BaseTest;
import org.orange.pagemodels.DashboardPage;
import org.orange.pagemodels.LandingPage;
import org.testng.annotations.Test;

public class AdminFunctionalityTest extends BaseTest {

    String url="https://opensource-demo.orangehrmlive.com/";

    @Test
    public void createSystemUser(){
        LandingPage landingPage= startApplication();
        landingPage.loadUrl(url);
        String username="Admin";
        String password="admin123";
        DashboardPage dashboardPage=landingPage.applicationLogin(username,password);
    }
}
