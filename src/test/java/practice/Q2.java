package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q2 {

    public static void main(String[] args) throws InterruptedException {

        /*
        ...Exercise2...
  1 - Let's create a driver
  2 - Let's introduce chromedriver.exe to our Java class
  3 - Let's make the driver fill the whole screen
  4 - Wait for 10,000 milliseconds (10 seconds) for the page to load.
      let's say. If the page loads beforehand, let it wait.
  5 - Let's go to "https://www.otto.de"
  6 - Let's get the page title and address (url) of this web page
  7 - Let's check if the title and url contain the word "OTTO"
  8 - Then let's go to "https://wisequarter.com/"
  9 - Let's take the title of this address and check if it contains the word "Quarter"
  10- Let's go back to our previous web page
  11- Let's refresh the page
  12- Then let's go back to our web page and close the current page that we are on
  13- As the last step, let's close all the pages
         */

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.otto.de");
        Thread.sleep(2000);

        String expectedTitleContent = "OTTO";
        String expectedUrlContent = "OTTO";

        String actualUrl = driver.getCurrentUrl();
        String actualTitle = driver.getTitle();

        // first, Url test...

        if (actualUrl.contains(expectedUrlContent)) {
            System.out.println("Url test PASSED");
        } else {
            System.out.println("Url test FAILED");
            System.out.println("Actual Url : " + actualUrl);
            System.out.println("Actual Url doesn't contain " + expectedUrlContent + " word");
        }

        // title test

        if (actualTitle.contains(expectedTitleContent)) {
            System.out.println("Title test PASSED");
        } else {
            System.out.println("Title test FAILED");
            System.out.println("Actual Title : " + actualTitle);
            System.out.println("Actual Title doesn't contain " + expectedTitleContent + " word");
        }

        driver.navigate().to("https://wisequarter.com/");
        Thread.sleep(2000);

        String expectedTitleContent2 = "Quarter";
        String actualTitle2 = driver.getTitle();

        // title test-2

        if (actualTitle2.contains(expectedTitleContent2)) {
            System.out.println("Title test-2 PASSED");
        } else {
            System.out.println("Title test-2 FAILED");
            System.out.println("Actual Title-2 : " + actualTitle2);
            System.out.println("Actual Title-2 doesn't contain " + expectedTitleContent2 + " word");
        }

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.close();

        driver.quit();

    }
}
