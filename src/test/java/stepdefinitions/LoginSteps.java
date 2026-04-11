package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;

import java.time.Duration;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    WebDriver driver;

    @Given("user opens browser")
    public void open_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @When("user goes to test site")
    public void go_to_site() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Then("user logs in, incorrect username and password")
    public void login_xusername_and_password() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.id("username")).sendKeys("wrong-username");
        driver.findElement(By.id("password")).sendKeys("wrong-password");
        driver.findElement(By.id("submit")).click();

        String actualCheck = driver.findElement(By.id("error")).getText();
        String expectedCheck = "Your username is invalid!";
        assertEquals(expectedCheck, actualCheck);

        driver.quit();
    }

    @Then("user logs in, incorrect password")
    public void login_xpassword() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("wrong-password");
        driver.findElement(By.id("submit")).click();

        String actualCheck = driver.findElement(By.id("error")).getText();
        String expectedCheck = "Your password is invalid!";
        assertEquals(expectedCheck, actualCheck);

        driver.quit();
    }

    @Then("user logs in")
    public void login() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        String actualCheck = driver.findElement(By.className("post-title")).getText();
        String expectedCheck = "Logged In Successfully";
        assertEquals(expectedCheck, actualCheck);

        driver.quit();
    }

    @Then("user continues without inputs")
    public void login_without_inputs() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.id("submit")).click();

        String actualCheck = driver.findElement(By.id("error")).getText();
        String expectedCheck = "Your username is invalid!";
        assertEquals(expectedCheck, actualCheck);

        driver.quit();
    }

}