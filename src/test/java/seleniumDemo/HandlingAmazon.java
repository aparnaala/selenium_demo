package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class HandlingAmazon {
  public static void main (String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.amazon.in/");
    System.out.println(driver.getTitle());
    driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Coffee table");
    driver.findElement(By.cssSelector("input[type='submit']")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Amazon Brand - Solimo Capella Engineered Wood Wenge Finish Modern Coffee Table (Wenge Finish)")).click();
    Thread.sleep(3000);
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    System.out.println("Title of new tab: " + driver.getTitle());
    //driver.close(); this one closes the current tab
    driver.findElement(By.cssSelector("#add-to-cart-button")).click();
    driver.findElement(By.cssSelector("input[name='proceedToRetailCheckout']")).click();
    System.out.println("Clicked on Proceed to Checkout");

  }
}
