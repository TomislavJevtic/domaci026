package prosliCas.testKatalonHomePage;
/*
Zadatak 1
Napisati program koji učitava stranicu https://cms.demo.katalon.com/ i:
* proverava da li je naslov na stranici jednak Shop
* proverava da li postoji poruka Showing 1–12 of 24 results
* proverava da li strana prikazuje 12 proizvoda
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestKatalonHomePage {
    private WebDriver driver;


    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }
    @BeforeMethod
    public void setMethod(){
        driver.get("https://cms.demo.katalon.com/");
    }

    @Test
    public void test1(){
        WebElement h1Title = driver.findElement(By.xpath("//*[@id=\"page\"]/header/h1"));
        String actualRes = h1Title.getText();
        String exectedRes = "Shop";
        Assert.assertEquals(actualRes,exectedRes);
    }
    @Test
    public void test2(){
        WebElement h1Title = driver.findElement(By.xpath("//*[@id=\"main\"]/p"));
        String actualRes = h1Title.getText();
        String exectedRes = "Showing 1–12 of 24 results";
        Assert.assertEquals(actualRes,exectedRes);
    }
    @Test
    public void test3(){
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"main\"]/div[2]/ul/li"));
        int actualRes=list.size();
        int exectedRes=12;
        Assert.assertEquals(actualRes,exectedRes);
    }



}
