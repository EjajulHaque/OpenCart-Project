package testCases;
import org.testng.annotations.Test;
import pageObject.AccountRegistrationPage;

import pageObject.HomePage;
import testBase.BaseClass;


public class TC0001_AccountRegistrationTest {
    public class TC001_AccountRegistrationTest extends BaseClass{

        @Test
        public void verifyAccountRegistration(){
            HomePage hp=new HomePage(driver);
            hp.clickMyAccount();
            hp.clickRegister();
            AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
            regPage.setTxtFirstName(randomString().toUpperCase());
            regPage.setTxtLastName(randomString().toUpperCase());
            regPage.setTxtEmail(randomString()+"@gmail.com");
            regPage.setTxtTelephone(randomNumber());
            regPage.setTxtPassword(randomAlphaNumeric());
            regPage.setTxtConfirmPassword(randomAlphaNumeric());
            regPage.setPrivacyPolicy();
            regPage.clickButton();
        }

    }
}
