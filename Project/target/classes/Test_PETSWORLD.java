package runner;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Base;
import utils.EventHandler;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Screenshot;
import utils.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

public class Test_PETSWORLD extends Base {

    public final int IMPLICIT_WAIT_TIME = 10;
    public final int PAGE_LOAD_TIME = 30;
    private ExcelReader file = new ExcelReader();
   
    private ExtentReports reporter = Reporter.generateExtentReport();
    private ExtentTest test = reporter.createTest("Offers", "Offer");


    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");


        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(ChromeOptions.CAPABILITY, options);
        dc.setBrowserName("chrome");
        driver = new RemoteWebDriver(new URL("http://localhost:4444/"), dc);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIME));
        driver.get("https://petsworld.in/");

        WebDriverListener listener = new EventHandler();
        driver = new EventFiringDecorator<>(listener).decorate(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));




LoggerHandler.info("Click");
LoggerHandler.info("Click");
LoggerHandler.info("click on ");
LoggerHandler.info("click on non vegetarian ");
LoggerHandler.info("click on non vegetarian");



LoggerHandler.info("click ");

test.generateLog(Status.PASS, "click on royal canin medium");
test.log(Status.PASS, "click on royal canin medium");
Screenshot.captureScreenShot("health");
Reporter.attachScreenshotToReport("Petsworld",test,"pass");
        test.addScreenCaptureFromPath(Reporter.captureScreenShot("sign_in"));

    
    }

    @Test(priority = 1 ,enabled=true)
    public void Test_Dynamic() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // driver.findElement(By.xpath("//input[@aria-expanded='true']")).click();

        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Royal Canin", Keys.ENTER);

        List<WebElement> footwear_list= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='product-grid']/li/div/div/div/div[@class='card__information']/h3[@class='card__heading h5']/a")));
        Thread.sleep(IMPLICIT_WAIT_TIME);
                for (int ctr = 0; ctr < footwear_list.size(); ctr++) {
        
                                String currentXpath = "(//ul[@id='product-grid']/li/div/div/div/div[@class='card__information']/h3[@class='card__heading h5']/a)[" + (ctr + 1) + "]";
                    //             // String currentXpath = "(//*[@id='maindiv']/div/div/div/div[2]/a)[9]";
                    
                                // WebElement product = footwear_list.get(ctr);
                                // String currentLabel = product.getText();
                                // System.out.println("Current Label:"+currentLabel);
        
        
                                WebElement product=driver.findElement(By.xpath(currentXpath));
                                String ProductTitle=product.getText();
                                System.out.println("Product Title: "+ProductTitle);
        
                                if (ProductTitle.contains("Medium ")) {
                                                    System.out.println("✅ Element " + (ctr + 1) + "Medium ");
        
                                                    //  String priceXpath = currentXpath + "/following::div/span/span[1]";
        
                                                //     WebElement tvPrice=driver.findElement(By.xpath(priceXpath));
                                                //    System.out.println("Price: "+tvPrice.getText());
        
                                                    product.click();
                                                    break;
                                                } else {
                                                    System.out.println("❌ Element " + (ctr + 1) + " does not contain 'Medium '");
                                                }
                                            }
        
                                  
                                }
            


    @Test(priority = 2, enabled = true)
    public void testHover() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 

        WebElement brand = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-hover='Shop by Brand']")));

 Actions a=new Actions(driver);
 a.moveToElement(brand).build().perform();

        
        driver.findElement(By.xpath("//div[1]//div[1]//div[1]//nav[1]//ul[1]//li[2]//div[1]//div[1]//div[1]//div[1]//ul[1]//li[4]//div[1]//a[1]//img[1]")).click();
//         WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"card__media\"]/a/div/img)[1]")));

//         a.moveToElement(product).build().perform();
// Thread.sleep(3000);
//         // driver.findElement(By.xpath("//button[@id='quick-add-template--17311581208727__product-grid8671353307287-submit']//*[name()='svg']")).click();

//         driver.findElement(By.xpath("(//a[@class=\"add-wishlist\"])[1]")).click();
//         Thread.sleep(8000);

driver.findElement(By.xpath("(//summary/div/span)[2]")).click();

        driver.findElement(By.xpath("(//input[@value=\"Non Vegetarian\"])[1]")).click();
        Thread.sleep(8000);

    }


    @Test(priority = 3,enabled=true)
    public void testswitch() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;


        WebElement brand = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-hover='Shop by Brand']")));

 Actions a=new Actions(driver);
 a.moveToElement(brand).build().perform();

        
        driver.findElement(By.xpath("//div[contains(@class,'row')]//div[1]//div[1]//div[1]//div[1]//ul[1]//li[2]//div[1]//a[1]//img[1]")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Pedigree Puppy Chicken and Milk']")).click();

     // Store the current window handle (original window)
     String originalWindow = driver.getWindowHandle();


     // Get all window handles (this will include the original window and the new one)
     Set<String> allWindows = driver.getWindowHandles();

     // Switch to the new window (it's not the original one, so we check for it)
     for (String windowHandle : allWindows) {
         if (!windowHandle.equals(originalWindow)) {
             driver.switchTo().window(windowHandle);
             break;  // Switch to the new window and exit the loop
         }
        }

        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[@class='product-form__submit product-form__s button button--full-width button--primary']")).click();
        
        driver.switchTo().window(originalWindow);
        driver.findElement(By.xpath("//p[contains(text(),'They are formulated to meet the specific nutrition')]//a[1]")).click();


           // Get all window handles
Set<String> allWindowHandles = driver.getWindowHandles();

// Convert Set to List to access by index
List<String> windowHandlesList = new ArrayList<>(allWindowHandles);

// Switch to the 3rd window (index 2 since it's 0-based)
if (windowHandlesList.size() >= 3) {
    driver.switchTo().window(windowHandlesList.get(2));
    System.out.println("Switched to 3rd window.");
} else {
    System.out.println("Less than 3 windows are open.");
}

     System.out.println(driver.getTitle());

//            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4//a//span[contains(text(),'here')]")));

// input.click();



    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
        reporter.flush();
    }
}
