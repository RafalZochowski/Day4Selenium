package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class FormPO extends BasePO{

    @FindBy(id = "inputFirstName3" )
    private WebElement inputFirstName3;

    @FindBy(id = "inputLastName3")
    private  WebElement inputLastName3;

    @FindBy(id = "inputAge3")
    private WebElement inputAge3;

    @FindBy( id = "inputEmail3")
    private WebElement inputEmail3;

    @FindBy (name = "gridRadiosSex")
    private List<WebElement> gridRadiosSex;

    @FindBy (css = "input[name=gridRadiosExperience]")
    private List<WebElement> yearsOfExpirence;

    @FindBy (name = "gridCheckboxProfession")
    private List<WebElement>  profession;

    @FindBy (id = "selectContinents")
    private WebElement selectContinents;

    @FindBy(id = "selectSeleniumCommands")
    private List<WebElement> wybierzKomendySelnium;

    @FindBy(id ="chooseFile")
    private WebElement chooseFile;

    @FindBy (id ="uploadFile")
    private WebElement uploadFile;

    @FindBy (css = "[type='submit']")
    private WebElement signIt;

    @FindBy(id = "validator-message")
    private WebElement weryfikacja;






    public void  fillName(String firstName, String lastName, String wiek, String email){
        inputFirstName3.sendKeys(firstName);
        inputLastName3.sendKeys(lastName);
        inputAge3.sendKeys(wiek);
        inputEmail3.sendKeys(email);

    }

    public void wgrajPlik(){
        File file =new File("src/main/resources/file.txt");
        chooseFile.sendKeys(file.getAbsolutePath());

    }
    public void ustawPlec(String plec){
        switch (plec) {
            case "mężczyzna":
                gridRadiosSex.get(0).click();
            case "kobieta":
                gridRadiosSex.get(1).click();
            case "inna":
                gridRadiosSex.get(2).click();
        }
    }

    public void ustawLataDoswiadczenia(){
        getRandomElement(yearsOfExpirence).click();

    }

    public void ustawZawod(){
         getRandomElement(profession).click();
    }

   public void ustawKontynent(){
        Select kontynenty= new Select(selectContinents);
        List<WebElement> opcje = kontynenty.getOptions();
        opcje.remove(1);

        WebElement randomkontinent= getRandomElement(opcje);
        kontynenty.selectByVisibleText(randomkontinent.getText());
    }

    public void komendySelenium(){
        getRandomElement(wybierzKomendySelnium).click();
    }

    public  void nacisnijPrzyciskSignIn(){
        signIt.click();

    }

    public String sprawdz(){
     return weryfikacja.getText();
    }


    public  void wypelnijFormularz(){
        fillName( "Bogdan", "Wiadro", "20","o2@o2");
        wgrajPlik();
        ustawPlec("inna");
        ustawLataDoswiadczenia();
        ustawZawod();
        ustawKontynent();
        komendySelenium();
        nacisnijPrzyciskSignIn();



    }

    public int getRandomNumber(int max){
        Random rnd = new Random();
        return rnd.nextInt(max) +1;
    }

    public WebElement getRandomElement(List<WebElement> webElements){
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(webElements.size());
        return webElements.get(randomNumber);
    }

    public FormPO(WebDriver driver) {
        super(driver);
        ownUrl="https://seleniumui.moderntester.pl/form.php";

    }


//public FormPO(WebDriver driver){
   //     PageFactory.initElements(driver,this);
    //    driver.get("https://seleniumui.moderntester.pl/form.php");
    //}
}
