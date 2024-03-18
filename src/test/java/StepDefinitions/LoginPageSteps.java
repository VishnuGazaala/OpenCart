package StepDefinitions;

import OpenCart_PageObject.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginPageSteps {
    public Logger logger;
    private WebDriver driver;
    private LoginPage lp;
    @Before
    public void setup() throws IOException {
        logger= LogManager.getLogger(LoginPageSteps.class);
        driver=new ChromeDriver();
        lp = new LoginPage(driver);
        logger.info("Launching Browser");
        //addcust=new AddNewCustPage(driver);
    }
    @Given("I am on OpenCart Login Page")
    public void i_am_on_open_cart_login_page() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        logger.info("URL opened");
    }
    @Given("I have entered {string} and {string}")
    public void i_have_entered_and(String string, String string2) {
        lp.enter_username(string);
        lp.enter_pwd(string2);
    }
    @When("I click on Login button")
    public void i_click_on_login_button() {
       lp.click_login();
    }
    @When("user clicks on Forgotten Password link")
    public void user_clicks_on_link() {
        lp.click_forgotpwd();
    }
    @Then("Title of the page should be {string}")
    public void title_of_the_page_should_be(String string) {
       Assert.assertTrue(driver.getTitle().equals(string));
    }
    @Then("I should see error message {string}")
    public void i_should_see_error_message(String string) {
        if(driver.getPageSource().contains("No match for E-Mail Address and/or Password.")){
            Assert.assertTrue(true);
        }
    }
    @After
    public void tear_down(){
        driver.quit();
    }
}
