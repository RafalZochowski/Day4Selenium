package Shop;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegistrationPO extends BasePO {

    @FindBy(css="[name='id_gender'][value='1']")
    private WebElement mrGenderSelection;

    @FindBy(css="[name='id_gender'][value='2']")
    private WebElement mrsGenderSelection;

    @FindBy(name="firstname")
    private WebElement firstNameTextBox;

    @FindBy(name="lastname")
    private WebElement lastNameTextBox;

    @FindBy(name = "email")
    private WebElement emailTextBox;

    @FindBy(name = "password")
    private WebElement passwordTextBox;

    @FindBy(name = "birthday")
    private WebElement birthdayTextBox;

    @FindBy(css = ".form-control-submit")
    private WebElement submitButton;

    public RegistrationPO(WebDriver driver) {
        super(driver);
        ownUrl = "http://5.196.7.235/login?create_account=1";
    }

    public void submit() { submitButton.click(); }

    public void fillBday(String bday) { birthdayTextBox.sendKeys(bday); }

    public void fillPassword(String pwd) { passwordTextBox.sendKeys(pwd); }

    public void fillEmail(String email) { emailTextBox.sendKeys(email); }

    public void fillName(String firstName, String lastName) {
        firstNameTextBox.sendKeys(firstName);
        lastNameTextBox.sendKeys(lastName);
    }

    public void selectMale() { mrGenderSelection.click(); }

    public void selectFemale() { mrsGenderSelection.click(); }

    public void fillFormAndSubmit(boolean male,
                                  String firstname,
                                  String lastname,
                                  String email,
                                  String password,
                                  String birthday) {
        if (male) selectMale();
        else selectFemale();
        fillName(firstname, lastname);
        fillEmail(email);
        fillPassword(password);
        fillBday(birthday);
        submit();
    }

}
