package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class verifications extends commonOps
{
    @Step("Verify text in element")
    public static void textInElement(WebElement elem, String expectedValue)
    {
        assertEquals(elem.getText(), expectedValue);
    }

    @Step("Verify number of elements equals to")
    public static void numberOfelements(List<WebElement> elems, int expectedValue)
    {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size() - 1)));
        assertEquals(elems.size(), expectedValue);
    }

    @Step("Verify Text with text")
    public static void text(String actualText, String expectedText)
    {
       assertEquals(actualText, expectedText);
    }

    @Step("Verify Element Visually")
    public static void visualElement(WebElement imageElement, String expectedImageName)
    {
        BufferedImage expectedImage = null;
       try
       {
           expectedImage = ImageIO.read(new File(getData("ImageRepo") + expectedImageName + ".png"));
       }catch (Exception ex)
       {
           System.out.println("Error Reading Image File"+ ex);
       }
        Screenshot imageScreenshot = new AShot().takeScreenshot(driver, imageElement);
        BufferedImage actualImage = imageScreenshot.getImage();
        diff = imagDiff.makeDiff(actualImage, expectedImage);
        assertFalse(diff.hasDiff(), "Images are no the same");

    }






}
