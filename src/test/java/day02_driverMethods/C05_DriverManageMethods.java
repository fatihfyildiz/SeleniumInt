package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_DriverManageMethods {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");

        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // wait atmost 15 seconds for the testing
        driver.manage().window().maximize();
        // above two are done in general

        /*
        waits issue will be explained later but,
        implicitly wait ==> is the time that we want driver to find out the elements that we give
        if it cannot find in that time, then it will give error
         */

        driver.manage().window().fullscreen();
        System.out.println("fullscreen position " + driver.manage().window().getPosition());
        System.out.println("fullscreen size " + driver.manage().window().getSize());

        Thread.sleep(2000);

        driver.manage().window().maximize();
        System.out.println("maximize position " + driver.manage().window().getPosition());
        System.out.println("maximize size " + driver.manage().window().getSize());

        Thread.sleep(2000);

        driver.manage().window().minimize();
        System.out.println("minimize position " + driver.manage().window().getPosition());
        System.out.println("minimize size " + driver.manage().window().getSize());

        Thread.sleep(2000);

        driver.close();

        /*
        fullscreen position (0, 0)
        fullscreen size (1536, 864)
        maximize position (-8, -8)
        maximize size (1552, 840)
        minimize position (9, 9)
        minimize size (1051, 806)
         */





    }
}
