package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[@title='My Account']")
    public WebElement myAccountDropMenu;
    @FindBy(xpath = "//a[text()='Register']")
    public WebElement registerOption;
    @FindBy(linkText = "Login")
    public WebElement loginOption;
    @FindBy(xpath = "//*[@id=\"column-right\"]//a[text()='Register']")
    public WebElement rightColumnRegisterOption;
}
