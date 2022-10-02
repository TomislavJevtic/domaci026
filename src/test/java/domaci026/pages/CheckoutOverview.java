package domaci026.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutOverview extends BasePage{

    private By totalAmount= By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]");
    private By finishBtn= By.id("finish");

    public WebElement getTotalAmount(){
        return getDriver().findElement(totalAmount);
    }
    public WebElement getFinishBtn(){
        return getDriver().findElement(finishBtn);
    }
    public void setFinishBtnClick(){
        getFinishBtn().click();
    }
    public CheckoutOverview(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
}
