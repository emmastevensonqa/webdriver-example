package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage extends BasePage {
    @FindBy(css = "[data-test='header-title']")
    private WebElement searchFilterTitle;

    @FindBy(id = "sortType")
    private WebElement sortType;

    @FindBy(css = ".propertyCard:not(.propertyCard--featured)")
    private List<WebElement> normalPropertyCards;

    @FindBy(className = "enhancedZeroResults-title")
    private WebElement zeroResultsTitle;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("propertySearch-results-container")));
    }

    public void changeSortOrder(String sortOrder) {
        Select sortTypeDropdown = new Select(sortType);
        sortTypeDropdown.selectByVisibleText(sortOrder);
        waitForResultsToFinishLoading();
    }

    public void clickNormalPropertySummaryByIndex(int propertyIndex) {
        normalPropertyCards.get(propertyIndex).click();
    }

    public String getSearchFilterTitle() {
        return searchFilterTitle.getText();
    }

    public String getSelectedSortOrderText() {
        Select sortTypeDropdown = new Select(sortType);
        return sortTypeDropdown.getFirstSelectedOption().getText();
    }

    public boolean checkZeroResultsIsNotDisplayed() {
        return !zeroResultsTitle.isDisplayed();
    }

    private void waitForResultsToFinishLoading() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("searchLoading--active")));
    }

    public String getNormalPropertySummaryByIndex(int propertyIndex) {
        return normalPropertyCards.get(propertyIndex).findElement(By.className("propertyCard-title")).getText();
    }
}
