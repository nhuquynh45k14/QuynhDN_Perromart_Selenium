package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BuyFood {
    private WebDriver driver;
    private WebDriverWait wait;
    public BuyFood(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    private WebElement btnaddToCart;
    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/nav/div/div[3]/div[4]/a[2]/div")
    private WebElement iconViewCart;
    @FindBy(xpath = "//span[@class='ps-3 my-auto']")
    private WebElement status;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement btnCancelGiftDeals;

    //Thêm vào giỏ hàng
    public void clickProduct(String nameProduct) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By productName = By.xpath("//div[text()='"+nameProduct+"']");
        driver.findElement(productName).click();
    }

    public void clickIconViewCart() {
        iconViewCart.click();
    }
    public void clickAddToCart(){
        btnaddToCart.click();
    }

    public void clickbtnCancelGiftDeals() {
        btnCancelGiftDeals.click();
    }

}


