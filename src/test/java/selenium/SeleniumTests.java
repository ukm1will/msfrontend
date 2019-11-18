package selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


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
        assertThat(driver.getTitle(), is("SBGC"));
        driver.findElement(By.cssSelector("tr:nth-child(13) input:nth-child(4)")).click();
        assertThat(driver.getTitle(), is("SBGC"));
        driver.findElement(By.cssSelector("tr:nth-child(2) > .col-brown-bold:nth-child(2)")).click();
        assertThat(driver.findElement(By.cssSelector("tr:nth-child(2) > .col-brown-bold:nth-child(2)")).getText(), is("John P Murphy"));
        driver.findElement(By.cssSelector("tr:nth-child(2) > .col-brown-bold:nth-child(3)")).click();
        assertThat(driver.findElement(By.cssSelector("tr:nth-child(2) > .col-brown-bold:nth-child(3)")).getText(), is("38 pts (12)"));
    }
}