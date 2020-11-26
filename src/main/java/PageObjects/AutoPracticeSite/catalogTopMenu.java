package PageObjects.AutoPracticeSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class catalogTopMenu
{
    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
    public WebElement opt_dresses;

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/ul/li[3]/a")
    public WebElement opt_summerDresses;

    @FindBy(xpath = "//div[@class = 'product-atributes']")
    public WebElement dropdown_prodAtributes;

    @FindBy(xpath = "//*[@id='button_order_cart']/span")
    public WebElement btn_orderCart;

    @FindBy(xpath = "//div[@class = 'shopping_cart']/a")
    public WebElement btn_cart;

    @FindBy(css = "a[class = 'login")
    public WebElement btn_login;

   @FindBy(css = "img[class = 'logo img-responsive")
    public WebElement img_logo;

}
