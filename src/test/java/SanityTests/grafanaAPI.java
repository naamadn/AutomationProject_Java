package SanityTests;

import Extensions.apiActions;
import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.apiFlows;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class grafanaAPI extends commonOps
{
    @Test(description = "Test01: Get Users List From Grafana")
    @Description("Test description: Login to Grafana and get users list")
    public void test01_getUsersList()
    {
      verifications.text(apiFlows.getUserProperty("[0].login"), "admin");
    }

    @Test(description = "Test02: Create New User To Grafana")
    @Description("Test description: Create New User To Grafana")
    public void test02_createNewUser()
    {
        apiFlows.postUser("User3", "User3@user.com", "User2", "1234");
        verifications.text(apiFlows.getUserProperty("[0].name"), "User2");
    }

    ///TBD - store the id of a created user and retrieve in update/delete
    @Test(description = "Test03: Update User Details")
    @Description("Test description: Update User Details")
    public void test03_updateUser()
    {
        apiFlows.updateUser("4", "User234", "User2@user.com", "User2");
        verifications.text(apiFlows.getUserProperty("[0].name"), "User234");
    }

    @Test(description = "Test04: Delete User")
    @Description("Test description: Delete User")
    public void test04_deleteUser()
    {
        apiFlows.deleteUser("7");
        verifications.text(apiFlows.getUserProperty("[0].id"), "1");
    }

}
