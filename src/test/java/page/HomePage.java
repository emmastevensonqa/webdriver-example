package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(id = "searchLocation") //gives more info in an easy to read way
    private WebElement postCodeBoxID;

    private static final String URL = "http://www.rightmove.co.uk";
    private static final String ForSaleBox = "buy";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage() {
        driver.get(URL);
    }

    public void clickPostCodeBox() {
        postCodeBoxID.click();
    }

    public void enterPostcode(String postcode) {
        postCodeBoxID.sendKeys(postcode);
    }

    public void clickForSaleButton(){
        driver.findElement(By.id(ForSaleBox)).click();

    }
}
