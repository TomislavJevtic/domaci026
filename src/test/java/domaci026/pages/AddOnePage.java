package domaci026.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddOnePage extends BasePage{
    private By productBtn = By.id("add-to-cart-sauce-labs-backpack");




    public AddOnePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getProductBtn(){
        return getDriver().findElement(productBtn);
    }

    public  void addProduct1(){

        getProductBtn().click();
    }
}
