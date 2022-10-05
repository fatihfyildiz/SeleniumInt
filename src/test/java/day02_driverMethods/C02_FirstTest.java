package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_FirstTest {

    /*
    After making the necessary adjustments,  go to the amazon page
     1- The page title should contain the word "amazon"
     2- The page url must have the word "Amazon"
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.amazon.com");

        String expectedTitleContent= "amazon";
        String expectedUrlContent= "Amazon";

        String actualUrl= driver.getCurrentUrl();
        String actualTitle= driver.getTitle();

        // let's start testing
        // first url test...

        if (actualUrl.contains(expectedUrlContent)){
            System.out.println("Url test PASSED");
        } else {
            System.out.println("Url test FAILED");
            System.out.println("Actual Url : " + actualUrl);
            System.out.println("Actual Url doesn't contain " + expectedUrlContent + " word");
        }

        // title test

        if (actualTitle.contains(expectedTitleContent)){
            System.out.println("Title test PASSED");
        } else {
            System.out.println("Title test FAILED");
            System.out.println("Actual Title : " + actualTitle);
            System.out.println("Actual Title doesn't contain " + expectedTitleContent + " word");
        }

        driver.quit();

        /*
        driver.close() ==> close only the open browser sadece acik olan browser'i kapatir
        driver.quit() ==> close the all browsers that testing is working on
         */
    }
}
