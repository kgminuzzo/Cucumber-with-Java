package stepDefinitions;

import base.BaseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseUtil {

    private BaseUtil baseUtil;

    public LoginTest(BaseUtil util){
        this.baseUtil = util;
    }
    private WebDriver driver;

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("^I am in the login page$")
    @Given("^I am in the login page of the Para Bank Application$")
    public void i_am_in_the_login_page_of_the_Para_Bank_Application() {
        driver.get("http://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials(DataTable table) {
        List<String> loginForm = table.asList();

        driver.findElement(By.name("username")).sendKeys(loginForm.get(0));
        driver.findElement(By.name("password")).sendKeys(loginForm.get(1));
        driver.findElement(By.name("username")).submit();
    }

    @Then("I should be taken to the Overview page")
    public void i_should_be_taken_to_the_Overview_page() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='rightPanel']/div/div/h1")));

        String actualFullName = driver.findElement(By.className("smallText")).getText();
        assertTrue(actualFullName, actualFullName.contains(baseUtil.userFullName));
        driver.findElement(By.xpath("//*[@id='rightPanel']/div/div/h1")).isDisplayed();
        driver.findElement(By.linkText("Log Out")).click();

    }

    @When("^I enter valid (.*) and (.*) with (.*)$")
    public void iEnterValidUsernameAndPassword(String username, String password, String userFullName) {
        baseUtil.userFullName = userFullName;
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("username")).submit();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
