package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;


public class RegisterPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    private By signUpLink = By.linkText("Signup / Login");
    private By nameField = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
    private By emailField = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
    private By signUpButton = By.xpath("//button[text()='Signup']");
    private By passwordField = By.name("password");
    private By dayDropdown = By.name("days");
    private By monthDropdown = By.name("months");
    private By yearDropdown = By.name("years");
    private By firstNameField = By.name("first_name");
    private By lastNameField = By.name("last_name");
    private By addressField = By.name("address1");
    private By stateField = By.name("state");
    private By cityField = By.name("city");
    private By zipField = By.name("zipcode");
    private By mobileField = By.name("mobile_number");
    private By createAccountButton = By.xpath("//button[text()='Create Account']");

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    // Methods
    public void openSignUpForm() {
        driver.findElement(signUpLink).click();
    }


    public void enterSignUpDetails(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(signUpButton).click();
    }

    public void fillRegistrationForm(String password, String day, String month, String year,
                                     String firstName, String lastName, String address,
                                     String state, String city, String zip, String mobile) {

        driver.findElement(passwordField).sendKeys(password);
        new Select(driver.findElement(dayDropdown)).selectByValue(day);
        new Select(driver.findElement(monthDropdown)).selectByValue(month);
        new Select(driver.findElement(yearDropdown)).selectByValue(year);
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipField).sendKeys(zip);
        driver.findElement(mobileField).sendKeys(mobile);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(createAccountButton));
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        driver.findElement(createAccountButton).click();
    }
}
