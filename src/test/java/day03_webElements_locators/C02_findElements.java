package day03_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_findElements {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");

        List<WebElement> writingsList = driver.findElements(By.className("a-spacing-micro"));
        System.out.println(writingsList);
        // [[[ChromeDriver: chrome on WINDOWS (84250d7049ed0566742686dff6d3d258)] -> class name: a-spacing-micro]]
        // those above hash Values will be different in each trial

        System.out.println(writingsList.size());

        for (WebElement eachElement: writingsList
             ) {

            System.out.println(eachElement.getSize());
        }

        driver.close();



    }
}
