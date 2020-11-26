package Helpers;

import Utilities.commonOps;
import Utilities.helperMethods;
import org.testng.annotations.Test;

public class  visualTesting extends commonOps
{
    //@Test
    public void createScreenShot()
    {
        helperMethods.takeElementScreenShot(autoPracticeCatalogTopMenu.img_logo, "logo");
    }
}
