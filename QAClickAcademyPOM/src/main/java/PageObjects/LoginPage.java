package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;
    By Email =  By.xpath("//*[contains(@type,'email')]");
    By PassWord = By.xpath("//*[contains(@id,'user_password')]");
    By Submit = By.xpath("//*[contains(@type,'submit')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmail(){

        return driver.findElement(Email);

    }
    public WebElement getPassword(){

        return driver.findElement(PassWord);

    }
    public WebElement getSubmit(){

        return driver.findElement(Submit);

    }
}
