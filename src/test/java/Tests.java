import io.qameta.allure.Description;
import org.junit.rules.ErrorCollector;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AddComputerPage;
import pages.MainPage;
import java.util.concurrent.TimeUnit;


public class Tests {

    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Rule
    public ErrorCollector collector = new ErrorCollector();


    @Test
    public void AddComputerTest() {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        AddComputerPage addComputerPage = PageFactory.initElements(driver, AddComputerPage.class);

        System.out.println("Going to Main Page");
        driver.get("http://computer-database.gatling.io/computers");

        System.out.println("Going to 'Add a computer' page");
        mainPage.clickOnAddComputerButton();

        System.out.println("Name input");
        addComputerPage.clickOnComputerName().sendComputerName();
        System.out.println("Introduced date input");
        addComputerPage.clickOnIntroducedDate().sendIntroducedDate();
        System.out.println("Discontinued date input");
        addComputerPage.clickOnDiscontinuedDate().sendDiscontinuedDate();
        System.out.println("Select first element from selector");
        addComputerPage.selectFirstElement();

        System.out.println("Click on 'Create This Computer' button ");
        addComputerPage.clickOnCreateThisComputerButton();

        System.out.println("Checking for corresponding massage after creating 'NewComputer' ");
        try{
            Assert.assertEquals("Done ! Computer NewComputer has been created", mainPage.getCreationResult());
        }catch (Throwable t){
            collector.addError(t);
        }

        System.out.println("Searching for creation result by filter 'NewComputer'");
        driver.navigate().refresh();
        mainPage.clickOnSearchTextArea().sendComputerName().clickOnSearchButton();


        System.out.println("Checking for corresponding result from search");
        try {
            Assert.assertEquals("NewComputer", mainPage.getFirstResult());
        } catch (Throwable t) {
            collector.addError(t);
        }
    }

    @After
    public void tearDown() {
        System.out.println("Closing browser");
        driver.quit();
    }
}
