package tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class extentReportDemo {

    //static bc used in a static method
    //gave wedriver object here

    public static void main(String[] args) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/Spark.html");

        //creates extentreports and attatches reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        //creates toggle for given test, adds all log events under
        ExtentTest test = extent.createTest("Yahoo Account Creation Test 1", "Automating yahoo account creation");

        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        test.log(Status.INFO,"Starting Test Case" );
        driver.get(" https://login.yahoo.com/account/create");
        //when passed this message willl show up in HTML report
        test.pass("Navigated to yahoo.com");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.name("firstName")).sendKeys("Simrah");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        test.pass("First Name Automated");

        driver.findElement(By.id("usernamereg-lastName")).sendKeys("Hussain");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        test.pass("Lasr Name Automated");

        driver.findElement(By.name("userId")).sendKeys("nisumsel_1738_hey");
        test.pass("UserID Automated");

        driver.findElement(By.name("password")).sendKeys("applesauce1999!!!");
        test.pass("Password Automated");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.id("usernamereg-birthYear")).sendKeys("1999");
        test.pass("Birthday Selected");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.id("reg-submit-button")).click();
        test.pass("Automated selection of continue button");

        driver.close();
        driver.quit();
        test.pass("Closed the browser");

        test.info("Test Completed");

        //puts everything in the log file
        extent.flush();

    }
}
