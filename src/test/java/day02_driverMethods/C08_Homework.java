package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_Homework {

    public static void main(String[] args) throws InterruptedException {

    /*
    1. Create a new class (Re-test)
    2. Go to the Youtube web page and verify if the page title is "youtube",
        if not, print the correct title (Actual Title) in the console.
    3. Verify if the page URL contains "youtube", otherwise print the correct URL.
    4. Then go to Amazon page https://www.amazon.com/
    5. Go back to Youtube page
    6. Refresh the page
    7. Return to Amazon page
    8. Make the page full page
    9. Then verify if the page title contains “Amazon”, otherwise print the correct title (Actual Title).
    10. Verify if the page URL is https://www.amazon.com/, otherwise print the correct URL
    11.Close page
    */

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.youtube.com/");
        Thread.sleep(2000);

        boolean isTrue = driver.getTitle().contains("youtube");

        // title test for Youtube

        if (isTrue)
            System.out.println("Youtube web page title contains : " + driver.getTitle());
        else
            System.out.println("Actual title is : " + driver.getTitle());

        Thread.sleep(2000);

        // Url test for Youtube

        if (driver.getCurrentUrl().contains("youtube")) {
            System.out.println("This Url contains :" + driver.getCurrentUrl());
        } else {
            System.out.println("Actual URL: " + driver.getCurrentUrl());
        }

        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(2000);

        driver.navigate().back(); // now, coming to Youtube web page
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.navigate().forward(); // again coming to amazon web page
        Thread.sleep(2000);

        driver.manage().window().maximize(); // making full page
        Thread.sleep(2000);

        // title test for Amazon

        if (driver.getTitle().contains("Amazon")) {
            System.out.println("Amazon web page title contains :" + driver.getTitle());
        } else {
            System.out.println("Actual title is : " + driver.getTitle());
        }

        // Url test for Amazon

        if (driver.getCurrentUrl().contains("https://www.amazon.com/")) {
            System.out.println("This Url contains : " + driver.getCurrentUrl());
        } else {
            System.out.println("Actual URL : " + driver.getCurrentUrl());
            ;
        }

        driver.close();

        /*
        We can close the driver by two ways:
        1- driver.close(); ==> just close the current window and if it is the only window, quit browser
        2- driver.quit(); ==>  close the all related windows and quit browser
        */

    }
}