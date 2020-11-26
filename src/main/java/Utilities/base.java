package Utilities;

import PageObjects.AutoPracticeSite.authenticationPage;
import PageObjects.AutoPracticeSite.createAnAccountPage;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class base
{
    // driver was defined as static, in order to get its initialized value in all of its derived classes
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    public static Screenshot imageScreenshot;
    public static ImageDiffer imagDiff = new ImageDiffer();
    public static ImageDiff diff;

    public static DesiredCapabilities dc = new DesiredCapabilities();
    public static PageObjects.ExperiBank.LoginPage experiBankLogin;

    public static authenticationPage autoPracticeAuthentication;
    public static PageObjects.AutoPracticeSite.myAccountPage autoPracticeMyAccount;
    public static createAnAccountPage autoPracticeCreateAnAccount;
    public static PageObjects.AutoPracticeSite.catalogTopMenu autoPracticeCatalogTopMenu;
    public static PageObjects.AutoPracticeSite.summerDressesPage autoPracticeSummerDresses;
    public  static PageObjects.AutoPracticeSite.shoppingCartPage autoPracticeShoppingCart;
    public static PageObjects.AutoPracticeSite.addressesPage autoPracticeAddresses;
    public static PageObjects.AutoPracticeSite.shippingPage autoPracticeShipping;
    public static PageObjects.AutoPracticeSite.paymentMethodPage autoPracticePaymentMethod;
    public static PageObjects.AutoPracticeSite.orderSummeryPage autoPracticeOrderSummery;
    public static PageObjects.AutoPracticeSite.orderConfirmationPage autoPracticeOrderConfirmation;

    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;

    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject requestParams = new JSONObject();
    public static JsonPath jp;




}
