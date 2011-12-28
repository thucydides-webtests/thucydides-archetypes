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

@DefaultUrl("http://en.wiktionary.org/wiki/Wiktionary:Main_Page")
public class DictionaryPage extends PageObject {

    @FindBy(name="search")
	private WebElement searchTerms;
	
	@FindBy(name="go")
	private WebElement lookupButton;
	
	public DictionaryPage(WebDriver driver) {
		super(driver);
	}

	public void enter_keywords(String keyword) {
        element(searchTerms).type(keyword);
	}

    public void lookup_terms() {
        element(lookupButton).click();
    }

    public List<String> getDefinitions() {
        WebElement definitionList = getDriver().findElement(By.tagName("ol"));
        List<WebElement> results = definitionList.findElements(By.tagName("li"));
        return convert(results, toStrings());
    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }
}


