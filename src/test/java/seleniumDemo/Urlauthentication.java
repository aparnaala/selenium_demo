package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Urlauthentication {
  public static void main(String[] args) {
    // Setup ChromeDriver
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();

    String urlWithAuth = "https://admin:admifsrn@the-internet.herokuapp.com/basic_auth";
    driver.get(urlWithAuth);

    String pageSource = driver.getPageSource();
    if (pageSource.contains("Congratulations! You must have the proper credentials.")) {
      System.out.println("Login successful!");
    } else {
      System.out.println(" Login failed.");
    }

  }
}
