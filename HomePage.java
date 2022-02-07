package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchInput;

    @FindBy(xpath = "//li[contains(@class, 'nw-c-nav__wide-menuitem-container')]/a[@class='nw-o-link'][@href='/news/business']")
    private WebElement businessPageButton;

    @FindBy(xpath = "//div[@id='orb-nav-links']/ul/li[@class='orb-nav-newsdotcom']/a[@href='https://www.bbc.com/news']")
    private WebElement newsPageButton;

    @FindBy(xpath = "//div[contains(@class, 'gs-u-mt gs-u-mt0@xs')]//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-pica-bold nw-o-link-split__anchor']/h3")
    private WebElement nameFirstNews;

    @FindBy(xpath = "//button[@class='orb-search__button']")
    private WebElement searchButton;

    @FindBy(xpath = "//section[@class='module module--header']")
    private WebElement header;

    @FindBy(xpath = "//div[@class='orb-footer']")
    private WebElement footer;

    @FindBy(xpath = "//span[@id='idcta-username']")
    private WebElement signInButton;

    @FindBy(xpath = "")
    private WebElement signInPage;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {driver.get(url);}

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

    public void clickOnBusinessPageButton() {
        businessPageButton.click();
    }

    public void clickOnNewsPage() {
        newsPageButton.click();
    }

    public String getTextNameFirstNews() {
        return nameFirstNews.getText();
    }

    public boolean isHeaderVisible() {
        return header.isDisplayed();
    }

    public boolean isFooterVisible() {
        return footer.isDisplayed();
    }

    public boolean isSignInButtonVisible() {
        return signInButton.isDisplayed();
    }

    public void clickHelloSignInButton() {
        signInButton.click();
    }

    public WebElement getSignInPage() {
        return signInPage;
    }

    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return passwordField.isDisplayed();
    }

}
