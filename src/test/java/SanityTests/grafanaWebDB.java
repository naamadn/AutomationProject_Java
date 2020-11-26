package SanityTests;


import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class grafanaWebDB extends commonOps
{
    @Test(description = "Test01: Sign in to website")
    @Description("Test description: Sign in to website")
    public void test01_login()
    {
        webFlows.loginDB();
        verifications.textInElement(autoPracticeMyAccount.title_myaccount, "MY ACCOUNT");
    }

}
