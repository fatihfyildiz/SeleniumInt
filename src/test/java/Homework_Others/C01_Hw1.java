package Homework_Others;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Hw1 {

    public static void main(String[] args) throws InterruptedException {

        /*
         1. Let's create a new class (Homework)
         2. By using ChromeDriver, go to facebook page and verify the page title is “facebook” (verify),
          if not, print the correct title.
         3. Verify that the page URL contains the word "facebook", if not, print the "actual" URL.
         4.Go to https://www.walmart.com/.
         5. Verify that the page title includes “Walmart.com”.
         6. Go back to the “facebook” page
         7. Refresh the page
         8. Maximize the page
         9. Close the browser
         */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.facebook.com");

        String expectedTitleContent= "facebook";
        String expectedUrlContent= "facebook";

        String actualUrl= driver.getCurrentUrl();
        String actualTitle= driver.getTitle();

        if (actualTitle.contains(expectedTitleContent)){
            System.out.println("Title test PASSED");
        } else {
            System.out.println("Title test FAILED");
            System.out.println("Actual Title : " + actualTitle);
            System.out.println("Actual Title doesn't contain " + expectedTitleContent + " word");
        }

        if (actualUrl.contains(expectedUrlContent)){
            System.out.println("Url test PASSED");
        } else {
            System.out.println("Url test FAILED");
            System.out.println("Actual Url : " + actualUrl);
            System.out.println("Actual Url doesn't contain " + expectedUrlContent + " word");
        }

        Thread.sleep(2000);

        driver.navigate().to("https://www.walmart.com/");

        String expectedTitleContent2= "Walmart.com";
        String actualTitle2= driver.getTitle();

        if (actualTitle2.contains(expectedTitleContent2)){
            System.out.println("Title test-2 PASSED");
        } else {
            System.out.println("Title test-2 FAILED");
            System.out.println("Actual Title-2 : " + actualTitle2);
            System.out.println("Actual Title-2 doesn't contain " + expectedTitleContent2 + " word");
        }

        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.close();

    }
}
