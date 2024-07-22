package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class HomePageSteps {
    HomePage homePage = new HomePage();
    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @When("the user clicks on the My Account drop menu")
    public void the_user_clicks_on_the_my_account_drop_menu() {
        homePage.myAccountDropMenu.click();
    }
    @When("the user clicks on the Register option")
    public void the_user_clicks_on_the_register_option() {
        homePage.registerOption.click();
    }
    @When("the user clicks on the Login option")
    public void the_user_clicks_on_the_login_option() {
        homePage.loginOption.click();
    }
    @When("the user clicks on the Register option from the Right Column options")
    public void the_user_clicks_on_the_register_option_from_the_right_column_options() {
        homePage.rightColumnRegisterOption.click();
    }

}
