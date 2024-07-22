package step_definitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;

public class AccountPageSteps {

    AccountPage accountPage = new AccountPage();

    @When("the user clicks on the SubscribeUnsubscribe to newsletter option")
    public void the_user_clicks_on_the_subscribe_unsubscribe_to_newsletter_option() {
        accountPage.subscribeUnsubscribeToNewsletter.click();
    }
    @Then("the Yes option should be displayed as selected by default in the Newsletter page")
    public void the_yes_option_should_be_displayed_as_selected_by_default_in_the_newsletter_page() {
        accountPage.yesNewsletterOption.click();
    }
    @Then("the No option should be displayed as selected by default in the Newsletter page")
    public void the_no_option_should_be_displayed_as_selected_by_default_in_the_newsletter_page() {
        accountPage.noNewsletterOption.click();
    }

}
