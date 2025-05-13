package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Browserwindows {
  public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://demoqa.com/browser-windows");
    WebElement newTabBtn = driver.findElement(By.cssSelector("#tabButton"));
    if (newTabBtn.isEnabled()) {
      newTabBtn.click();
      System.out.println("Clicked on New Tab Button");
    }
    String parentwindowHandle = driver.getWindowHandle();
    System.out.println("Parent window handle - "+parentwindowHandle + driver.getTitle());
    driver.findElement(By.id("tabButton")).click();
    Set<String> windowHandles = driver.getWindowHandles();
    String childwindow= null;
    for (String windowHandle : windowHandles){
      if(!windowHandle.equals(parentwindowHandle)) {
        driver.switchTo().window(windowHandle);
        childwindow = driver.getWindowHandle();
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        Thread.sleep(3000);
        driver.close();
      }
      if(!windowHandle.equals(childwindow)) {
        driver.switchTo().window(windowHandle);
      }
      //driver.switchTo().window(childwindow);
      System.out.println(windowHandle + driver.getTitle());
    }
    driver.switchTo().window(parentwindowHandle);
  }
}
