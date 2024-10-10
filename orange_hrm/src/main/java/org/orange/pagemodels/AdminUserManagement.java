package org.orange.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.orange.util.CommonUtils;

import java.util.List;

public class AdminUserManagement extends CommonUtils {

    public AdminUserManagement(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()=' Add ']")
    private WebElement addButton;

    @FindBy(xpath = "//div[@class='oxd-select-wrapper']")
    private WebElement userRoledropdown;

    public WebElement getUserRoledropdown() {
        return userRoledropdown;
    }

    public WebElement getStatusDropdown() {
        return statusDropdown;
    }

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
    private WebElement statusDropdown;

    @FindBy(css=".oxd-select-option span")
    List<WebElement> options;

    public void click(){
        addButton.click();
    }

    public List<WebElement> clickDropdown(WebElement dropdown){
        dropdown.click();
        return options;
    }


}