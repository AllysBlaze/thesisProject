package def;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelenTest {

    @Test
    public void quantityNotification() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/");

        String title = driver.getTitle();
        assertEquals("Terminal", title);
        List<WebElement> buttonOnStartPage = driver.findElements(By.cssSelector("button"));
        Integer expectedButtonsCount = buttonOnStartPage.size() + 1;

        WebElement submitButton = driver.findElement(By.id("quantityNotification"));
        submitButton.click();
        title = driver.getTitle();
        assertEquals("Select Employee", title);

        List<WebElement> buttons = driver.findElements(By.cssSelector("button"));
        assertEquals(2, buttons.size());
        buttons.get(0).click();
        title = driver.getTitle();
        assertEquals("Select Machine", title);

        buttons = driver.findElements(By.cssSelector("button"));
        assertEquals(2, buttons.size());
        buttons.get(0).click();
        title = driver.getTitle();
        assertEquals("Enter quantity", title);
        WebElement textBox = driver.findElement(By.name("quantity"));
        textBox.sendKeys("8", "8");
        textBox.submit();

        title = driver.getTitle();
        assertEquals("Terminal", title);
        buttonOnStartPage = driver.findElements(By.cssSelector("button"));
        assertEquals(expectedButtonsCount, buttonOnStartPage.size());
        driver.quit();
    }


}
