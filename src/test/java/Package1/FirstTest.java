package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTest {

    WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void login(){
        driver.get("https://www.selenium.dev/selenium/web/window_switching_tests/page_with_frame.html");

    }


    @Test (priority = 1)
    public void Z(){

        String currHandle=driver.getWindowHandle();
        driver.findElement(By.linkText("Open new window")).click();
        //fetch handles of all windows, there will be two, [0]- default, [1] - new window
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[0]);

        //assert on title of new window
        String title=driver.getTitle();
        System.out.println(title);
    }

    @Test
    public void testassert(){

        driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
        driver.findElement(By.id("btn1")).click();
        driver.findElement(By.id("btn2")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(By.id("txt1")).isDisplayed());
        wait.until(d -> driver.findElement(By.id("txt2")).isDisplayed());

        String Expectedmss= "Click the below buttons to display the textboxes.";
        String Actual = driver.findElement(By.xpath("//*[@id=\"post-body-2047169183822947274\"]/p/text()[1]")).getText();

        Assert.assertEquals(Actual,Expectedmss);
    }

    @AfterSuite
    public void closebrowser(){
        driver.quit();
    }
}
