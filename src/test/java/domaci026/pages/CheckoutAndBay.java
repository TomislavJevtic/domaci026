package domaci026.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutAndBay extends BasePage {
    private By cartBtn = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    private By checkoutBtn = By.id("checkout");

    public WebElement getCartBtn() {
        return getDriver().findElement(cartBtn);
    }

    public WebElement getCheckoutBtn() {
        return getDriver().findElement(checkoutBtn);
    }

    public void clickCartBtn() {
        getCartBtn().click();
    }

    public void clickCheckoutBtn() {
        getCheckoutBtn().click();
    }


    public CheckoutAndBay(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

}
