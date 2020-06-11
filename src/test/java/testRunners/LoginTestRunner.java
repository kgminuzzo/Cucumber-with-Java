package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Login.feature"},
        glue= {"stepDefinitions"},
        stepNotifications = true,
        plugin = {"json:target/login.json"},
        monochrome = true,
        tags = "@Login",
        strict = true
)
public class LoginTestRunner {
}
