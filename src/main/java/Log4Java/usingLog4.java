package Log4Java;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;


public class usingLog4 {
    private static Logger logger = LogManager.getLogger(usingLog4.class);

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(" https://login.yahoo.com/account/create");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.name("firstName")).sendKeys("Simrah");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("first name");
        driver.findElement(By.id("usernamereg-lastName")).sendKeys("Hussain");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        logger.info("last name");

        driver.findElement(By.name("userId")).sendKeys("nisumsel_1738_hey");
        logger.info("enter user ID");

        driver.findElement(By.name("password")).sendKeys("applesauce1999!!!");
        logger.info("password");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.id("usernamereg-birthYear")).sendKeys("1999");
        logger.info("birth year");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.id("reg-submit-button")).click();
        logger.info("click continue");

        driver.close();
        driver.quit();





    }
}
