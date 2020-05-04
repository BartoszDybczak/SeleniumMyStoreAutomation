package HomePage;

import com.automationpractice.myproject.base.TestUtilities;
import com.automationpractice.myproject.pages.*;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class HomePageTests extends TestUtilities {

    @Test
    public void userCanSeeContactNumber() {
        HomePage homePage = new HomePage(driver, log);
        homePage.openHomePage();

        String expectedPhoneNumber = "0123-456-789";
        Assert.assertEquals(homePage.getPhoneNumberText(), expectedPhoneNumber);
    }

    @Test
    public void userCanClickOnItemCard() {
        HomePage homePage = new HomePage(driver, log);
        homePage.openHomePage();

        ItemDetailPage itemDetailPage = homePage.clickOnCard();

        String expectedPrice = "$16.51";
        Assert.assertEquals(itemDetailPage.getPriceText(), expectedPrice);
    }

    @Test
    public void userCanSearchForAnItem() {
        HomePage homePage = new HomePage(driver, log);
        Search search = new Search(driver, log);

        homePage.openHomePage();
        search.searchForItem("dress");
        search.clickOnSearchButton();

        Assert.assertTrue(search.getSearchHeaderText().contains("SEARCH"));
        String expectedItem = "\"DRESS\"";
        Assert.assertEquals(search.getDressText(), expectedItem);
        String msg = "7 results have been found.";
        Assert.assertEquals(search.getResultsFoundText(), msg);
    }

    @Test
    public void userCanWriteEmailMessage() {
        HomePage homePage = new HomePage(driver, log);
        homePage.openHomePage();

        ContactUsPage contactUsPage = homePage.clickOnContactUs();

        contactUsPage.selectSubject("Customer service");

        String subjectText = "Customer service";
        Assert.assertEquals(contactUsPage.getSubjectText(), subjectText);

        String customerServiceHeaderText = "Customer service - Contact us";
        Assert.assertEquals(contactUsPage.getCustomerServiceText(), customerServiceHeaderText.toUpperCase());

        contactUsPage.typeEmail("johnKowalski2137@wp.pl");

        String userEmail = "johnKowalski2137@wp.pl";
        Assert.assertEquals(contactUsPage.getEmailText(), userEmail);

        contactUsPage.typeOrder("X3670D");

        String userOrder = "X3670D";
        Assert.assertEquals(contactUsPage.getOrderText(), userOrder);

        String userMessage = "Generic message with complaint";

        contactUsPage.typeMessageText(userMessage);

        String userMessageText = "Generic message with complaint";
        Assert.assertTrue(contactUsPage.getUserMessageText().contains(userMessageText));

        contactUsPage.clickOnUploadFile();

        String fileName = "Rare pepe2.jpg";
        Assert.assertTrue(contactUsPage.getUploadedFileText().contains(fileName));

        contactUsPage.clickOnSubmitButton();

        String successMsg = "Your message has been successfully sent to our team.";
        Assert.assertEquals(contactUsPage.getSuccessMessage(), successMsg);
    }
}