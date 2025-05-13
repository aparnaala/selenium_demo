package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingDrag {
  public static void main(String[] args) {

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("https://demoqa.com/dragabble");
    driver.manage().window().maximize();

    WebElement draggable = driver.findElement(By.id("dragBox"));

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", draggable);

    Point initialPosition = draggable.getLocation();
    int initialX = initialPosition.getX();
    int initialY = initialPosition.getY();
    System.out.println("Initial Position: X=" + initialX + " Y=" + initialY);

    Actions actions = new Actions(driver);
    actions.dragAndDropBy(draggable, 200, 100).perform();

    Point newPosition = draggable.getLocation();
    int newX = newPosition.getX();
    int newY = newPosition.getY();
    System.out.println("New Position: X=" + newX + " Y=" + newY);

    if (newX != initialX || newY != initialY) {
      System.out.println("Drag operation successful");
    } else {
      System.out.println("Drag operation not successful");
    }
  }
}
