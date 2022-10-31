package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingAddressPage {
    private WebDriver driver;

    public ShippingAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='checkout_email']")
    private WebElement txtEmail;
    @FindBy(xpath = "//input[@id='checkout_shipping_address_first_name']")
    private WebElement txtFirstName;
    @FindBy(xpath = "//input[@id='checkout_shipping_address_last_name']")
    private WebElement txtLastName;
    @FindBy(xpath = "//input[@id='checkout_shipping_address_address1']")
    private WebElement txtAddress;
    @FindBy(xpath = "//input[@id='checkout_shipping_address_address2']")
    private WebElement txtApartment;
    @FindBy(xpath = "//input[@id='checkout_shipping_address_zip']")
    private WebElement txtPostalCode;
    @FindBy(xpath ="//input[@id='checkout_shipping_address_phone']")
    private WebElement txtPhone;

    @FindBy(xpath = "//button[@id='continue_button']")
    private WebElement continueButton;

    public void inputAddress(String email,String firstName,String lastName,String address,String appartment,String postalCode,String phone) {
        txtEmail.sendKeys(email);
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtAddress.sendKeys(address);
        txtApartment.click();
        txtApartment.sendKeys(appartment);
        txtPostalCode.sendKeys(postalCode);
        txtPhone.sendKeys(phone);
    }
    public void clickContinue(){
        continueButton.click();
    }
}