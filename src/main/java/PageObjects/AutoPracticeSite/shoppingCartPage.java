package PageObjects.AutoPracticeSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class shoppingCartPage
{
    @FindBy(xpath = "//*[@id= 'center_column']/p[2]/a[1]/span")
    public WebElement btn_proceedToCheckOut;
}
