package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchFiltersPage extends BasePage {

    @FindBy(id = "minPrice")
    private WebElement minPriceDropdown;

    @FindBy(id = "maxBedrooms")
    private WebElement maxBedroomsDropdown;

    @FindBy(id = "submit") //Ideally this would be a less generic id, for this page I have made the assumption that the id is unique
    private WebElement findPropertiesButton;

    public SearchFiltersPage(WebDriver driver){
        super(driver);
    };

    public void selectMinPrice(String minPrice) {
      new Select(minPriceDropdown).selectByVisibleText(minPrice);
    }

    public void selectMaxBedrooms(String maxBedrooms) {
        new Select(maxBedroomsDropdown).selectByVisibleText(maxBedrooms);
    }

    public void clickFindPropertiesButton() {
        findPropertiesButton.click();
    }
}
