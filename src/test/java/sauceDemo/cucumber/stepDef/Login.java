package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User already in login page")
    public void userAlreadyInLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
    }

    @When("User input username")
    public void userInputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("User input password")
    public void userInputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("User click login button")
    public void userClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User on dashboard page")
    public void userOnDashboardPage() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div"));
        String username = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(username, "Swag Labs");
    }

    @And("User input invalid password")
    public void userInputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauceeee");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String loginFailed = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
        Assert.assertEquals(loginFailed, "Epic sadface: Username and password do not match any user in this service");
    }

    @When("User click hamburger menu")
    public void userClickHamburgerMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("User click logout")
    public void userClickLogout() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("User back to login page")
    public void userBackToLoginPage() {
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
    }

    @And("User click add to cart")
    public void userClickAddToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("User click cart")
    public void userClickCart() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @Then("User click checkout")
    public void userClickCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    @When("User input first name")
    public void userInputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("1");
    }

    @And("User input last name")
    public void userInputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("2");
    }

    @And("User input zip")
    public void userInputZip() {
        driver.findElement(By.id("postal-code")).sendKeys("3");
    }

    @Then("User click continue")
    public void userClickContinue() {
        driver.findElement(By.id("continue")).click();
    }

    @And("User click finish")
    public void userClickFinish() {
        driver.findElement(By.id("finish")).click();
    }

    @And("User click back")
    public void userClickBack() {
        driver.findElement(By.id("back-to-products")).click();
    }
}
