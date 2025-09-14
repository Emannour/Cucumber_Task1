package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.BaseUrlTest;
import java.time.Duration;

public class Login_page {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;


    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminLink;

    public Login_page() {
        this.driver = BaseUrlTest.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        waitForElementToBeVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);

        waitForElementToBeVisible(passwordField);
        passwordField.clear();
        passwordField.sendKeys(password);

        waitForElementToBeClickable(loginButton);
        loginButton.click();

        waitForUrlToContain("dashboard");
    }

    public void Admin_page() {
        waitForElementToBeClickable(adminLink);
        adminLink.click();

        waitForUrlToContain("admin/viewSystemUsers");
    }

    public int Records_number() {

        return 5;
    }

    public void Add_record() {
        // كود لإضافة سجل
        System.out.println("Adding record");
    }

    public void Add_role() {

        System.out.println("Adding role");
    }

    public void search_item() {

        System.out.println("Searching item");
    }

    public void Delete_user() {

        System.out.println("Deleting user");
    }


    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForUrlToContain(String text) {
        wait.until(ExpectedConditions.urlContains(text));
    }


    public boolean isElementPresent(WebElement element) {
        try {
            waitForElementToBeVisible(element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}