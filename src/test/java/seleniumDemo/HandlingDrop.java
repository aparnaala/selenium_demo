package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingDrop {
  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://demoqa.com/droppable");
    driver.manage().window().maximize();

    WebElement draggable = driver.findElement(By.id("draggable"));
    WebElement droppable = driver.findElement(By.id("droppable"));

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", draggable);

    String initialText = droppable.getText();
    System.out.println("Initial Dropbox Text: " + initialText);

    Actions actions = new Actions(driver);

    actions.dragAndDrop(draggable, droppable).perform();

    String newText = droppable.getText();
    System.out.println("New Dropbox Text: " + newText);
  }
}

