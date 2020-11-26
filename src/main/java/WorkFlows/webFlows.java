package WorkFlows;

import Extensions.dbActions;
import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;



import javax.swing.*;
import java.util.List;

public class webFlows extends commonOps
{
    @Step("Sign in to website Flow")
    public static void login(String user, String password)
    {
        uiActions.click(autoPracticeCatalogTopMenu.btn_login);
        uiActions.updateText(autoPracticeAuthentication.txt_email, user);
        uiActions.updateText(autoPracticeAuthentication.txt_password, password);
        uiActions.click(autoPracticeAuthentication.btn_login);
    }

    @Step("Sign out from website Flow")
    public static void signUp(String email)
    {
        uiActions.click(autoPracticeCatalogTopMenu.btn_login);
        uiActions.updateText(autoPracticeAuthentication.txt_emailCreate, email);
        uiActions.click(autoPracticeAuthentication.btn_createAccount);
    }

    @Step("Create an account with mandatory setails Flow")
    public static void createAnAccountWithmandatoryDetails(String title, String firstName, String lastName, String password, String address, String city, String state, String zip, String phone)
    {
        if (title.equalsIgnoreCase("Mr"))
        uiActions.click(autoPracticeCreateAnAccount.radiobtn_Mr);
        else
        uiActions.click(autoPracticeCreateAnAccount.radiobtn_Mrs);
        uiActions.updateText(autoPracticeCreateAnAccount.txt_firstName, firstName);
        uiActions.updateText(autoPracticeCreateAnAccount.txt_lastName, lastName);
        uiActions.updateText(autoPracticeCreateAnAccount.txt_password, password);
        uiActions.updateText(autoPracticeCreateAnAccount.txt_firstNameForAddress, firstName);
        uiActions.updateText(autoPracticeCreateAnAccount.txt_lastNameForAddress, lastName);
        uiActions.updateText(autoPracticeCreateAnAccount.txt_addressMandatory, address);
        uiActions.updateText(autoPracticeCreateAnAccount.txt_city, city);
        uiActions.updateDropDown(autoPracticeCreateAnAccount.dropdown_state, state);
        uiActions.updateText(autoPracticeCreateAnAccount.txt_postcode, zip);
        uiActions.updateDropDown(autoPracticeCreateAnAccount.dropdown_country, "United States");
        uiActions.updateText(autoPracticeCreateAnAccount.txt_phone, phone);
        uiActions.click(autoPracticeCreateAnAccount.btn_submitAccount);

    }

    @Step("Perform purchase Flow")
    public static void purchase()
    {
        List<WebElement> listOfItems = autoPracticeSummerDresses.listOfProducts;

        uiActions.mouseHoverElements(autoPracticeCatalogTopMenu.opt_dresses, autoPracticeCatalogTopMenu.opt_summerDresses);
        uiActions.checkItemInCheckBox(autoPracticeSummerDresses.chkbox_smallSize);
        uiActions.checkItemInCheckBox(autoPracticeSummerDresses.chk_inStock);
        uiActions.updateDropDown(autoPracticeSummerDresses.dropdown_sortBy,"Price: Lowest first");
        uiActions.addToCart(listOfItems.get(0));
        uiActions.click(autoPracticeSummerDresses.btn_proceedToCheckout);
        uiActions.mouseHoverElements(autoPracticeCatalogTopMenu.btn_cart, autoPracticeCatalogTopMenu.btn_orderCart);
        uiActions.click(autoPracticeShoppingCart.btn_proceedToCheckOut);
        uiActions.click(autoPracticeAddresses.btn_proceedToCheckout);
        uiActions.click(autoPracticeShipping.chkbox_termOfService);
        uiActions.click(autoPracticeShipping.btn_proceedToCheckout);
        uiActions.click(autoPracticePaymentMethod.btn_payByBankWire);
        uiActions.click(autoPracticeOrderSummery.btn_confirm);


    }

    @Step("Sign in to website Flow with DB credentials")
    public static void loginDB()
    {
      List<String>cred   =  dbActions.getCredentials("SELECT User_name, Password FROM Users WHERE id='5'");
       uiActions.click(autoPracticeCatalogTopMenu.btn_login);
       uiActions.updateText(autoPracticeAuthentication.txt_email, cred.get(0));
        uiActions.updateText(autoPracticeAuthentication.txt_password, cred.get(1));
        uiActions.click(autoPracticeAuthentication.btn_login);
    }

}
