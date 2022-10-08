package day03_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_noSuchElementExc {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        // WebElement searchBox= driver.findElement(By.id("twotabsearchtextboxes"));
        // above, we intentionally write false as twotabsearchtextboxes (+es, instead twotabsearchtextboxes)
        // to see NoSuchElementException

        /*
        findElement ile locate edilen web element'lerde locator'da sorun (yukaridaki gibi yanlis yazim mesela) varsa
        driver istenen web element'i veremez ve error olarak NoSuchElementException verir
         */

        List<WebElement> resultSearchBox= driver.findElements(By.id("twotabsearchtextboxes"));
        System.out.println(resultSearchBox.size());
        /* findelements ile bunu yaparsak error vermez bunun yerine bos bir liste dondurur

         */

        driver.close();

    }
}
