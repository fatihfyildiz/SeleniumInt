package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q4 {

    public static void main(String[] args) throws InterruptedException {

    /*
    ...Exercise4...
    Navigate to https://testpages.herokuapp.com/styled/index.html
    Click on  Calculater under Micro Apps
    Type any number in the first input
    Type any number in the second input
    Click on Calculate
    Get the result
    Print the result
     */


        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testpages.herokuapp.com/styled/index.html");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@id='calculatetest']")).click();
        Thread.sleep(2000);

        WebElement simpleCalculatorTest= driver.findElement(By.xpath("//h1[text()='Simple Calculator']"));

        if (simpleCalculatorTest.isDisplayed()) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

        driver.findElement(By.xpath("//input[@id='number1']")).sendKeys("5" + Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='number2']")).sendKeys("10" + Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);

        WebElement answerElement= driver.findElement(By.xpath("//span[@id='answer']"));
        System.out.println("The result is" + answerElement.getText());

        /*
        Or alternatively;

        String answerElement2= driver.findElement(By.xpath("//span[@id='answer']")).getText();
        System.out.println(" The result is" + answerElement2);

        Another alternative;

        int answerElementi3= Integer.parseInt(driver.findElement(By.xpath("//span[@id='answer']")).getText());
        System.out.println("The result is" + answerElementi3);
        */


        driver.close();
    }
}
