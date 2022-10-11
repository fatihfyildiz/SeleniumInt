package Homework_Others;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_GroupWrk {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.hepsiburada.com/");
        Thread.sleep(2000);

        WebElement searchBox= driver.findElement(By.className("desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b"));
        // Arama kutusunu bulduk

        searchBox.sendKeys("Elektronik" + Keys.ENTER);
        // Arama kutusuna Elektronik yazip tiklanmasini sagladik
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"i0\"]/div/a/div[1]/div[1]/div[2]/div[2]")).click();
        // cikan sayfadaki ilk urune tikladik
        Thread.sleep(2000);

        driver.quit();

    }
}
