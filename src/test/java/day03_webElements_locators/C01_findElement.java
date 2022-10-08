package day03_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_findElement {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");

        // To find an element in a website, this web element should be introduced to our codes
        // While introducing, we must refer to an unique web element

        WebElement amazonSearchBox= driver.findElement(By.id("twotabsearchtextbox"));
        // since id name (twotabsearchtextbox) of the Amazon search box is a unique (only 1 in html codes) web element
        // it is wise to use it here...

        amazonSearchBox.sendKeys("Nutella" + Keys.ENTER);

        Thread.sleep(5000);
        driver.close();

        /*
        Selenium'da 8 adet locators vardir, bunlardan 6 tanesi HTML uzerindeki tag veya attribute'lare goredir
        2 tanesi ise daha spesifik olarak ilk 6 locator ile bulamadigimiz web elementlerini locate etmek icin kullanilir

        There are 8 locators in Selenium, while 6 of them are for tag or attributes on the HTML.
        Wheereas 2 of them ar specifically used for locating the web elements which we cannot find by the other 6 locators

        1- By.id
            id genelde unique olarak verilir
            dolayisiyla bir HTML element'de id varsa once By.id denenebilir

        1- By.id
            id is generally given as an unique
            therefore, if there exists an id in HTML element, it should be used at first

        2- className
            class attribute'u genelde ayni islevi ypan web element'leri gruplandirmak icin kullanilir
            bu gruplandirmalar sayesinde CSS ile gruptaki tum web elementler tek yerden sekillendirilebilir

        2- className
            The class attribute is often used to group web elements that perform the same function.
            With the help of these groupings, all web elements in the group can be shaped from one place with CSS.
         */

    }
}
