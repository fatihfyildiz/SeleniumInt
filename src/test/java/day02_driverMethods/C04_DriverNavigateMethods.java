package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverNavigateMethods {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.navigate().to("https://amazon.com");

        driver.navigate().to("https://youtube.com");

        Thread.sleep(2000);

        // let's go back to amazon
        driver.navigate().back();
        Thread.sleep(2000);

        // let's go to youtube again
        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().refresh();

        driver.close();
    }
}
