package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AddComputerPage {
    WebDriver driver;
    LocalDate localDate = LocalDate.now();
    LocalDate olderDate = localDate.minusYears(10);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public AddComputerPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='name']")
    private WebElement computerNameTextArea;

    @FindBy(xpath = "//*[@id='introduced']")
    private WebElement introducedTextArea;

    @FindBy(xpath = "//*[@id='discontinued']")
    private WebElement discontinuedTextArea;

    @FindBy(xpath = "//*[@id='company']")
    private WebElement companySelector;

    @FindBy(xpath = "//*[@class='btn primary']")
    private WebElement createThisComputerButton;


    public AddComputerPage clickOnComputerName() {
        computerNameTextArea.click();
        return this;
    }

    public AddComputerPage sendComputerName() {
        computerNameTextArea.sendKeys("NewComputer");
        return this;
    }

    public AddComputerPage clickOnIntroducedDate() {
        introducedTextArea.click();
        return this;
    }

    public AddComputerPage sendIntroducedDate() {
        introducedTextArea.sendKeys(olderDate.format(formatter));
        return this;
    }

    public AddComputerPage clickOnDiscontinuedDate() {
        discontinuedTextArea.click();

        return this;
    }
    public AddComputerPage sendDiscontinuedDate(){
        discontinuedTextArea.sendKeys(localDate.format(formatter));
        return this;
    }

    public AddComputerPage selectFirstElement(){
        WebElement selectElement = companySelector;
        Select select = new Select(selectElement);
        select.selectByIndex(1);
        return this;
    }

    public AddComputerPage clickOnCreateThisComputerButton() {
        createThisComputerButton.click();
        return this;
    }
}

