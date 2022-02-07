package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.By.xpath;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='gs-c-promo-body gs-u-display-none gs-u-display-inline-block@m gs-u-mt@xs gs-u-mt0@m gel-1/3@m']//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-paragon-bold nw-o-link-split__anchor']/h3[@class='gs-c-promo-heading__title gel-paragon-bold nw-o-link-split__text']")
    private WebElement firstNews;

    @FindBy(xpath = "//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-paragon-bold nw-o-link-split__anchor']")
    private WebElement firstNewsA;

    @FindBy(xpath = "//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-pica-bold nw-o-link-split__anchor']")
    private List<WebElement> namesOfArticlesList;

    @FindBy(xpath = "//button[@class='orb-search__button']")
    private WebElement searchButton;

    @FindBy(xpath = "//li[@class='ssrcss-so3uhw-GlobalNavigationProduct eki2hvo15']/a[@href='https://www.bbc.com/news']")
    private WebElement backToNewsPage;

    @FindBy(xpath = "//li[contains(@class, 'gs-u-float-left nw-c-nav__wide-menuitem-container')]//a[@href='/news/coronavirus']")
    private WebElement coronavirus;

    @FindBy(xpath = "//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']/a[@class='nw-o-link'][@href='/news/have_your_say']")
    private WebElement coronaStory;

    @FindBy(xpath = "//a[@id='idcta-link']")
    private WebElement signIn;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class='button button--full-width']")
    private WebElement signInButton;

    @FindBy(xpath = "//p[@class='form-message__text']/span/span']")
    private WebElement answerForInput;

    @FindBy(xpath = "//div[@class='gs-c-promo-body gs-u-display-none gs-u-display-inline-block@m gs-u-mt@xs gs-u-mt0@m gel-1/3@m']//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-paragon-bold nw-o-link-split__anchor']/h3[@class='gs-c-promo-heading__title gel-paragon-bold nw-o-link-split__text']")
    private WebElement newsPageTitleFirstArticle;

    @FindBy(xpath = "//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-pica-bold nw-o-link-split__anchor']/h3")
    private List<WebElement> secondaryArticles;

    @FindBy(xpath = "//a[@class='ssrcss-atl1po-PromoLink e1f5wbog0']/span/p")
    private  WebElement expectedNameArticleWithKeyWord;

    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement xButton;

    @FindBy(xpath = "//li[@class='ssrcss-so3uhw-GlobalNavigationProduct eki2hvo15']/a[@href='https://www.bbc.com/news']")
    private WebElement linkToBackNewsPage;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@id='idcta-link']")
    private WebElement signInCoronaTab;

    @FindBy(xpath = "//li[@class='footer__item']")
    private WebElement expectedSignInCoronaTab;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='button button--full-width']")
    private WebElement signInButtonCoronaTab;

    @FindBy(xpath = "//p[@class='form-message__text']/span/span")
    private WebElement answer;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public void search(final String toSearch) {
        driver.findElement((By) searchInput).sendKeys(toSearch);
    }

    public String getTextOfFirstArticle() {
        return firstNews.getText();
    }

    public List<WebElement> getNamesOfArticlesList() {
        return namesOfArticlesList;
    }

    public WebElement getAnswerForInput() {
        return answerForInput;
    }


    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

    public void enterTextToEmailFields(final String email) {
        emailField.sendKeys(email);
    }

    public void enterTextToPasswordFields(final String password) {
        passwordField.sendKeys(password);
        //passwordField.click();
    }

    public void clickOnFirstNewsArticle() {
        firstNews.click();
    }

    public void clickOnFirstNewsArticleA() {
        firstNewsA.click();
    }

    public void clickOnBackToNewsPage() {
        backToNewsPage.click();
    }

    public void clickCoronavirus() {
        coronavirus.click();
    }

    public void clickCoronaStory() {
        coronaStory.click();
    }

    public void clickSignIn() { signIn.click();}

    public void clickOnXButton() { xButton.click();}

    public void clickOnLinkToBackNewsPage() { linkToBackNewsPage.click();}

    public void clickSignInCoronaTab() { signInCoronaTab.click();}

    public void clickEmailField() { emailField.click();}

    public void clickPasswordField() { passwordField.click();}

    public void clickSignInButtonCoronaTab() { signInButtonCoronaTab.click();}

    public void inputDataInput(final String email, final String password ) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

    public WebElement getNewsPageTitleFirstArticle() {
        return newsPageTitleFirstArticle;
    }

    public WebElement getanswer() {
        return answer;
    }

    public boolean isNewsPageTitleFirstArticle() {
        return newsPageTitleFirstArticle.isDisplayed();
    }

    public boolean isCoronaStoryVisible() {
        return coronaStory.isDisplayed();
    }

    public boolean isCoronaSignInVisible() {
        return expectedSignInCoronaTab.isDisplayed();
    }

    public List<WebElement> getNamesSecondaryArticles() {
        return secondaryArticles;
    }

    public WebElement getElementNewsArticles() {
        return expectedNameArticleWithKeyWord;
    }
   // List<WebElement> elementNewsArticles = driver.findElements(xpath(EXPECTED_NAME_ARTICLE_WITH_KEYWORD));

    public List<String> getListTextsElements() {
        List<String> titlesArticlesList = new ArrayList<>();
        titlesArticlesList.add("US rejects Russian demand to bar Ukraine from Nato");
        titlesArticlesList.add("Biden to nominate black woman to top US court");
        titlesArticlesList.add("UK PM vows to fight amid parties row");
        return titlesArticlesList;
    }

    public List<String> getListEqualElements() {
        List<String> textsElements = getNamesSecondaryArticles()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors
                        .toList());
        return textsElements;
    }

     public String WordFromUrl() {
            String url = driver.getCurrentUrl();
            //https://www.bbc.com/news/world-us-canada-60149024
            int index1 = url.indexOf("/", 22);
            int index2 = url.indexOf("-", 22);
            String keyword = url.substring(index1+1,index2);
            return keyword;
    }

    public void enterTextToSearchFields(String partOfUrl){
        searchField.clear();
        searchField.sendKeys(partOfUrl);
        searchField.click();
    }
}
