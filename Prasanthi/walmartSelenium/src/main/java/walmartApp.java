//import jdk.internal.math.FloatingDecimal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import  java.lang.*;

import java.util.TreeMap;

public class walmartApp {

        WebDriver driver;

        @BeforeMethod
        public void setup(){
            System.setProperty("webdriver.chrome.driver", "/Users/admin/Downloads/chromedriver");
            driver = new ChromeDriver();

        }
        @AfterMethod
        public void cleanup() {
            //close the Browser
            driver.close();
        }
        public double comparePriceWithAmazon(String walmartProductName, String walmartPrice) {
            double price = 0.0;
            driver.get("https://www.amazon.com/");
            WebElement AmazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
            AmazonSearchBox.sendKeys(walmartProductName);
            WebElement AmazonSearchButton = driver.findElement(By.className("nav-input"));
            AmazonSearchButton.click();

            //taking the title and price and asserting if its equal or not
            String amazonName  =driver.findElement(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']")).getText();
            String amazonPrice =driver.findElement(By.xpath("//*[@class='a-price-whole']")).getText();
            System.out.println("walmart name :" + walmartProductName + " Amazon Name :" + amazonName + " amazon Price : " + amazonPrice);
            SoftAssert sa = new SoftAssert();

            sa.assertEquals(walmartProductName, amazonName, "Product Names do not match between Walmart and Amazon");
            sa.assertEquals(walmartPrice, amazonPrice, " Price does not match");
            sa.assertAll();





            return price;

        }
        @Test
          public void searchProduct() {
            driver.get("https://www.walmart.com/");
            //find search box and enter search string
            WebElement searchBox = driver.findElement(By.id("global-search-input"));
            searchBox.sendKeys("ipad pro");
            WebElement searchButton = driver.findElement(By.id("global-search-submit"));
            searchButton.click();


            // Use of Hashmap to store Products and their prices :
            TreeMap<String, String> walmartPriceMap = new TreeMap<>();
            for(int i=1;i<6;i++){
                String element = driver.findElement(By.xpath("//div[@id='searchProductResult']/ul/li[" +i +"]/div/div[2]/div[5]/div/a")).getText();
                System.out.println(element);
                String Price = driver.findElement(By.xpath("//div[@id='searchProductResult']/ul/li[" + i + "]/div[@class='search-result-gridview-item-wrapper']/div[2]//div[@class='product-price-with-fulfillment']//span[@class='price-main-block']/span/span[@class='visuallyhidden']")).getText();
                System.out.println(Price);
                //float priceConversion = Float.parseFloat(Price.replace("$", ""));
                //System.out.println(priceConversion);
                walmartPriceMap.put(element, Price);
                System.out.println("Product :" + element + " value " + Price);

                //System.out.printf("%d: Name: %s\n",i, li_elements.get(i).getText());
            }

            for(String key : walmartPriceMap.keySet()){
                System.out.println("Key : " + key + " value: " + walmartPriceMap.get(key));
                comparePriceWithAmazon(key,  walmartPriceMap.get(key));

            }








        }


}
