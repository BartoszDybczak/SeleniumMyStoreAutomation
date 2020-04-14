package HomePage;

import com.automationpractice.myproject.base.TestUtilities;
import com.automationpractice.myproject.pages.HomePage;
import com.automationpractice.myproject.pages.SearchResultsPage;
import com.automationpractice.myproject.pages.XD;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestUtilities {

    @Test
    public void assertContactNumberDisplayed() {
        HomePage homePage = new HomePage(driver,log);
        homePage.openHomePage();

        homePage.clickOnCard();



        //String expectedPhoneNumber = "0123-456-789";

        //Assert.assertEquals(homePage.getPhoneNumberText(),expectedPhoneNumber);
    }

    @Test
    public void assertUserCanSearchForItems() {
        HomePage homePage = new HomePage(driver,log);
        homePage.openHomePage();

        homePage.searchForDress("dress");

        SearchResultsPage searchResultsPage = homePage.clickOnSearchButton();

        String expectedMsg = "\"DRESS\"";

        Assert.assertEquals(expectedMsg, searchResultsPage.getSearchText());
    }
}