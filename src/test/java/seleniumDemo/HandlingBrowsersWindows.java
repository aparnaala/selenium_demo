package seleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Set;
import java.time.Duration;

public class HandlingBrowsersWindows {

  public static void main(String[] args) throws InterruptedException {

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    driver.get("https://demoqa.com/browser-windows");

//        String mainWin = driver.getWindowHandle();
    //driver.findElement(By.id("windowButton")).click();
    driver.findElement(By.id("tabButton")).click();
    driver.findElement(By.id("tabButton")).click();
    String mainWin = driver.getWindowHandle();
    Set<String> allWindow = driver.getWindowHandles();
//        Iterator<String> itr = allWindow.iterator();
//        while (itr.hasNext()) {
//            String childWin = itr.next();
//            if (!mainWin.equals(childWin)) {
//                Thread.sleep(2000);
//                driver.switchTo().window(childWin);
//                Thread.sleep(2000);
//                System.out.println("ChildWindow url: " + driver.getCurrentUrl());
//                driver.close();
//
//            }
//        }
    for (String childWin : allWindow) {

      if (!mainWin.equals(childWin)) {
        Thread.sleep(2000);
        driver.switchTo().window(childWin);
        Thread.sleep(2000);
        System.out.println("ChildWindow url: " + driver.getCurrentUrl());
        driver.close();
      }
    }
    driver.switchTo().window(mainWin);
    System.out.println("MainWindow url: " + driver.getCurrentUrl());

  }
}