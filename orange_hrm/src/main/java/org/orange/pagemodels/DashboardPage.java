package org.orange.pagemodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.orange.util.CommonUtils;

public class DashboardPage extends CommonUtils {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminTab;

    public AdminUserManagement goToAdminUserManagement(){
        adminTab.click();
        return new AdminUserManagement(driver);
    }
}
