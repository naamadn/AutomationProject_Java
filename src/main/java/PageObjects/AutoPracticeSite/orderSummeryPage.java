package PageObjects.AutoPracticeSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class orderSummeryPage
{
    @FindBy(xpath = "//*[@id= 'cart_navigation']/button/span")
    public WebElement btn_confirm;
}
