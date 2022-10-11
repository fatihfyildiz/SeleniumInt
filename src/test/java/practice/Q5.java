package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q5 {

    public static void main(String[] args) throws InterruptedException {

        /*
        Exercäse 5...
    Navigate to website https://testpages.herokuapp.com/styled/index.html
    Under the ORIGINAL CONTENTS
    click on Alerts
    print the URL
    navigate back
    print the URL
    Click on Basic Ajax
    print the URL
    enter value 20 and ENTER
    and then verify Submitted Values is displayed open page
    close driver
     */


        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testpages.herokuapp.com/styled/index.html");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@id='alerts']")).click();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);

        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@id='basicajax']")).click();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("20" + Keys.ENTER);
        Thread.sleep(2000);

        String expectedText= "Submitted Values";
        String actualText= driver.findElement(By.xpath("//p[text()='Submitted Values']")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("Test is PASSED");
        } else {
            System.out.println("Test is FAILED");
        }

        driver.close();

    }
}
