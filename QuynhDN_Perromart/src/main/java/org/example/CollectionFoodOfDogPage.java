package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CollectionFoodOfDogPage {
    private WebDriver driver;

    public CollectionFoodOfDogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//input[@type='text']")
    private WebElement inputFood;
    @FindBy(xpath="//div[@class='NavSearchBar_searchIconDiv__Vr5NB']")
    private WebElement iconSearch;
    public void searchProduct(String product) {
        inputFood.sendKeys(product);//nhập thức ăn cần tìm
        iconSearch.click();//nhấn icon search
    }
}
