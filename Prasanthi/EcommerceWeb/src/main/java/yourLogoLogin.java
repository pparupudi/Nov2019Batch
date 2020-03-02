import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import javax.swing.*;

public class yourLogoLogin {


    @BeforeTest
    public static <StaleElementException> void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();
        // Launch the URL
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("Sign in")).click();

        //page refresh as we are navigating to other page.refresh operation ensures that all the web elements of a page are loaded completely
        driver.navigate().refresh();

        //retrieving  email
        By EmailID = By.id("email");
        WebElement id = driver.findElement(EmailID);
        id.sendKeys("training.qaprep@gmail.com");


        //retrieving  password
        By PassWord = By.id("passwd");
        WebElement password = driver.findElement(PassWord);
        password.sendKeys("Testing123");


        By Submit = By.id("SubmitLogin");
        WebElement submit = driver.findElement(Submit);
        submit.click();


        //Instantiate Action Class
        Actions actions = new Actions(driver);

        //Retrieve WebElement and performing mouse hover
        WebElement target = driver.findElement(By.className("sf-with-ul"));

        actions.moveToElement(target).perform();


        //Now Selecting sub-element
        WebElement shirt = driver.findElement(By.cssSelector("body.my-account.hide-left-column.hide-right-column.lang_en:nth-child(2) div.header-container div.container div.row div.sf-contener.clearfix.col-lg-12:nth-child(6) ul.sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows ul.submenu-container.clearfix.first-in-line-xs li:nth-child(1) ul:nth-child(2) li:nth-child(1) > a:nth-child(1)"));
        actions.moveToElement(shirt);
        actions.click().build().perform();


        //Creating the JavascriptExecutor interface object by Type casting
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Vertical scroll down by 500  pixels
        js.executeScript("window.scrollBy(0,500)");

        // Moving to Product
        WebElement More = driver.findElement(By.xpath("//a[@class='product_img_link']"));
        actions.moveToElement(More);
        actions.click().build().perform();

        // Increasing quantity to 2.
        WebElement plusButton = driver.findElement(By.xpath("//i[@class='icon-plus']"));
        actions.moveToElement(plusButton);
        actions.click().build().perform();

        //Select size 'L' and color
        Select size = new Select(driver.findElement(By.id("group_1")));
        size.selectByVisibleText("L");
        size.selectByIndex(2);

        //Selecting the color
        WebElement color = driver.findElement(By.xpath("//a[@id='color_14']"));
        actions.moveToElement(color);
        actions.click().build().perform();

        //Clicking on the add button
        By AddButton = By.xpath("//button[@name='Submit']");
        WebElement AddTo = driver.findElement(AddButton);
        AddTo.click();

        //Proceed to checkout
        Thread.sleep(5000);
        WebElement checkOut = driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']"));
        checkOut.click();

        //Scrolling down and clicking on the summary page proceed to checkout button
        js.executeScript("window.scrollBy(0,1000)");
        WebElement summaryButton = driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']"));
        summaryButton.click();

        //Scrolling down and clicking on the summary page proceed to Address
        js.executeScript("window.scrollBy(0,1000)");
        WebElement AdressButton = driver.findElement(By.xpath("//button[@name='processAddress']"));
        AdressButton.click();

        //Scrolling down and clicking on the Shipping page Proceed to payment
        WebElement ShippingButton = driver.findElement(By.xpath("//button[@name='processCarrier']"));
        WebElement CheckBox = driver.findElement(By.xpath("//div[@id='uniform-cgv']"));
        CheckBox.click();
        ShippingButton.click();


        //Pay By Cheque
        js.executeScript("window.scrollBy(0,900)");
        WebElement payByCheck = driver.findElement(By.xpath("//a[@class='cheque']"));
        payByCheck.click();


        //Confirmation order
        js.executeScript("window.scrollBy(0,900)");
        WebElement ConfirmOrder = driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']"));
        ConfirmOrder.click();

        //Assert the text
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Order confirmation - My Store";
        Assert.assertEquals(ActualTitle, ExpectedTitle);
        System.out.println("Assert Passed");
        System.out.println(ActualTitle);


        //Close the Browser
        driver.close();


    }
}
