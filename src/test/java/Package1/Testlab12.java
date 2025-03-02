package Package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testlab12 {

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void login(){
    driver.get("https://www.saucedemo.com/");

    }


    @AfterSuite
    public void  closebrowser(){
        driver.quit();
    }

    @Test (priority = 2)
    public void addtocart(){
     String actual = driver.getCurrentUrl();

        Assert.assertEquals(actual, "https://www.saucedemo.com/");
    }
    @Test (priority = 1)
    public void removefromcart(){

    }
}
