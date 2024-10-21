package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Part_04_Actions {
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        action = new Actions(driver);
    }

    @Test
    public void TC_01_Hover() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        WebElement ageTextbox = driver.findElement(By.cssSelector("input#age"));
        //Thuc hien hover vao textbox de hien tooltip
        action.moveToElement(ageTextbox).perform();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("div.ui-tooltip-content")).isDisplayed());
    }
    @Test
    public void TC_02_Click_And_Hold_Block() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allNumber =  driver.findElements(By.cssSelector("ol#selectable li"));
        Assert.assertEquals(allNumber.size(), 20);
        action.clickAndHold(allNumber.get(0)).moveToElement(allNumber.get(3)).release().perform(); //click va giu chuot tai so 1--> move to so 4 --> release chuot
        Thread.sleep(2000);
        //Kiem tra co dung 4 element dang duoc chon hay khong
        List<WebElement> allSelected = driver.findElements(By.cssSelector("ol#selectable li.ui-selected"));
        Assert.assertEquals(allSelected.size(), 4);
    }
    @Test
    public void TC_03_Double_Click(){
        driver.get("https://automationfc.github.io/jquery-selectable/");
        action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me]"))).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");
    }


    @Test
    public void TC_04_Right_Click(){
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        //CLick chuot phai vaof button
        action.contextClick(driver.findElement(By.cssSelector("span.btn-neutral"))).perform();
    }

    @Test
    public void TC_05_Scroll_to_Element() throws InterruptedException {
        driver.get("...");
        Thread.sleep(3000);
        action.scrollToElement(driver.findElement(By.cssSelector(""))).perform();
        Thread.sleep(3000);
    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }





















}
