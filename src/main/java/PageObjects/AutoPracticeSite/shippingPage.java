package PageObjects.AutoPracticeSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class shippingPage
{
  @FindBy(id = "uniform-cgv")
    public WebElement chkbox_termOfService;

  @FindBy(name = "processCarrier")
    public WebElement btn_proceedToCheckout;
}
