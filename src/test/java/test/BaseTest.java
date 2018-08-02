package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.URL;
import java.util.Optional;

public class BaseTest {

//setup test
    // helper to run test

    WebDriver driver;

    //null check on chromedriver in resources
    //set chrome driver path if not null
    //else throw exception

    public void setupTest() throws Exception {
        URL chromeDriverUrl = ClassLoader.getSystemResource("chromedriver");

        if (chromeDriverUrl != null) {
            String chromeDriverPath = chromeDriverUrl.getPath();
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        } else {
            throw new Exception("ChromeDriver not found in resources directory");
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    public void closeTest() {
        driver.close();
    }
}
