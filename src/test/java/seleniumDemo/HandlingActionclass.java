package seleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingActionclass {
  public static void main(String[] args) throws InterruptedException {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get("https://www.amazon.in/");
    driver.manage().window().maximize();

    WebElement signInOption = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-accountList")));
    Actions actions = new Actions(driver);
    actions.moveToElement(signInOption).perform();
    System.out.println("Hovered over the 'Sign In' option.");
  }
}