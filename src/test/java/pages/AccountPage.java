package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccountPage {

    public AccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(linkText = "Subscribe / unsubscribe to newsletter")
    public WebElement subscribeUnsubscribeToNewsletter;
    @FindBy(xpath = "//input[@name='newsletter'][@value='1']")
    public WebElement yesNewsletterOption;
    @FindBy(xpath = "//input[@name='newsletter'][@value='0']")
    public WebElement noNewsletterOption;

}
