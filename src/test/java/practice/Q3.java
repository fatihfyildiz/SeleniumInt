package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3 {

    public static void main(String[] args) throws InterruptedException {

        /*
        ...Exercise3...
        go to url : https://www.techlistic.com/p/selenium-practice-form.html
        make the driver fill the whole screen
        wait for 10,000 milliseconds (10 seconds) for the page to load.
        fill the firstname
        fill the lastname
        check the gender
        check the experience
        fill the date
        choose your profession -> Automation Tester
        choose your tool -> Selenium Webdriver
        choose your continent -> Antartica
        choose your command  -> Browser Commands
        click submit button
         */

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        Thread.sleep(2000);

        driver.findElement(By.name("firstname")).sendKeys("Nevzat");


    }
}
