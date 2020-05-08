package Academy;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Homepage extends Base {







    @Test(dataProvider = "getData")
    public void basePageNavigation(String Username, String Password) throws IOException, InterruptedException {

        driver = intializeDriver();
        driver.get(prop.getProperty("url"));

        //one is Inheritence
        //creating object to that class and invoke methods of it

        LandingPage l = new LandingPage(driver);
        l.getLogin().click();

        LoginPage lp = new LoginPage(driver);
        lp.getEmail().sendKeys(Username);
        lp.getPassword().sendKeys(Password);
        lp.getSubmit().click();
        //Assert.assertTrue(l.getNav().isDisplayed());


    }


    @DataProvider
    public Object[][] getData(){
        //Row stands for how many data types test should run
        //columns stands for how many values per each test
        Object[][] data = new Object[2][2];
        // restricted user
        data[0][0] = "p@goo.com";
        data[0][1] = "12";
        //non restricted user
        data[1][0] = "prasanthi.parupudi@gmail.com";
        data[1][1] = "123456";
        return data;




    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver=null;

    }
}
