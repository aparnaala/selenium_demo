package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Frames {
  public static void main ( String[] args){

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://demoqa.com/frames");


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("#frame1")));

    WebElement frameHeading1 = driver.findElement(By.cssSelector("#sampleHeading"));

    if (frameHeading1.isDisplayed()) {
      System.out.println("Inside Frame 1 " + frameHeading1.getText());
    }

    driver.switchTo().defaultContent();

    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("#frame2")));
    WebElement frameHeading2 = driver.findElement(By.cssSelector("#sampleHeading"));

    if (frameHeading2.isDisplayed()) {
      System.out.println("Inside Frame 2 " + frameHeading2.getText());
    }

    driver.switchTo().defaultContent();

  }
}
