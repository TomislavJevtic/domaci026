package prosliCas.prviTestNg;

/*
Ucitati stranicu https://demoqa.com/modal-dialogs i:
Kliknuti na dugme Large modal
Proveriti da li se dijalog prikazuje i ispisati u konzoli tekst dijaloga
Proveriti da li se u dijalogu prikazuje dugme Close (edited)
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


public class testiranjeQAdemo {
    private WebDriver driver;


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://demoqa.com/modal-dialogs");
    }

    @Test
    public void test1() {
        WebElement modalBtn = driver.findElement(By.id("showLargeModal"));
        modalBtn.click();

        WebElement modalBigPopUp = driver.findElement(By.xpath("/html/body/div[4]/div/div"));
        Boolean actualRes =modalBigPopUp.isDisplayed();

        Boolean expectedRes = true;


        System.out.println(modalBigPopUp.getText());

        Assert.assertEquals(expectedRes,actualRes);

    }
    @Test (dependsOnMethods = "test1")
    public void test2(){
        WebElement modalBtn = driver.findElement(By.id("showLargeModal"));
        modalBtn.click();
        WebElement modalBigPopUpClose = driver.findElement(By.id("closeLargeModal"));
        Boolean expectedRes = true;
        Boolean actualRes =modalBigPopUpClose.isEnabled();

        Assert.assertEquals(actualRes,expectedRes);



    }


}
