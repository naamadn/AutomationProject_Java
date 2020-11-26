package PageObjects.AutoPracticeSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class orderConfirmationPage
{
    @FindBy(xpath = "//p[@class = 'cheque-indent']")
    public WebElement lbl_confirmationTitle;
}
