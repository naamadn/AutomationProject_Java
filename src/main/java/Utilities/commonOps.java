package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.w3c.dom.Document;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.server.ExportException;
import java.util.concurrent.TimeUnit;

public class commonOps extends base
{
    public static String getData(String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try
        {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e)
        {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    @BeforeClass
    public void StartSession()
    {
        // String platform = "Web";
        if (getData("PlatformName").equalsIgnoreCase("Web"))
            initBrowser(getData("BrowserName"));
             else if(getData("PlatformName").equalsIgnoreCase("Mobile"))
               initMobile();
        else if(getData("PlatformName").equalsIgnoreCase("api"))
            initAPI();
        else
            throw new RuntimeException(("Invalid platform name started"));
        if(!getData("PlatformName").equalsIgnoreCase("api"))
        managePages.init();
        manageDB.iniConnection(getData("dbUrl"), getData("dbUser"), getData("dbPassword"));

    }

    public static  void initAPI()
    {
        RestAssured.baseURI = getData("Url_API");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("user_API"), getData("password_API"));
    }

    public static void initMobile()
    {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
        try
        {
            driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), dc);
        }catch (Exception e)
        {
            System.out.println("Can not connect to Appium server, see details: "+e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);

    }

    public static void initBrowser(String browserType)
    {
        switch (browserType.toLowerCase())
        {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFireFoxDriver();
                break;
            default:
                throw new RuntimeException(("Invalid browser type started"));
        }
        driver.manage().window().maximize();
        driver.get(getData("Url"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("TimeOut")));
        action = new Actions(driver);

    }

    private static WebDriver initFireFoxDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    private static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    @AfterClass
    public void CloseSession()
    {
        manageDB.closeConnection();
        if(!getData("PlatformName").equalsIgnoreCase("api"))
        driver.quit();
    }


    @AfterMethod
    public void afterMethod()
    {
        if(getData("PlatformName").equalsIgnoreCase("Web"))
        driver.get(getData("Url"));
    }
}
