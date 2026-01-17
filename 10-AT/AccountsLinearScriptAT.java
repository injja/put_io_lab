package put.selenium.linear;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import put.selenium.utils.ScreenshotAndQuitOnFailureRule;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class AccountsLinearScriptAT {

    private WebDriver driver;

    @Rule
    public ScreenshotAndQuitOnFailureRule screenshotOnFailureAndWebDriverQuitRule =
            new ScreenshotAndQuitOnFailureRule();


    @Before
    public void setUp() {
        this.driver = new ChromeDriver();
        screenshotOnFailureAndWebDriverQuitRule.setWebDriver(driver);
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
    }

    @Test
    public void successfulUserRegistration() throws Exception {
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
        driver.manage().window().setSize(new Dimension(834, 692));
        driver.findElement(By.cssSelector("h3")).click();
        driver.findElement(By.id("contentSingle")).click();
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("DB Reset"));
        driver.findElement(By.id("wrap")).click();
        driver.get("http://localhost:8080/accounts/controller");
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Login"));
        driver.findElement(By.id("contentSingle")).click();
        assertThat(driver.findElement(By.cssSelector("#contentSingle > div:nth-child(4)")).getText(), is("If you want to register click here"));
        driver.findElement(By.linkText("here")).click();
        driver.findElement(By.name("username")).click();
        driver.findElement(By.cssSelector("table")).click();
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("inga");
        driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(1)")).click();
        driver.findElement(By.id("contentSingle")).click();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("inga");
        driver.findElement(By.name("repeat_password")).click();
        driver.findElement(By.name("repeat_password")).sendKeys("inga");
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("inga");
        driver.findElement(By.cssSelector("form")).click();
        driver.findElement(By.name("addressData")).click();
        driver.findElement(By.name("addressData")).sendKeys("adr");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.id("contentSingle")).click();
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Login"));
    }


}
