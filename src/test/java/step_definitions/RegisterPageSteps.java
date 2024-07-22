package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AccountSuccessPage;
import pages.RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class RegisterPageSteps {

    RegisterPage registerPage = new RegisterPage();
    AccountSuccessPage accountSuccessPage = new AccountSuccessPage();

    @Given("the user is on the Register Account page")
    public void the_user_is_on_the_register_account_page() {
        Driver.getDriver().get(ConfigReader.getProperty("url") + "/index.php?route=account/register");
    }
    @Then("the user should be taken to the Register Account page")
    public void the_user_should_be_taken_to_the_register_account_page() {
        String expectedTitle = "Register Account";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Redirection to the Register Account page failed!");
    }
    @When("the user enters the following details into the mandatory fields:")
    public void the_user_enters_the_following_details_into_the_mandatory_fields(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            registerPage.mandatoryFields.get(i).sendKeys(list.get(i));
        }
        registerPage.privacyPolicyField.click();
    }
    @When("the user enters the following details into all the fields:")
    public void the_user_enters_the_following_details_into_all_the_fields(List<String> list) {
        the_user_enters_the_following_details_into_the_mandatory_fields(list);
        registerPage.yesNewsletterOption.click();
    }
    @When("the user clicks on the Yes radio option for Newsletter")
    public void the_user_clicks_on_the_yes_radio_option_for_newsletter() {
        registerPage.yesNewsletterOption.click();
    }
    @When("the user clicks on the No radio option for Newsletter")
    public void the_user_clicks_on_the_no_radio_option_for_newsletter() {
        registerPage.noNewsletterOption.click();
    }
    @When("the user clicks on the Continue button")
    public void the_user_clicks_on_the_continue_button() {
        registerPage.continueButton.click();
    }
    @Then("the user should see the Account Success page")
    public void the_user_should_see_the_account_success_page() {
        String expectedPageTitle = "Your Account Has Been Created!";
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedPageTitle, "Account Creation Failed");
    }
    @When("the user clicks on the Continue button on the Account Success page")
    public void the_user_clicks_on_the_continue_button_on_the_account_success_page() {
        accountSuccessPage.continueButton.click();
    }
    @Then("the user should be taken to the Account page")
    public void the_user_should_be_taken_to_the_account_page() {
        String expectedTitle ="My Account";
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle, "Redirection to the Account page Failed!");
    }
    @When("the user does not enter any details into the fields and clicks on the Continue button")
    public void the_user_does_not_enter_any_details_into_the_fields_and_clicks_on_the_continue_button() {
        registerPage.continueButton.click();
    }
    @Then("the warning message {string} should be displayed for the First Name field")
    public void the_warning_message_should_be_displayed_for_the_first_name_field(String expectedWarningMessage) {
        String actualWarningMessage = registerPage.firstNameWarning.getText();
        Assert.assertEquals(actualWarningMessage, expectedWarningMessage, "Warning message for the First Name field failed!");
    }
    @Then("the warning message {string} should be displayed for the Last Name field")
    public void the_warning_message_should_be_displayed_for_the_last_name_field(String expectedWarningMessage) {
        String actualWarningMessage = registerPage.lastNameWarning.getText();
        Assert.assertEquals(actualWarningMessage, expectedWarningMessage, "Warning message for the Last Name field failed!");
    }
    @Then("the warning message {string} should be displayed for the E-Mail field")
    public void the_warning_message_should_be_displayed_for_the_e_mail_field(String expectedWarningMessage) {
        String actualWarningMessage = registerPage.emailWarning.getText();
        Assert.assertEquals(actualWarningMessage, expectedWarningMessage, "Warning message for the E-mail field failed!");
    }
    @Then("the warning message {string} should be displayed for the Telephone field")
    public void the_warning_message_should_be_displayed_for_the_telephone_field(String expectedWarningMessage) {
        String actualWarningMessage = registerPage.telephoneWarning.getText();
        Assert.assertEquals(actualWarningMessage, expectedWarningMessage, "Warning message for the Telephone field failed!");
    }
    @Then("the warning message {string} should be displayed for the Password field")
    public void the_warning_message_should_be_displayed_for_the_password_field(String expectedWarningMessage) {
        String actualWarningMessage = registerPage.passwordWarning.getText();
        Assert.assertEquals(actualWarningMessage, expectedWarningMessage, "Warning message for the Password field failed!");
    }
    @Then("the warning message {string} should be displayed at the top")
    public void the_warning_message_should_be_displayed_at_the_top(String expectedWarningMessage) {
        String actualWarningMessage = registerPage.privacyPolicyWarning.getText();
        Assert.assertEquals(actualWarningMessage, expectedWarningMessage, "Warning message for the Privacy Policy field failed!");
    }

    @When("the user enters the following details into firstName {string}, lastName {string}, email {string}, telephone {string}, password {string}, passwordConfirm {string} fields")
    public void the_user_enters_the_following_details_into_first_name_last_name_email_telephone_password_password_confirm_fields(String firstName, String lastName, String email, String telephone, String password, String passwordConfirm) {
        registerPage.firstNameField.sendKeys(firstName);
        registerPage.lastNameField.sendKeys(lastName);
        registerPage.emailField.sendKeys(email);
        registerPage.telephoneField.sendKeys(telephone);
        registerPage.passwordField.sendKeys(password);
        registerPage.confirmPasswordField.sendKeys(passwordConfirm);
    }
    @Then("the account should not be created")
    public void the_account_should_not_be_created() {
        Assert.assertEquals(Driver.getDriver().getTitle(), "Register Account", "Account created with invalid password confirmation!");
    }
    @Then("the warning message {string} should be displayed under the Password Confirm field")
    public void the_warning_message_should_be_displayed_under_the_password_confirm_field(String expectedWarningMessage) {
        String actualWarningMessage = registerPage.confirmPasswordWarning.getText();
        Assert.assertEquals(actualWarningMessage, expectedWarningMessage, "Warning message for the Confirm Password field failed!");
    }
}
