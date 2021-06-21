package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy (xpath = "//*[@id='add']")
    private WebElement addComputerButton;

    @FindBy (xpath = "//*[@id='searchbox']")
    private WebElement searchTextArea;

    @FindBy (xpath = "//*[@id='searchsubmit']")
    private WebElement searchButton;

    @FindBy (xpath = "//td[1]")
    private WebElement searchResult;

    @FindBy (css = "#main > div.alert-message.warning")
    private WebElement creationResult;



    public AddComputerPage clickOnAddComputerButton(){
        addComputerButton.click();
        return new AddComputerPage(driver);
    }

    public MainPage clickOnSearchTextArea() {
        searchTextArea.click();
        return this;
    }
    public MainPage sendComputerName() {
        searchTextArea.sendKeys("NewComputer");
        return this;
    }

    public MainPage clickOnSearchButton(){
        searchButton.click();
        return this;
    }

    public String getCreationResult() {
        return creationResult.getText();
    }
    public String getFirstResult(){
        return searchResult.getText();
    }
}