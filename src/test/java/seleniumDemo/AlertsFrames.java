package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsFrames {
  public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://demoqa.com/alerts");
    //Alert Box just alert pop up
    driver.findElement(By.id("alertButton")).click();
    System.out.println("Alert box " + driver.switchTo().alert().getText());
    driver.switchTo().alert().accept();
    // 5 seconds late alert box
    driver.findElement(By.id("timerAlertButton")).click();
    Thread.sleep(6000);
    System.out.println("Timer ALert Button "+ driver.switchTo().alert().getText());
    driver.switchTo().alert().accept();
    //confirm box alert
    Thread.sleep(2000);
    driver.findElement(By.id("confirmButton")).click();
    System.out.println("confirm box " + driver.switchTo().alert().getText());
    driver.switchTo().alert().dismiss();
    System.out.println(driver.findElement(By.id("confirmResult")).getText());
    Thread.sleep(2000);
    //Prompt box text entry and accept and dismiss
    driver.findElement(By.id("promtButton")).click();
    System.out.println("prompt alert box " + driver.switchTo().alert().getText());
    driver.switchTo().alert().sendKeys("Hello");
    driver.switchTo().alert().accept();
    System.out.println(driver.findElement(By.id("promptResult")).getText());
    //driver.findElement(By.id("promtButton")).click();
    //driver.switchTo().alert().dismiss();
    //System.out.println(driver.findElement(By.id("promptResult")).getText());

  }
}