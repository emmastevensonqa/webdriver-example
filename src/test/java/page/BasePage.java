package page;

import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //pages extend from here
    //helpers, generic, reusable

    public String getPageTitle() {
        return driver.getTitle();
    }
}
