package stableford;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class SeleniumTests {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void ShouldCheckTitle() {
        driver.get("http://localhost:9090/");
        driver.manage().window().maximize();
        assertEquals(driver.getTitle(), "Swansea Bay Golf Club");
        driver.findElement(By.id("submitbutton")).click();
        driver.findElement(By.cssSelector("tr:nth-child(9) input:nth-child(4)")).click();
        driver.close();
    }
}
