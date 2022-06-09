import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsTest {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        actions = new Actions(driver);
    }

    @Given("User has access to url {string}.")
    public void user_has_access_to_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }
    @When("User clicks on the Actions link.")
    public void user_clicks_on_the_actions_link() {
        driver.findElement(By.id("navbar-lvl1-actions")).click();
    }
    @Then("Actions page should load and have a title of {string}.")
    public void actions_page_should_load_and_have_a_title_of(String menuName) {
        Assert.assertEquals(menuName, driver.getTitle());
    }

    @And("User double-clicks on the button for a delayed message.")
    public void userDoubleClicksOnTheButtonWithDelayedMessage() {
        WebElement btn = driver.findElement(By.id("acts-btn-dbl-click-delayed"));
        actions.moveToElement(btn)
                .doubleClick()
                .build().perform();
    }

    @Then("User should eventually see the delayed message {string}.")
    public void userShouldEventuallySeeTheDelayedMessage(String delayedMsg) {
        wait.until(ExpectedConditions.textToBe(By.id("acts-msg-dbl-click-delayed"), delayedMsg));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
