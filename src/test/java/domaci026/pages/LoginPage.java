package domaci026.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.xpath("//*[@id=\"login-button\"]");

    public WebElement getUsername(){
        return getDriver().findElement(username);
    }
    public WebElement getPassword(){
        return getDriver().findElement(password);
    }
    public WebElement getLoginBtn(){
        return getDriver().findElement(loginBtn);
    }

    public void login(String username,String password){
        getUsername().sendKeys(username);
        getPassword().sendKeys(password);
        getLoginBtn().click();
    }




}
