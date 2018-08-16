package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SinglePropertyPage extends BasePage {

    public SinglePropertyPage(WebDriver driver){
        super(driver);
    }

    @Override
    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".property-details .property-header-bedroom-and-price")));
    }

    public String getPropertySummary() {
        return driver.findElement(By.cssSelector(".property-details .property-header-bedroom-and-price h1")).getText();
    }
}
