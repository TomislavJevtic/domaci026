package domaci026.tests;

import domaci026.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SwagLabsTest {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private AddOnePage addOnePage;
    private CheckoutAndBay checkoutAndBay;
    private InfoPage infoPage;
    private CheckoutOverview checkoutOverview;
    private LogoutAndCartTest logoutAndCartTest;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver,driverWait);
        addOnePage = new AddOnePage(driver,driverWait);
        checkoutAndBay = new CheckoutAndBay(driver,driverWait);
        infoPage = new InfoPage(driver,driverWait);
        checkoutOverview = new CheckoutOverview(driver,driverWait);
        logoutAndCartTest=new LogoutAndCartTest(driver,driverWait);

        driver.get("https://www.saucedemo.com");
    }

    @BeforeMethod
    public void beforeM(){

    }
    @AfterClass
    public void afterC(){

       // driver.quit();
    }

    @Test (priority = 1)
    public void testLogin(){

        loginPage.login("standard_user","secret_sauce");

        WebElement products = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div"));
        String productText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        boolean expectedR=true;
        boolean actualR = products.isDisplayed();

        Assert.assertEquals(expectedR,actualR);
    }
    @Test (dependsOnMethods ="testLogin" )
    public void addToCartTest() {
        //loginPage.login("standard_user","secret_sauce");
        addOnePage.addProduct1();
        boolean expected = true;
        WebElement cartIcon = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
        boolean actual= cartIcon.getText().equalsIgnoreCase("1");
        Assert.assertEquals(expected,actual);
       // System.out.println(cartIcon.getText());


    }
    @Test (dependsOnMethods = "addToCartTest")
    public void testCheckout(){
        checkoutAndBay.clickCartBtn();
        checkoutAndBay.clickCheckoutBtn();
        boolean expectedRes = true;
        boolean actualRes= driver.findElement
                (By.xpath("//*[@id=\"continue\"]")).isEnabled();
        Assert.assertEquals(actualRes,expectedRes);

    }
    @Test(dependsOnMethods = "testCheckout")
    public void testInfoInCheckOut(){
        infoPage.validInfo("Tracy","McGrady","37212");
        infoPage.continueClick();

        boolean expected = true;
        WebElement finishBtn = driver.findElement(By.id("finish"));
        boolean actual = finishBtn.isEnabled();

        Assert.assertEquals(actual,expected);

    }
    @Test(dependsOnMethods ="testInfoInCheckOut" )
    public void testCheckoutView(){
        checkoutOverview.getTotalAmount();

        String expectedR="Total: $32.39";
        String actualR=checkoutOverview.getTotalAmount().getText();
        System.out.println(actualR);
        System.out.println(expectedR);

        Assert.assertEquals(expectedR,actualR);

        checkoutOverview.setFinishBtnClick();
        WebElement successOrder = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
        String expOrderResult=successOrder.getText();
        String actualOrderResult = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(expOrderResult,actualOrderResult);


    }

    @Test(dependsOnMethods ="testCheckoutView" )
    public void testLogoutCart() {

        logoutAndCartTest.menuClick();

        logoutAndCartTest.logoutClick();
        logoutAndCartTest.goToCartUrl();

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        boolean expected = true;
        boolean actual = errorMessage.isDisplayed();
        Assert.assertEquals(expected,actual);

    }
    }
