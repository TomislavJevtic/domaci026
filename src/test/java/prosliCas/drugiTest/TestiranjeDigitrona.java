package prosliCas.drugiTest;
/*
Testirati rad kalkulatora https://testsheepnz.github.io/BasicCalculator.html. Testirati rad svih operacija posebno.
testsheepnz.github.iotestsheepnz.github.io
Basic Calculator
TestSheepNZ's basic Selenium page
 */

// element.getAttribute("value")


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestiranjeDigitrona {

    private WebDriver driver;


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
    }

    @Test
    public void test1(){


    }

}
