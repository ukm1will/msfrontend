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
        driver.get("http://localhost:63342/msFrontEnd/ms-styling/index.html");

        WebElement urlTable = driver.findElement(By.tagName("table"));

        List<WebElement> rowsInTable = urlTable.findElements(By.tagName("tr"));

        List<WebElement> tddsInRow;

        StringBuilder sb = new StringBuilder();

        WebElement tddElementWithFormElement;
        WebElement formElementWithInputElements;
        WebElement inputViewId = null;
        WebElement foundButton = null;

        int countLoops = 0;

        String viewId = "";

        for (WebElement row : rowsInTable) {
            tddsInRow = row.findElements(By.tagName("td"));
            if (tddsInRow.size() == 3) {
                countLoops++;

                // We are only interested in rows that have 3 cells. Once we find such a row, we need to look at the form within this cell
                tddElementWithFormElement = row.findElements(By.tagName("td")).get(2);
                formElementWithInputElements = tddElementWithFormElement.findElement(By.tagName("form"));

                // In the form we need the element with the viewId and the element with the submit button
                inputViewId = formElementWithInputElements.findElement(By.name("viewId"));

                viewId = inputViewId.getAttribute("value");

                if (viewId.equals("5370"))
                    foundButton = formElementWithInputElements.findElement(By.name("submitButton"));
            }
            if(foundButton != null)
                break;
        }

        foundButton.click();

        System.out.println(String.format("Value of button is %s, number of loops is %d", viewId, countLoops));
    }
}

















