package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlingwebelements {
  public static void main (String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://demoqa.com/automation-practice-form");
    Thread.sleep(3000);
    WebElement Firstname = driver.findElement(By.xpath("//input[@id='firstName']"));
    Firstname.sendKeys("Aparna");
    driver.findElement(By.id("lastName")).sendKeys(("Laxmi"));
    WebElement mailId = driver.findElement(By.xpath("//input[@id='userEmail']"));
    if(mailId.isDisplayed()){
      System.out.println("Mail id is displayed");
      if(mailId.isEnabled()){
        System.out.println("Mail id is enabled");
        mailId.sendKeys("aparna@123.com");
      }
      else{
        System.out.println("Mail id is not enabled");
      }
    }
    else{
      System.out.println("Mail Id is not displayed");
    }
    Thread.sleep(3000);
    driver.findElement(By.xpath("//label[text()='Female']")).click();
    Thread.sleep(3000);
    if(driver.findElement(By.id("gender-radio-2")).isSelected()){
      System.out.println("gender is selected");
    }
    else{
      System.out.println("gender is not selected");
    }
    Thread.sleep(3000);
    driver.findElement(By.cssSelector("input#userNumber")).sendKeys("1234567890");
    WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
    dob.click();
    WebElement date = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day')][text()='23']"));
    date.click();
    Thread.sleep(2000);
    WebElement sub = driver.findElement(By.cssSelector("input#subjectsInput"));
    sub.sendKeys("Physics");
    sub.sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();
    Thread.sleep(3000);
    WebElement Hobbies = driver.findElement(By.id("hobbies-checkbox-2"));
    if(Hobbies.isSelected()){
      System.out.println("checkbox is selected");
    }
    else{
      System.out.println("Checkbox not selected");
    }
    WebElement uploadfile = driver.findElement(By.id("uploadPicture"));
    uploadfile.sendKeys("C:\\Users\\aparna.anantharaju\\Downloads\\1000862192.jpg");
    Thread.sleep(3000);
    driver.findElement(By.id("currentAddress")).sendKeys("Happy homes block 2");
    Thread.sleep(2000);
    WebElement state = driver.findElement(By.id("react-select-3-input"));
    state.sendKeys("Haryana");
    state.sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    WebElement city = driver.findElement(By.id("react-select-4-input"));
    city.sendKeys("Panipat");
    city.sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("#submit")).click();
  }
}
