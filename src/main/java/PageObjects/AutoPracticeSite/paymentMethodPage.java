package PageObjects.AutoPracticeSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class paymentMethodPage
{
    @FindBy(css = "a[class = 'bankwire")
    public WebElement btn_payByBankWire;
}
