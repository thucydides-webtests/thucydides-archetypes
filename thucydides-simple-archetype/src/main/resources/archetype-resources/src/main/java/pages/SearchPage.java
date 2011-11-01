#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("http://www.google.com")
public class SearchPage extends PageObject {

    @FindBy(name="q")
	private WebElement searchInput;
	
	@FindBy(name="bngG")
	private WebElement searchButton;
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}

	public void enter_keywords(String keyword) {
		searchInput.sendKeys(keyword);
	}

    public void starts_search() {
        searchInput.sendKeys(Keys.ENTER);
        waitForRenderedElements(By.xpath("//span[.='Next']"));
    }

    public List<String> getResultTitles() {
        List<WebElement> results = getDriver().findElements(By.cssSelector(".r"));
        return convert(results, new ExtractTitle());
    }

    class ExtractTitle implements Converter<WebElement, String> {
        public String convert(WebElement from) {
            return from.getText();
        }
    }
}


