package step_definitions;

import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageSteps {

    LoginPage loginPage = new LoginPage();
    @When("the user clicks on the Continue button inside the New Customer box")
    public void the_user_clicks_on_the_continue_button_inside_the_new_customer_box() {
        loginPage.continueButtonInsideNewCustomerBox.click();
    }
}
