package seleniumDemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browserscommands {
  public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(" https://demoqa.com/automation-practice-form");
    String pagetitle = driver.getTitle();
    System.out.println(pagetitle);
    System.out.println(driver.getCurrentUrl());
    driver.navigate().to("https://demoqa.com/browser-windows");
    Thread.sleep(3000);
    System.out.println(driver.getCurrentUrl());
    driver.navigate().back();
    Thread.sleep(3000);
    System.out.println(driver.getCurrentUrl());
    driver.navigate().forward();
    Thread.sleep(3000);
    System.out.println(driver.getCurrentUrl());
    driver.navigate().refresh();
    System.out.println(driver.getCurrentUrl());
  }
}
