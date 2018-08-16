package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.URL;

public class BaseTest {

    WebDriver driver;

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
