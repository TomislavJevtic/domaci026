package domaci026.tests;

import domaci026.pages.AddOnePage;
import domaci026.pages.CheckoutAndBay;
import domaci026.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        loginPage = new LoginPage(driver,driverWait);
        addOnePage = new AddOnePage(driver,driverWait);
        checkoutAndBay = new CheckoutAndBay(driver,driverWait);
        driver.get("https://www.saucedemo.com");
    }

    @BeforeMethod
    public void beforeM(){

    }
    @AfterClass
    public void afterC(){

        driver.quit();
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

    }
