package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@class='ssrcss-11rb3jo-Promo ett16tt0']")
    private List<WebElement> searchResultsArticleList;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public int getSearchResultCount() {
        return getSearchResultsArticleList().size();
    }

    public List<WebElement> getSearchResultsArticleList() {
        return searchResultsArticleList;
    }


}
