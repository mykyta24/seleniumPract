import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FirstSeleniumTest {

    private static final String HOME_PAGE_URL = "https://www.facebook.com/";
    private static WebDriver driver;

    @BeforeAll
    public static void classSetup() {
        driver = SharedDriver.getWebDriver();
        driver.get(HOME_PAGE_URL);
    }

    @AfterAll
    public static void classTearDown() {
        SharedDriver.closeDriver();
    }

    @AfterEach
    public void testTeardown() {
        driver.get(HOME_PAGE_URL);
    }

    @Test
    public void homePageURLTest() {
        String actualURL = driver.getCurrentUrl();
        assertEquals(HOME_PAGE_URL, actualURL, "Urls do not match");
    }

    @Test
    public void findEmailFieldTest() {
        //WebElement element = driver.findElement(By.id("email"));
        //WebElement element = driver.findElement(By.name("email"));
        //WebElement element = driver.findElement(By.linkText("Create a Page"));
        //WebElement element = driver.findElement(By.partialLinkText("a Page"));
        //WebElement element = driver.findElement(By.cssSelector("#email"));
        List<WebElement> element = driver.findElements(By.className("inputtext"));
        System.out.println(element.size());
        assertNotNull(element);
    }

    @Test
    public void findElementsByXpathTest() {
        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
        assertNotNull(emailElement);
        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
        assertNotNull(passwordElement);

        WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
        assertNotNull(loginButtonElement);

        WebElement forgoPassElement = driver.findElement(By.xpath("//a[text()='Forgot account']"));
        assertNotNull(forgoPassElement);

        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()= 'Create New Account']"));
        assertNotNull(createNewAccButton);

    }

    @Test
    public void loginScreenTest(){
        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
        assertNotNull(emailElement);
        emailElement.sendKeys("Nikita2408@gmail.com");
        String emailValue = emailElement.getAttribute("value");
        assertEquals("Nikita2408@gmail.com",emailValue);

        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
        assertNotNull(passwordElement);
        passwordElement.sendKeys("123456");
        String passValue = passwordElement.getAttribute("value");
        assertEquals("123456",passValue);

        WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
        assertNotNull(loginButtonElement);

        loginButtonElement.click();
    }
}

