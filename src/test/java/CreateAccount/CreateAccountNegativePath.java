package CreateAccount;

        import com.automationpractice.myproject.base.TestUtilities;
        import com.automationpractice.myproject.pages.SignInPage;
        import org.testng.Assert;
        import org.testng.annotations.Parameters;
        import org.testng.annotations.Test;

public class CreateAccountNegativePath extends TestUtilities {

    @Parameters({"email", "expectedMessage"})
    @Test
    public void createAccountIncorrectPath(String email, String expectedMessage) {
        SignInPage signInPage = new SignInPage(driver, log);

        signInPage.openSignInPage();
        signInPage.createAccountEmail(email);
        signInPage.clickOnCreateAccount();

        Assert.assertTrue(signInPage.getErrorText().contains(expectedMessage));
    }
}