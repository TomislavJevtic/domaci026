package domaci026.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InfoPage extends BasePage{
    private By firstName = By.id("first-name");
    private By lastName= By.id("last-name");
    private By postalCode= By.id("postal-code");
    private By continueBtn= By.id("continue");
    private By cancelBtn=By.id("cancel");


    public InfoPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getFirstName(){
        return getDriver().findElement(firstName);
    }
    public WebElement getLastName(){
        return getDriver().findElement(lastName);
    }
    public WebElement getPostalC(){
        return getDriver().findElement(postalCode);
    }
    public WebElement getContinueBtn(){
        return getDriver().findElement(continueBtn);
    }
    public WebElement getCancelBtn(){
        return getDriver().findElement(cancelBtn);
    }


    public void validInfo(String firstName,String lastName,String postalCode){
        getFirstName().sendKeys(firstName);
        getLastName().sendKeys(lastName);
        getPostalC().sendKeys(postalCode);
    }
    public void continueClick(){
        getContinueBtn().click();
    }
    public void cancelOnClick(){
        getCancelBtn().click();
    }


}
