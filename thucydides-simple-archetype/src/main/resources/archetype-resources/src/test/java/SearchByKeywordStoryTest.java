#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import ${package}.requirements.Application.Search.SearchBySingleKeyword;
import ${package}.steps.EndUserSteps;

@Story(SearchBySingleKeyword.class)
@RunWith(ThucydidesRunner.class)
public class SearchByKeywordStoryTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://www.wikipedia.com")
    public Pages pages;

    @Steps
    public EndUserSteps endUser;

    @Test
    public void searching_by_keyword_cat_should_display_article_about_cats() {
        endUser.is_on_the_wikipedia_home_page();
        endUser.searches_by_keyword("cats");
        endUser.should_see_article_with_title("Cat - Wikipedia, the free encyclopedia");

    }

    @Test
    public void searching_by_keyword_dog_should_display_article_about_dogs() {
        endUser.is_on_the_wikipedia_home_page();
		endUser.searches_by_keyword("dogs");
		endUser.should_see_article_with_title("Dog - Wikipedia, the free encyclopedia");
    }

    @Pending @Test
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
    }
} 