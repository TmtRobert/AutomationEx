package login;

import base.BaseTests;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTests extends BaseTests {
    @Test
    public void testSuccesfulLogin(){
    LoginPage loginPage = homePage.clickFormAuthentication();
    loginPage.setUsernameField("tomsmith");
    loginPage.setPasswordField("SuperSecretPassword!");
    SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        Assertions.assertTrue(secureAreaPage.getAlertText().
                        contains("You logged into a secure area!"),
                "Alert text is incorrect");
    }
}
