#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import ${package}.pages.HomePage;

public class EndUserSteps extends ScenarioSteps {

	public EndUserSteps(Pages pages) {
		super(pages);
	}

    @Step
    public void searches_by_keyword(String keyword) {
        enters(keyword);
        performs_search();
    }

	@Step
	public void enters(String keyword) {
        onHomePage().enter_keywords(keyword);
	}

    @Step
    public void performs_search() {
        onHomePage().starts_search();
    }

    private HomePage onHomePage() {
        return getPages().currentPageAt(HomePage.class);
    }

    @Step
	public void should_see_article_with_title(String title) {
        assertThat(onHomePage().getTitle(), is(title));
	}

    @Step
    public void is_on_the_wikipedia_home_page() {
        onHomePage().open();
    }
}
