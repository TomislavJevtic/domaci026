package prosliCas.drugiSaCasa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class Testiranje02 {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }

    @BeforeMethod
    public void methodSetup() {
        driver.get("//cms.demo.katalon.com/");
    }
    /*
    Napisati program koji učitava stranicu https://cms.demo.katalon.com/  i:
* dodaje prva 3 proizvoda u korpu
* klikne na Cart link iz navigacije i
* proverava da na stranici postoji 3 proizvoda

     */

    @Test
    public void test1() {
        List<WebElement> products = driver.findElements(By.xpath("//*[@id=\"main\"]/div[2]/ul"));
        for (int i = 0; i < products.size() ; i++) {
            WebElement product = products.get(i);
            WebElement addToCart =  product.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[1]/div/a[2]"));
            addToCart.click();
            WebElement visibleViewCartBtn=driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[1]/div/a[3]"));
            Boolean actual=visibleViewCartBtn.isDisplayed();
            Boolean expected=true;

        }


    }


}
