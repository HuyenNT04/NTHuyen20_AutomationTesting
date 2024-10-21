package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Part_01_VerifyAndFindElement {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
    }

    @Test
    public void TC_01_VerifyURL(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.xpath("//a[@title='Create an Account']//span//span")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/create/");
        driver.quit();
    }

    @Test
    public void TC_03_NavigateFunc(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
        driver.findElement(By.xpath("//a[@title='Create an Account']//span//span")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/customer/account/create/");
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
        driver.navigate().forward();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
        driver.quit();
    }

    @Test
    public void TC_04_GetPageSourceCode(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
        //Kiem tra co chua khong thi dung assert TrueFalse
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
        driver.findElement(By.xpath("//a[@title='Create an Account']//span//span")).click();
        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
        driver.quit();
    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }





















}
