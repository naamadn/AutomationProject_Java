package WorkFlows;

import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

public class mobileFlows extends commonOps
{
    @Step("Log in to ExperiBank Flow")
    public static void login(String user, String password)
    {
        uiActions.updateText(experiBankLogin.txt_userName, user);
        uiActions.updateText(experiBankLogin.txt_password, password);
        uiActions.click(experiBankLogin.btn_login);
    }

}
