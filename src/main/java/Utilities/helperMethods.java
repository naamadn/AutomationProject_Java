package Utilities;

import Extensions.uiActions;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.io.File;

public class helperMethods extends commonOps
{
    public static void takeElementScreenShot(WebElement imageElement, String imageName)
    {
        imageScreenshot = new AShot().
        coordsProvider(new WebDriverCoordsProvider()).
        takeScreenshot(driver, imageElement);
        try
        {
          ImageIO.write(imageScreenshot.getImage(), "png", new File(getData("ImageRepo") + imageName + ".png"));
        } catch (Exception e)
        {
            System.out.println("error writing image file, see details: " + e);
        }


    }


}
