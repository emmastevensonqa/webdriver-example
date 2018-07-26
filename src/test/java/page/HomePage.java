package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final String URL = "http://www.rightmove.co.uk";
    private static final String PostCodeBoxID = "searchLocation";
    private static final String ForSaleBox = "buy";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage() {
        driver.get(URL);
    }

    public void clickPostCodeBox() {
        driver.findElement(By.id(PostCodeBoxID)).click();
    }

    public void enterPostcode(String postcode) {
        driver.findElement(By.id(PostCodeBoxID)).sendKeys(postcode);
    }

    public void clickForSaleButton(){
        driver.findElement(By.id(ForSaleBox)).click();
    }
}
