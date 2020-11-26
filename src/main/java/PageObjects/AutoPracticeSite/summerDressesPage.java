package PageObjects.AutoPracticeSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class summerDressesPage
{
    @FindBy (xpath = "//*[@id='layered_id_attribute_group_1']")
    public WebElement chkbox_smallSize;

    @FindBy(id = "layered_quantity_1")
    public WebElement chk_inStock;

    @FindBy(id = "selectProductSort")
    public WebElement dropdown_sortBy;

    @FindBy(xpath = "//div[@class = 'product-container']")
    public List<WebElement> listOfProducts;

    @FindBy(xpath = "//a[@class = 'button ajax_add_to_cart_button btn btn-default']")
    public WebElement btn_addToCart;

    @FindBy(xpath = "//a[@class = 'btn btn-default button button-medium']")
    public WebElement btn_proceedToCheckout;



}
