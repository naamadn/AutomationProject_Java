package Utilities;

import PageObjects.AutoPracticeSite.authenticationPage;
import PageObjects.AutoPracticeSite.createAnAccountPage;
import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{
    public static void init()
    {
        autoPracticeAuthentication = PageFactory.initElements(driver, authenticationPage.class);
        autoPracticeMyAccount = PageFactory.initElements(driver, PageObjects.AutoPracticeSite.myAccountPage.class);
        autoPracticeCreateAnAccount = PageFactory.initElements(driver, createAnAccountPage.class);
        autoPracticeCatalogTopMenu = PageFactory.initElements(driver, PageObjects.AutoPracticeSite.catalogTopMenu.class);
        autoPracticeSummerDresses = PageFactory.initElements(driver, PageObjects.AutoPracticeSite.summerDressesPage.class);
        autoPracticeShoppingCart = PageFactory.initElements(driver, PageObjects.AutoPracticeSite.shoppingCartPage.class);
        autoPracticeAddresses = PageFactory.initElements(driver, PageObjects.AutoPracticeSite.addressesPage.class);
        autoPracticeShipping = PageFactory.initElements(driver, PageObjects.AutoPracticeSite.shippingPage.class);
        autoPracticePaymentMethod = PageFactory.initElements(driver, PageObjects.AutoPracticeSite.paymentMethodPage.class);
        autoPracticeOrderSummery = PageFactory.initElements(driver, PageObjects.AutoPracticeSite.orderSummeryPage.class);
        autoPracticeOrderConfirmation = PageFactory.initElements(driver, PageObjects.AutoPracticeSite.orderConfirmationPage.class);

        experiBankLogin = PageFactory.initElements(driver, PageObjects.ExperiBank.LoginPage.class);
    }

}
