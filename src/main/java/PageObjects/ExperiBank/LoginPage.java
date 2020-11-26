package PageObjects.ExperiBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage
{
    @FindBy(xpath = "//*[@id='usernameTextField']")
    public WebElement txt_userName;

    @FindBy(xpath = "//*[@id='passwordTextField']")
    public WebElement txt_password;

    @FindBy(xpath = "//*[@id='scrollView1']")
    public WebElement btn_login;


}
