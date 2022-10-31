package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.By.xpath;

public class PerromartHomePage {
    private WebDriver driver;

    public PerromartHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//button[@tabindex='0']")
    private WebElement closePoster;
    @FindBy(xpath = "//div[@class='navBorder']")
    private WebElement menuDog;
    @FindBy(xpath = "//div[text()='Food']")
    private WebElement menuFoodOfDog;

    public void homePageLoad() {
        closePoster.click();
        menuDog.click();
        menuFoodOfDog.click();
    }
    public void clickclosePoster()
    {
        closePoster.click();
    }
}




