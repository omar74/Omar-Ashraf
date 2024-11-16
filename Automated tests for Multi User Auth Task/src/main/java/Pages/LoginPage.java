package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    // Element locators
    private By logOutLink = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[text()='Login']");
    private By loggedInLink = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");

    // Constructor to initialize the WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter login credentials and submit
    public void login(String email, String password) {
        driver.findElement(logOutLink).click();
        WebElement emailInput = driver.findElement(emailField);
        WebElement passwordInput = driver.findElement(passwordField);
        WebElement loginBtn = driver.findElement(loginButton);

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    // Method to verify that the login was successful
    public void verifyLogin() {
        boolean isLoggedIn = driver.findElement(loggedInLink).isDisplayed();
        assert isLoggedIn : "User is not logged in";
    }
}
