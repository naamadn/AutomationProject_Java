package SanityTests;

import Extensions.uiActions;
import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class autoPracticeWeb extends commonOps
{
    @Test(description = "Test01: Sign in to website")
    @Description("Test description: Sign in to website")
    public void test01_login()
    {
        webFlows.login("original.user@yandex.com", "123456");
        verifications.textInElement(autoPracticeMyAccount.title_myaccount, "MY ACCOUNT");
    }

    @Test(description = "Test02: Perform Purchase")
    @Description("Test description:  Perform Purchase")
    public void test02_performPurchase()
    {
        webFlows.purchase();
        verifications.textInElement(autoPracticeOrderConfirmation.lbl_confirmationTitle, "Your order on My Store is complete.");
    }

    @Test(description = "Test03: Sign out from website")
    @Description("Test description:  Sign out from website")
    public void test03_logout()
    {
        uiActions.click(autoPracticeMyAccount.btn_logOut);
    }

    @Test(description = "Test04: Sign up for website")
    @Description("Test description:  Sign up for website")
    public void test04_register()
    {
      webFlows.signUp("ert@hfr1.com");
      webFlows.createAnAccountWithmandatoryDetails("Mrs", "Donna", "Martin", "98765", "Beverly Hill", "Los Angeles", "California", "90210", "032567890");
      verifications.textInElement(autoPracticeMyAccount.title_myaccount, "MY ACCOUNT");
    }

    @Test(description = "Test05: Verify Logo")
    @Description("Test description:  Verify Logo")
    public void test05_verifyLogo()
    {
        verifications.visualElement(autoPracticeCatalogTopMenu.img_logo, "logo");

    }

}
