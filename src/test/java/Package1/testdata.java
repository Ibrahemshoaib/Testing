package Package1;

import Utility.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class testdata {

   // @org.testng.annotations.DataProvider(name = "Authentication")

   // public static Object[][] credentials() {

        // The number of times data is repeated, test will be executed the same no. of times

        // Here it will execute two times

       // return new Object[][] { { "standard_user", "secret_sauce" }, { "problem_user", "secret_sauce" }};

  //  }

    @org.testng.annotations.DataProvider(name = "Authentication")

    public Object[][] Authentication() throws Exception{

        Object[][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\Mac\\Downloads\\New XLSX Worksheet (2).xlsx","New XLSX Worksheet (2).xlsx");

        return (testObjArray);

    }
    WebDriver driver;
    @Test(dataProvider = "Authentication")

    public void test(String sUsername, String sPassword) {

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");

        //driver.findElement(By.xpath(".//*[@id='account']/a")).click();

        // Argument passed will be used here as String Variable

        driver.findElement(By.id("user-name")).sendKeys(sUsername);

        driver.findElement(By.id("password")).sendKeys(sPassword);

        driver.findElement(By.id("login-button")).click();

        //driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

        driver.quit();

    }


}
