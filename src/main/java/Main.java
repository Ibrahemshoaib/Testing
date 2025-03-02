import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class Main {

    public static void main(String [] args){
/*
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("standard_user")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

 */
       /* WebDriver driver=new ChromeDriver();
        driver.get("https://seleniumbase.io/demo_page");
        WebElement iframe = driver.findElement(By.id("myFrame3"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.id("checkBox6")).click();

        */


        WebDriver driver=new ChromeDriver();
        /*
        driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
        driver.findElement(By.id("btn1")).click();
        driver.findElement(By.id("btn2")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(By.id("txt1")).isDisplayed());
        wait.until(d -> driver.findElement(By.id("txt2")).isDisplayed());
        driver.findElement(By.id("txt1")).sendKeys("Done");
        driver.findElement(By.id("txt2")).sendKeys("test");

         */
        driver.get("https://www.selenium.dev/selenium/web/window_switching_tests/page_with_frame.html");
        //fetch handle of this
        String currHandle=driver.getWindowHandle();
        driver.findElement(By.linkText("Open new window")).click();
        //fetch handles of all windows, there will be two, [0]- default, [1] - new window
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[0]);

        //assert on title of new window
        String title=driver.getTitle();
        System.out.println(title);



    }
}
