package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.mobileFlows;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class experiBankMobile extends commonOps
{
    @Test(description = "Test01: Login in to ExperiBank")
    @Description("Test description: Login in to ExperiBank")
    public void test01_login()
    {
        mobileFlows.login("company", "company");
        verifications.textInElement(autoPracticeMyAccount.title_myaccount, "MY ACCOUNT");
    }
}
