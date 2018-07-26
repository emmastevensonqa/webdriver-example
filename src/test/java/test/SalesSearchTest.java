package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page.HomePage;
import page.MakeMoreMoneyPage;

import static org.junit.Assert.assertEquals;



public class SalesSearchTest extends BaseTest {

//    private HomePage homePage;
//    private MakeMoreMoneyPage makeMoreMoneyPage;

    @Before
    public void setupTest(){
        super.setupTest();
    }

    @Test
    public void shouldPerformSalesSearch() {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        assertEquals(homePage.getPageTitle(), "Rightmove - UK's number one property website for properties for sale and to rent");
        homePage.clickPostCodeBox();
        homePage.enterPostcode("MK16");
        homePage.clickForSaleButton();
        MakeMoreMoneyPage makeMoreMoneyPage = new MakeMoreMoneyPage(driver);

        /*Find postcode textbox
        * enter MK16
        * Find For Sale button
        * Click for sale button
        * new page object
        * check page has been reached sucessfully
        *  find properties button and click it
        *  new page object
        *  check page reached sucessfully
        *  check property card exists
        *  add Package org.openqa.selenium.support to build.grade
        *  add this to github
        * */
    }

    @After
    public void closeTest(){
        super.closeTest();
    }

}


