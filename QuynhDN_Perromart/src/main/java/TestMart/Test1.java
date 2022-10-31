package TestMart;

import org.example.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import setupDriver.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1 extends DriverSetup {
    private WebDriver driver;
    private PerromartHomePage home;
    private CollectionFoodOfDogPage collectionPage;
    private BuyFood buyFood;
    private CartPage cart;
    private WebDriverWait wait;
    private ShippingAddressPage addressPage;
    private CheckOutShippingAddress checkOutAdd;

    @BeforeMethod
    public void run() {
        String url = "https://perromart.com.sg/";
        driver = openDriver("chrome");
        findURL(url);
    }

    @Test
    public void testCase1() {
        home = new PerromartHomePage(driver);
        home.homePageLoad();
        collectionPage = new CollectionFoodOfDogPage(driver);
        collectionPage.searchProduct("Bronco Salmon");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        buyFood = new BuyFood(driver);
        buyFood.clickProduct("Bronco Jerky Salmon Dog Treat 70g");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        buyFood.clickAddToCart();
        buyFood.clickIconViewCart();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Verify
        cart = new CartPage(driver);
        String product = cart.veriFyProduct("Bronco Jerky Salmon Dog Treat 70g");
        Assert.assertEquals(product, "Bronco Jerky Salmon Dog Treat 70g");
        System.out.println("Add Success ! ");
    }

    @Test
    public void testCase2() {
        home = new PerromartHomePage(driver);
        home.clickclosePoster();
        collectionPage = new CollectionFoodOfDogPage(driver);
        collectionPage.searchProduct("cat wet food");

        buyFood = new BuyFood(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        buyFood.clickProduct("Aatas Cat Finest Daily Skin & Coat Cat Wet Food 80g");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        buyFood.clickAddToCart();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        buyFood.clickbtnCancelGiftDeals();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        buyFood.clickIconViewCart();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Verify product added
        cart = new CartPage(driver);
        String product = cart.veriFyProduct("Aatas Cat Finest Daily Skin & Coat Cat Wet Food 80g");
        Assert.assertEquals(product, "Aatas Cat Finest Daily Skin & Coat Cat Wet Food 80g");
        System.out.println("Add Success ! ");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        cart.clickBtnCheckOut();

        //Add shipping address
        addressPage = new ShippingAddressPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        addressPage.inputAddress("nhuquynhk14001@gmail.com", "Do", "Nhu Quynh", "36 Luu Quang Thuan", "Fhome",
                "569933", "0765207419");
        addressPage.clickContinue();

        //Verify shipping address
        checkOutAdd = new CheckOutShippingAddress(driver);
        String email = checkOutAdd.checkOutEmail();
        Assert.assertEquals(email, "nhuquynhk14001@gmail.com");
        String address = checkOutAdd.checkOutAddress();
        Assert.assertEquals(address, "36 Luu Quang Thuan, Fhome, Singapore 569933");
        System.out.println("Verify Success ! ");
    }
}
