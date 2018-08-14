package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import page.HomePage;
import page.SearchFiltersPage;
import page.SearchResultsPage;
import page.SinglePropertyPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SalesSearchTest extends BaseTest {

    private HomePage homePage;
    private SearchFiltersPage searchFiltersPage;
    private SearchResultsPage searchResultsPage;
    private SinglePropertyPage singlePropertyPage;

    @Before
    public void setupTest() throws Exception {
        super.setupTest();

        homePage = PageFactory.initElements(driver, HomePage.class);
        searchFiltersPage = PageFactory.initElements(driver, SearchFiltersPage.class);
        searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        singlePropertyPage = PageFactory.initElements(driver, SinglePropertyPage.class);
    }

    @Test
    public void shouldPerformSalesSearch() {
        homePage.goToHomePage();
        assertEquals("Rightmove - UK's number one property website for properties for sale and to rent", homePage.getPageTitle());
        homePage.clickPostCodeBox();
        homePage.enterPostcode("NE1");
        homePage.clickForSaleButton();
        //Wait for Page2 to load

        assertEquals("Find property for sale in NE1", searchFiltersPage.getPageTitle());
        //assert search fitlers form is present

        searchFiltersPage.selectMinPrice("100,000");
        searchFiltersPage.selectMaxBedrooms("2");
        searchFiltersPage.clickFindPropertiesButton();
        //Wait for search results page to load

        assertEquals("Properties For Sale in NE1 - Flats & Houses For Sale in NE1 - Rightmove", searchResultsPage.getPageTitle());
        assertEquals("Properties For Sale in NE1, at least £100,000, up to 2 bed", searchResultsPage.getSearchFilterTitle());

        searchResultsPage.changeSortOrder("Newest Listed");
        assertEquals("Newest Listed", searchResultsPage.getSelectedSortOrderText());

        assertTrue(searchResultsPage.checkZeroResultsIsNotDisplayed());
        searchResultsPage.clickNormalPropertySummaryByIndex(0);
        //Wait for property details page to load

        //assertEquals(singlePropertyPage.getPageTitle(), propertySummary);
        //assert property details image gallery
    }

    @After
    public void closeTest(){
       super.closeTest();
    }

}


