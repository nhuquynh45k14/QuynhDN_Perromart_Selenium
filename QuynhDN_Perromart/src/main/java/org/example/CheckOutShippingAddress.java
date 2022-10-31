package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckOutShippingAddress {
    private WebDriver driver;
    @FindBy(xpath = "//bdo[@dir='ltr']")
    private WebElement emailValue;
    @FindBy(xpath = "//address[@class='address address--tight']")
    private WebElement addressValue;

    public CheckOutShippingAddress(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String checkOutEmail() {
        String valueEmail = emailValue.getText();
        return valueEmail;
    }
        public String checkOutAddress () {
        String valueAddress = addressValue.getText();
        return valueAddress;
    }
}
