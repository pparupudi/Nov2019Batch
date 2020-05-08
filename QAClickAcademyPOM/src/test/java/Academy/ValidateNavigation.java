package Academy;

import PageObjects.LandingPage;
import Resources.Base;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidateNavigation extends Base {






    @Test
    public void basePageNavigation() throws IOException, InterruptedException {
        driver = intializeDriver();
        driver.get(prop.getProperty("url"));

        //one is Inheritence
        //creating object to that class and invoke methods of it
        LandingPage l = new LandingPage(driver);
        //compare the text from the browser with actual value
        //Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");
        Assert.assertTrue(l.getNav().isDisplayed());


    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver=null;

    }
}
