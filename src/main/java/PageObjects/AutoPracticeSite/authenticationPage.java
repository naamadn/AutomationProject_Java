package PageObjects.AutoPracticeSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class authenticationPage
{
    @FindBy(id  = "email")
    public WebElement txt_email;

    @FindBy(id = "passwd")
    public WebElement txt_password;

    @FindBy(id = "SubmitLogin")
    public WebElement btn_login;

    @FindBy(id = "email_create")
    public WebElement txt_emailCreate;

    @FindBy(xpath = "//button[@class = 'btn btn-default button button-medium exclusive']")
    public WebElement btn_createAccount;
}
