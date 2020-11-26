package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class uiActions extends commonOps
{
    @Step("Click On Element")
    public static void click(WebElement elem)
    {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Send Text to txt-field")
    public static void updateText(WebElement elem, String value)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(value);
    }

    @Step("Update dropdown field")
    public static void updateDropDown(WebElement elem, String value)
    {
        Select myValue = new Select(elem);
        myValue.selectByVisibleText(value);
    }

    @Step("Mouse hover to Element")
    public static void mouseHoverElements(WebElement elem1, WebElement elem2)
    {
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }
    @Step("check Item In CheckBox")
    public static void checkItemInCheckBox(WebElement elem)
    {
      //  wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    public static void addToCart(WebElement elem)
    {
        uiActions.mouseHoverElements(elem, autoPracticeSummerDresses.btn_addToCart);
    }



}
