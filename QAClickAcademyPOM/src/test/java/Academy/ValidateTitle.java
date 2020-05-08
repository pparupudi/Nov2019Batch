package Academy;

import PageObjects.LandingPage;
import Resources.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;



import java.io.IOException;


public class ValidateTitle extends Base {
//log4j intialization
    public Logger log = LogManager.getLogger(Base.class.getName());







@Test
    public void basePageNavigation() throws IOException, InterruptedException {
    driver = intializeDriver();
    log.info("Driver is intialized");
    driver.get(prop.getProperty("url"));
    log.info("Navigated to Home Page");

        //one is Inheritence
        //creating object to that class and invoke methods of it
        LandingPage l = new LandingPage(driver);
        //compare the text from the browser with actual value
        Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");


    }



    @AfterTest
    public void tearDown(){
        driver.close();
        driver=null;

    }
}
