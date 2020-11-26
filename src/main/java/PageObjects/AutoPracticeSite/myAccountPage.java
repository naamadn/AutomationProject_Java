package PageObjects.AutoPracticeSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage
{
    @FindBy(xpath = "//h1[@class = 'page-heading']")
    public WebElement title_myaccount;

    @FindBy(xpath = "//a[@class = 'logout']")
    public WebElement btn_logOut;
}
