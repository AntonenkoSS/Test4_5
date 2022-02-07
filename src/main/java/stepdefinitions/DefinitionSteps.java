package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static final String FIRST_ARTICLE_NAME = "Prince Andrew denies he was close to Maxwell";
    private static final long DEFAULT_TIMEOUT = 300;

    WebDriver driver;
    pages.HomePage homePage;
    pages.NewsPage newsPage;
    pages.SearchResultPage searchResultPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }
    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }
    @And("User checks header visibility")
    public void checkHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isHeaderVisible();
    }
    @And("User checks footer visibility")
    public void checkLastDivVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isFooterVisible();
    }
    @And("User checks sign in button visibility")
    public void checkSignInButtonVisibility() {
        homePage.isSignInButtonVisible();
    }
    @When("User clicks 'Sign In' button")
    public void clickSignInButton() {
        homePage.clickHelloSignInButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }
    @Then("User checks email and password fields visibility on sign in popup")
    public void checkEmailVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSignInPage());
        assertTrue(homePage.isEmailFieldVisible());
        assertTrue(homePage.isPasswordFieldVisible());
    }
    @And("User checks that current url contains {string} language")
    public void checkCurrentUrl(final String language) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(language));
    }
    @When("User clicks 'Hello Sign In' button")
    public void userClicksTodayDealsButton() {
        homePage.clickHelloSignInButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }
    @Then("User checks that current url contains {string}")
    public void userChecksThatCurrentUrlContainsKeyword(final String keyword){
        assertTrue(driver.getCurrentUrl().contains(keyword));
    }
    @And("User opens news page")
    public void userOpensNewsPage() {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @When("User checks first article visibility")
    public void userChecksFirstArticleVisibility() {
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        newsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, newsPage.getNewsPageTitleFirstArticle());
        assertTrue(newsPage.isNewsPageTitleFirstArticle());
    }
    @Then("User checks that name first article")
    public void userChecksThatNameFirstArticle() {
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(newsPage.getNewsPageTitleFirstArticle(), FIRST_ARTICLE_NAME);
    }
    @Then("User checks that names equals expected names")
    public void userChecksThatNamesEqualsExpectedNames() {
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(newsPage.getListEqualElements().containsAll(newsPage.getListTextsElements()));
    }
    @And("User click first article")
    public void userClickFirstArticle() {
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        newsPage.clickOnFirstNewsArticle();
    }
    @And("User click first article a")
    public void userClickFirstArticleA() {
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        newsPage.clickOnFirstNewsArticleA();
    }
    @And("User close popup window")
    public void userClosePopupWindow() {
        newsPage.clickOnXButton();
    }
    @And("User take part current url")
    public String userChecksThatCurrentUrlContains() {
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        String partOfUrl = newsPage.WordFromUrl();
        return partOfUrl;
    }
    @And("User come back to news page")
    public void userComeBackToNewsPage() {
        newsPage.clickOnLinkToBackNewsPage();
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }
    @And("User enters in search field the keyword")
    public void userEntersInSearchFieldTheKeyword() {
        newsPage.enterTextToSearchFields(userChecksThatCurrentUrlContains());
    }
    @Then("User checks the title of the first article against the keyword")
    public void userChecksTheTitleOfTheFirstArticleAgainstTheKeyword() {
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals("World", newsPage.getElementNewsArticles().getText());
    }
    @And("User opens corona tab")
    public void userOpensCoronaTab() {
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        newsPage.clickCoronavirus();
    }
    @And("User opens corona story tab")
    public void userOpensCoronaStoryTab() {
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        newsPage.clickCoronaStory();
    }
    @And("User clicks 'Sign In' button on this tab")
    public void userClicksSignInButtonOnThisTab() {
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        newsPage.clickSignInCoronaTab();
    }
    @When("User checks corona story tab visibility")
    public void userChecksCoronaStoryTabVisibility() {
        newsPage.isCoronaStoryVisible();
    }

    @And("User checks footer visibility on this tab")
    public void userChecksFooterVisibilityOnThisTab() {
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        newsPage.isCoronaSignInVisible();
    }
    @When("User enters {string}")
    public void userEntersEmail(final String text) {
        newsPage.clickEmailField();
        newsPage.enterTextToEmailFields(text);
    }
    @And("User enters {string} password")
    public void userEntersPassword(final String text) {
        newsPage.clickPasswordField();
        newsPage.enterTextToPasswordFields(text);
    }
    @And("User click 'Sign In' button on modal")
    public void userClickSignInButtonOnModal() {
        newsPage.clickSignInButtonCoronaTab();
    }
    @Then("User gets an answer and checks field contains needed {string}")
    public void userGetsAnAnswerAndChecksFieldContainsNeededAnswer(final String text) {
        assertTrue(newsPage.getanswer().getText().contains(text));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
