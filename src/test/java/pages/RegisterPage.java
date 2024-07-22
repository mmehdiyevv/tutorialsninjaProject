package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class RegisterPage {

    public RegisterPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "input-firstname")
    public WebElement firstNameField;
    @FindBy(id = "input-lastname")
    public WebElement lastNameField;
    @FindBy(id = "input-email")
    public WebElement emailField;
    @FindBy(id = "input-telephone")
    public WebElement telephoneField;
    @FindBy(id = "input-password")
    public WebElement passwordField;
    @FindBy(id = "input-confirm")
    public WebElement confirmPasswordField;
    @FindBy(name = "agree")
    public WebElement privacyPolicyField;
    @FindBy(css = "[value = 'Continue']")
    public WebElement continueButton;
    @FindBy(xpath = "//input[@name='newsletter'][@value='1']")
    public WebElement yesNewsletterOption;
    @FindBy(xpath = "//input[@name='newsletter'][@value='0']")
    public WebElement noNewsletterOption;

    @FindBy(xpath = "//form[@class='form-horizontal']//input[@class='form-control']")
    public List<WebElement> mandatoryFields;

    @FindBy(xpath = "//input[@name='firstname']/following-sibling::div")
    public WebElement firstNameWarning;
    @FindBy(xpath = "//input[@name='lastname']/following-sibling::div")
    public WebElement lastNameWarning;
    @FindBy(xpath = "//input[@name='email']/following-sibling::div")
    public WebElement emailWarning;
    @FindBy(xpath = "//input[@name='telephone']/following-sibling::div")
    public WebElement telephoneWarning;
    @FindBy(xpath = "//input[@name='password']/following-sibling::div")
    public WebElement passwordWarning;
    @FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
    public WebElement privacyPolicyWarning;
    @FindBy(xpath = "//input[@name='confirm']/following-sibling::div")
    public WebElement confirmPasswordWarning;









}
