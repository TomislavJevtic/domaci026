package domaci026.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutAndCartTest extends BasePage{
    private By hamburgerMenu = By.xpath("//*[@id=\"menu_button_container\"]/div/div[1]/div");
    private By logoutMenuOption = By.id("logout_sidebar_link");



    private String urlCart = "https://www.saucedemo.com/cart.html";

    public String getUrlCart() {
        return urlCart;
    }
    public WebElement getHamMenu(){
        return getDriver().findElement(hamburgerMenu);
    }
    public void menuClick(){

        Actions hoverMenu = new Actions(getDriver());
        hoverMenu.scrollToElement(getHamMenu()).perform();
        hoverMenu.moveToElement(getHamMenu()).perform();
       getHamMenu().click();
       getDriverWait().until(ExpectedConditions.elementToBeClickable(logoutMenuOption));
    }
    public void logoutClick(){
        getDriver().findElement(logoutMenuOption).click();
    }
    public void goToCartUrl(){
        getDriver().get("https://www.saucedemo.com/cart.html");
    }

    public LogoutAndCartTest(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
}
