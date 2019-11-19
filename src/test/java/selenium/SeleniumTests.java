package selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class SeleniumTests {

    private WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        // driver.quit();
    }

    @Test
    public void firstTest() {
        driver.get("http://localhost:9090/url");

        WebElement selectElement = driver.findElement(By.id("results-table"));

        Select select = new Select(selectElement);

        select.selectByVisibleText("Sun 20 Oct 19");



    }
}