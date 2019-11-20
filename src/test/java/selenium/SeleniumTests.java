package selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


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

        WebElement urlTable = driver.findElement(By.tagName("table"));

        List<WebElement> rowsInTable = urlTable.findElements(By.tagName("tr"));
        List<WebElement> tddsInRow;
        StringBuilder sb = new StringBuilder();

        WebElement tddElementWithFormElement;
        WebElement formElementWithInputElements;
        WebElement inputElementNamedViewId;

        for (WebElement row : rowsInTable) {
            tddsInRow = row.findElements(By.tagName("td"));
            if (tddsInRow.size() == 3) {
                tddElementWithFormElement = row.findElements(By.tagName("td")).get(2);
                formElementWithInputElements = tddElementWithFormElement.findElement(By.tagName("form"));
                inputElementNamedViewId = formElementWithInputElements.findElement(By.name("viewId"));
                sb.append(inputElementNamedViewId.getAttribute("value"));
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
