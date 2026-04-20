package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

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
        driver.get("file:///C:/Users/jacob/Desktop/School%20Code/Register%20Basketball/Register.html");
    }

    @Then("user logs in")
    public void login() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.id("dp")).sendKeys("01/01/1973");
        driver.findElement(By.id("member_firstname")).sendKeys("testname");
        driver.findElement(By.id("member_lastname")).sendKeys("lastname");
        driver.findElement(By.id("member_emailaddress")).sendKeys("testmail@gmail.com");
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("testmail@gmail.com");
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("testpassword");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("testpassword");

        driver.findElement(By.cssSelector("label[for='signup_basketballrole_21']")).click();
        driver.findElement(By.cssSelector("label[for='signup_basketballrole_19']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_25']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_26']")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']")).click();
        driver.findElement(By.name("join")).click();

        WebElement element = driver.findElement(
            By.xpath("//h2[contains(text(),'THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND')]")
        );
        String actualText = element.getText();
        String expectedCheck = "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND";
        assertEquals(expectedCheck, actualText);

        driver.quit();
    }

    @Then("user logs in, no last name")
    public void loginxlast_name() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.id("dp")).sendKeys("01/01/1973");
        driver.findElement(By.id("member_firstname")).sendKeys("testname");
        driver.findElement(By.id("member_emailaddress")).sendKeys("testmail@gmail.com");
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("testmail@gmail.com");
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("testpassword");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("testpassword");

        driver.findElement(By.cssSelector("label[for='signup_basketballrole_21']")).click();
        driver.findElement(By.cssSelector("label[for='signup_basketballrole_19']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_25']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_26']")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']")).click();
        driver.findElement(By.name("join")).click();

        WebElement element = driver.findElement(
                By.xpath("//span[contains(text(),'Last Name is required')]")
        );
        String actualText = element.getText();
        String expectedCheck = "Last Name is required";
        assertEquals(expectedCheck, actualText);

        driver.quit();
    }

    @Then("user logs in, non matching passwords")
    public void loginxpassword_match() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.id("dp")).sendKeys("01/01/1973");
        driver.findElement(By.id("member_firstname")).sendKeys("testname");
        driver.findElement(By.id("member_lastname")).sendKeys("lastname");
        driver.findElement(By.id("member_emailaddress")).sendKeys("testmail@gmail.com");
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("testmail@gmail.com");
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("testpassword");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("testpassword123");

        driver.findElement(By.cssSelector("label[for='signup_basketballrole_21']")).click();
        driver.findElement(By.cssSelector("label[for='signup_basketballrole_19']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_25']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_26']")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']")).click();
        driver.findElement(By.name("join")).click();

        WebElement element = driver.findElement(
                By.xpath("//span[contains(text(),'Password did not match')]")
        );
        String actualText = element.getText();
        String expectedCheck = "Password did not match";
        assertEquals(expectedCheck, actualText);

        driver.quit();
    }

    @Then("user logs in, didn't accept terms")
    public void loginxterms() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.id("dp")).sendKeys("01/01/1973");
        driver.findElement(By.id("member_firstname")).sendKeys("testname");
        driver.findElement(By.id("member_lastname")).sendKeys("lastname");
        driver.findElement(By.id("member_emailaddress")).sendKeys("testmail@gmail.com");
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("testmail@gmail.com");
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("testpassword");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("testpassword");

        driver.findElement(By.cssSelector("label[for='signup_basketballrole_19']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_25']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_26']")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']")).click();
        driver.findElement(By.name("join")).click();

        WebElement element = driver.findElement(
                By.xpath("//h2[contains(text(),'THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND')]")
        );
        String actualText = element.getText();
        String expectedCheck = "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND";
        assertEquals(expectedCheck, actualText);

        driver.quit();
    }

}