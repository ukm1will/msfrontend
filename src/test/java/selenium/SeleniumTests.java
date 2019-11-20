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
//        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        // driver.quit();
    }

    @Test
    public void firstTest() {
        driver.get("http://localhost:63342/msFrontEnd/ms-styling/index.html?_ijt=86ramffi8g4jnhro5fbrb1c2e1");

        // WebElement selectElement = driver.findElement(By.id("results-table"));

        WebElement urlTable = driver.findElement(By.tagName("table"));

        WebElement cellThatHoldsForm = urlTable.findElements(By.tagName("td")).get(2);

        WebElement formThatHoldsData = cellThatHoldsForm.findElements(By.tagName("form")).get(0);

        WebElement inputType = formThatHoldsData.findElement(By.name("viewId"));

        System.out.println(inputType.getAttribute("value"));

//        System.out.println(cellThatHoldsForm.getText());


//        WebElement rowZero = urlTable.findElements(By.tagName("td")).get(0);
//        WebElement rowOne = urlTable.findElements(By.tagName("td")).get(1);
//
//        System.out.println(String.format("%s %s", rowZero.getText(), rowOne.getText()));

    }
}