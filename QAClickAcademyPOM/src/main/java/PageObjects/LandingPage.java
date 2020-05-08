package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public  WebDriver driver;
   By SignIn =  By.cssSelector("a[href *='sign_in']");
   By Title =  By.cssSelector("section#content h2");
   By nav = By.cssSelector(".nav.navbar-nav.navbar-right");

   //Thread.sleep(10000);

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogin() throws InterruptedException {
        //Thread.sleep(10000);

       return driver.findElement(SignIn);

   }

    public WebElement getNav() throws InterruptedException {
        Thread.sleep(10000);

        return driver.findElement(nav);

    }

    public WebElement getTitle() throws InterruptedException {
        //Thread.sleep(10000);

        return driver.findElement(Title);

    }
}
