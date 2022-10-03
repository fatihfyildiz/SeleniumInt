package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverGetMethodlari {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        System.out.println(driver.getWindowHandle());
        // Bu method, bize acilan browser'in handle degerini dondurur
        // CDwindow-CE76E6A83EA74A2D80ECB8018F289724
        // CDwindow-874C1196C8F3C65048D88B0936FAAA9C
        // CDwindow-C507A008AE1F911037D5BCBE3D27F570
        // her seferinde farkli getiriyor...
        // CDwindow-CB4CE9EDEF441A1D1FBEA3A2C4B534F3 ==> bu String deger

        System.out.println(driver.getWindowHandles());
        // [CDwindow-CB4CE9EDEF441A1D1FBEA3A2C4B534F3] ==> bu ise Set variable...
        /*
        Eger testimiz sirasinda birden fazla pencere acilirsa
        acilan tum window'larin window handle degerlerini bir Set olarak dondurur/getirir
        window'lar arasi gecisi bu handle degerleri ile yapariz...
         */

        driver.get("https://amazon.com");
        System.out.println(driver.getPageSource());
        // web sayfasinin tum kaynak kodlarini getirir

        driver.close();
    }
}
