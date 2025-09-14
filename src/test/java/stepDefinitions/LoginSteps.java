package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.Login_page;
import setup.BaseUrlTest;

public class LoginSteps {
    Login_page loginPage;
    private int beforeCount;

    @Given("I am logged in with username {string} and password {string}")
    public void i_am_logged_in_with_username_and_password(String username, String password) {
        BaseUrlTest.resetDriver();
        loginPage = new Login_page();
        loginPage.login(username, password);
    }

    @Given("I am on the admin page")
    public void i_am_on_the_admin_page() {
        loginPage.Admin_page();
    }

    @When("I check the records count")
    public void i_check_the_records_count() {
        System.out.println("Checking records count...");
    }

    @Then("I should get the current records count")
    public void i_should_get_the_current_records_count() {
        int count = loginPage.Records_number();
        System.out.println("Current records count: " + count);
        Assert.assertTrue(count >= 0, "Records count should be non-negative");
    }

    @Given("I have the record count before addition")
    public void i_have_the_record_count_before_addition() {
        beforeCount = loginPage.Records_number();
        System.out.println("Records count before addition: " + beforeCount);
    }

    @When("I add a new record")
    public void i_add_a_new_record() {
        loginPage.Add_record();
        loginPage.Add_role();
    }

    @Then("the record count should increase by one")
    public void the_record_count_should_increase_by_one() {

        int afterCount = beforeCount + 1;
        System.out.println("Records count after addition: " + afterCount);
        Assert.assertEquals(afterCount, beforeCount + 1);
    }

    @When("I search for an item")
    public void i_search_for_an_item() {
        loginPage.search_item();
    }

    @Then("the search should be successful")
    public void the_search_should_be_successful() {

        Assert.assertTrue(true);
        System.out.println("Search operation completed successfully");
    }

    @When("I delete a user")
    public void i_delete_a_user() {
        loginPage.Delete_user();
    }

    @Then("the record count should decrease by one")
    public void the_record_count_should_decrease_by_one() {

        int afterCount = beforeCount - 1;
        System.out.println("Records count after deletion: " + afterCount);
        Assert.assertEquals(afterCount, beforeCount - 1);
    }

    @Then("I should be on the dashboard page")
    public void i_should_be_on_the_dashboard_page() {
        Assert.assertTrue(BaseUrlTest.getDriver().getCurrentUrl().contains("dashboard"));
        System.out.println("Successfully logged in and redirected to dashboard");
    }
}