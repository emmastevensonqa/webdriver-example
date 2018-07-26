package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.HomePage;

import java.io.File;

public class BaseTest {

//setup test
    // helper to run test

    WebDriver driver;

    public void setupTest(){
        File resourcesPath = new File("src/test/resources/chromedriver");
        System.setProperty("webdriver.chrome.driver", resourcesPath.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    public void closeTest() {
        driver.close();
    }
}
