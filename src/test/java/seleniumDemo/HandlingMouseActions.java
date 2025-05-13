package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HandlingMouseActions {
  public static void main(String[] args){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.get("https://www.browserstack.com/");
    driver.manage().window().maximize();
    Actions action = new Actions(driver);
    WebElement getStartedButton = driver.findElement(By.linkText("Get started free"));
    action.moveToElement(getStartedButton).click().perform();
    WebElement productsMenu = driver.findElement(By.linkText("Products"));
    action.moveToElement(productsMenu).perform();
  }
}
