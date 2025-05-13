package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.Duration;

public class handlingWebtable{
  public static void main(String[] args) throws InterruptedException {

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();

    driver.get("https://cosmocode.io/automation-practice-webtable/");

    List<WebElement> rows = driver.findElements(By.cssSelector("table#countries tbody tr"));
    boolean countryFound = false;

    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      if (cells.size() > 0) {
        String countryName = cells.get(1).getText().trim();  // 2nd column: Country
        if (countryName.equalsIgnoreCase("India")) {
          System.out.println("Found country: " + countryName);
          System.out.println("Complete Row Text: " + row.getText());
          countryFound = true;
          break;
        }
      }
    }

    if (!countryFound) {
      System.out.println("Country India not found!");
    }

    List<WebElement> countryElements = driver.findElements(By.xpath("//table[@id='countries']/tbody/tr/td[2]"));
    List<String> countryNamesUI = new ArrayList<>();

    for (WebElement ele : countryElements) {
      countryNamesUI.add(ele.getText().trim());
    }
    System.out.println(countryNamesUI);

    //List<String> countryNamesSorted = new ArrayList<>(countryNamesUI);
    Collections.sort(countryNamesUI);
    System.out.println(countryNamesUI);

    /*if (countryNamesUI.equals(countryNamesSorted)) {
      System.out.println("Country column is already sorted alphabetically!");
    } else {
      System.out.println("Country column is NOT sorted alphabetically.");
      System.out.println("Expected sorted list: " + countryNamesSorted);
      System.out.println("Actual UI list: " + countryNamesUI);
    }*/

    //driver.quit();
  }
}
