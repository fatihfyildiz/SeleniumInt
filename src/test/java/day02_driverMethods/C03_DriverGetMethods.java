package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverGetMethods {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        System.out.println(driver.getWindowHandle());
        // This method brings us the handle value of the opened browser
        // CDwindow-CE76E6A83EA74A2D80ECB8018F289724
        // CDwindow-874C1196C8F3C65048D88B0936FAAA9C
        // CDwindow-C507A008AE1F911037D5BCBE3D27F570
        // Brought different values for the each trial
        // CDwindow-CB4CE9EDEF441A1D1FBEA3A2C4B534F3 ==> this is the String value

        System.out.println(driver.getWindowHandles());
        // [CDwindow-CB4CE9EDEF441A1D1FBEA3A2C4B534F3] ==> that is a Set variable...
        /*
        If more than one window opens during our test,
        Brings the window handle values of all opened windows as a Set
        We make the transition between windows with these handle values...
         */

        driver.get("https://amazon.com");
        System.out.println(driver.getPageSource());
        // brings the all resource codes of the web page

        driver.close();
    }
}
