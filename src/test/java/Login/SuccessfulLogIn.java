package Login;

import com.automationpractice.myproject.base.TestUtilities;
import com.automationpractice.myproject.pages.HomePage;
import com.automationpractice.myproject.pages.MyAccountPage;
import com.automationpractice.myproject.pages.RegisterFormPage;
import com.automationpractice.myproject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulLogIn extends TestUtilities {

    @Test
    public void userCanLogIn() {
        HomePage homePage = new HomePage(driver, log);
        homePage.openHomePage();

        SignInPage signInPage = homePage.clickOnSignIn();
        signInPage.typeUsername("johnKowalski2137@wp.pl");
        signInPage.typePassword("tttttt");
        MyAccountPage myAccountPage = signInPage.clickOnLoginButton();

        Assert.assertTrue(myAccountPage.getAccountInfoText().contains("Welcome to your account."));
        Assert.assertEquals(myAccountPage.getHeaderText(), "My account".toUpperCase());
        takeScreenshot("Successful logIn");
    }
}