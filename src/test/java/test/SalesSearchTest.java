package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import page.HomePage;
import page.MakeMoreMoneyPage;

import static org.junit.Assert.assertEquals;



public class SalesSearchTest extends BaseTest {

    private HomePage homePage;
    private MakeMoreMoneyPage makeMoreMoneyPage;

    @Before
    public void setupTest() throws Exception {
        super.setupTest();

        homePage = PageFactory.initElements(driver, HomePage.class);
        makeMoreMoneyPage = PageFactory.initElements(driver, MakeMoreMoneyPage.class);
    }

    @Test
    public void shouldPerformSalesSearch() {
        homePage.goToHomePage();
        assertEquals(homePage.getPageTitle(), "Rightmove - UK's number one property website for properties for sale and to rent");
        homePage.clickPostCodeBox();
        homePage.enterPostcode("MK16");
        homePage.clickForSaleButton();

        assertEquals(makeMoreMoneyPage.getPageTitle(), "Find property for sale in MK16");
    }

    @After
    public void closeTest(){
        super.closeTest();
    }

}


