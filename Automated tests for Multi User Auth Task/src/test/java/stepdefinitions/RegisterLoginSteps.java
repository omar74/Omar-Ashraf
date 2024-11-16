package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.RegisterPage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.UUID;

public class RegisterLoginSteps {
    WebDriver driver;
    RegisterPage registerPage;
    LoginPage loginPage;
    String generatedEmail;
    String password;

    // Step to open the Automation Exercise website
    @Given("I open the Automation Exercise website")
    public void i_open_the_automation_exercise_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");

        // Initialize page objects for registration and login
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }

    // Step to register a user with the provided details from the feature file
    @When("I register a user with the following details:")
    public void i_register_a_user_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {

        // Convert the DataTable to a List of Maps to easily access user details
        dataTable.asMaps().forEach(data -> {
            // Open the sign-up form
            registerPage.openSignUpForm();

            // Generate a new unique email for each registration attempt
            generatedEmail = "user" + System.currentTimeMillis() + "@test.com";
            // Set the password to use for registration and login
            password = data.get("password");

            // Enter the sign-up details (name and generated email)
            registerPage.enterSignUpDetails(data.get("name"), generatedEmail);
            // Fill in the registration form with the user's details
            registerPage.fillRegistrationForm(
                    data.get("password"),
                    data.get("day"),
                    data.get("month"),
                    data.get("year"),
                    data.get("firstName"),
                    data.get("lastName"),
                    data.get("address"),
                    data.get("state"),
                    data.get("city"),
                    data.get("zip"),
                    data.get("mobile")
            );
        });
    }

    // Step to log in with the generated email and verify the login was successful
    @Then("login and verify the registered user with email")
    public void i_login_and_verify_the_registered_user_with_email() {
        driver.get("https://automationexercise.com/login");
        loginPage.login(generatedEmail, password);
        loginPage.verifyLogin();

        // Close the browser after verification
        driver.quit();
    }
}
