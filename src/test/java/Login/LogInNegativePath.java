package Login;

import com.automationpractice.myproject.base.TestUtilities;
import com.automationpractice.myproject.pages.HomePage;
import com.automationpractice.myproject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LogInNegativePath extends TestUtilities {

    @Parameters({"email", "password", "expectedMessage"})
    @Test
    public void LogInNegative(String email, String password, String expectedMessage) {
        HomePage homePage = new HomePage(driver, log);

        homePage.openHomePage();

        SignInPage signInPage = homePage.clickOnSignIn();
        signInPage.typeUsername(email);
        signInPage.typePassword(password);
        signInPage.clickOnLoginButton();

        Assert.assertTrue(signInPage.getErrorText().contains(expectedMessage));
    }
}