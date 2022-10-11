package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        choose your continent -> Europe
        choose your command  -> Browser Commands
        click submit button
         */

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().deleteAllCookies(); // this deletes the all cookies, but sometimes cannot work
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@id='ez-accept-all']")).click();
        // to overcome the opened window

        driver.findElement(By.xpath("//a[@id='cookieChoiceDismiss']")).click();
        // to overcome the opened little info-window at the bottom

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Nevzat" + Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Celik" + Keys.ENTER);
        Thread.sleep(2000);

        WebElement genderRadioButton= driver.findElement(By.xpath("//input[@id='sex-0']")); // we introduce MALE gender
        genderRadioButton.click(); // we select the MALE gender
        Thread.sleep(2000);

        genderRadioButton.sendKeys(Keys.PAGE_DOWN); // as MALE gender is a reference point, page is downed by scroll
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='exp-0']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("2022/10/11" + Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='profession-1']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='tool-2']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//select[@class='input-xlarge']")).sendKeys("Europe" + Keys.ENTER + Keys.ENTER);
        Thread.sleep(2000);

        /*
        WebElement continent= driver.findElement(By.xpath("//select[@class='input-xlarge']"));
        continent.sendKeys("Europe" + Keys.ENTER + Keys.ENTER);
         */

        driver.findElement(By.xpath("//select[@id='selenium_commands']")).sendKeys("Browser Commands" + Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

        driver.close();


    }
}
