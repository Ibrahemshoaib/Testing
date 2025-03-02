package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestngClass {
    WebDriver driver ;
    @BeforeSuite
            void openbrowser(){
        driver = new ChromeDriver();
    }

    @Test (priority = 1)
    public void f(){
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
    @Test
    public void c(){

        driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
        driver.findElement(By.id("btn1")).click();
        driver.findElement(By.id("btn2")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(By.id("txt1")).isDisplayed());
        wait.until(d -> driver.findElement(By.id("txt2")).isDisplayed());
        driver.findElement(By.id("txt1")).sendKeys("Done");
        driver.findElement(By.id("txt2")).sendKeys("test");
    }
}
