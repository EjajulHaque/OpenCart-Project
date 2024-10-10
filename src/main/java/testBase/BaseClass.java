package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseClass {
    public WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setUp(String br){

        switch (br.toLowerCase()){
            case "chrome":driver=new ChromeDriver(); break;
            case "edge":driver=new EdgeDriver(); break;
            case "firefox":driver=new FirefoxDriver(); break;
            default: System.out.println("invalid browser name.."); return;
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    public  String randomString(){
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }
    public String randomNumber(){
        String generatedNumber=RandomStringUtils.randomNumeric(10);
        return generatedNumber;
    }
    public String randomAlphaNumeric(){
        String generatedString=RandomStringUtils.randomAlphabetic(3);
        String generatedNumber=RandomStringUtils.randomNumeric(3);
        return (generatedString+"@"+generatedNumber);
    }
}
