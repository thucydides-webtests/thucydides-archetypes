#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.steps;

import ${package}.pages.SearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;

public class EndUserSteps extends ScenarioSteps {

	public EndUserSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void enters(String keyword) {
        onSearchPage().enter_keywords(keyword);
	}

    @Step
    public void starts_search() {
        onSearchPage().starts_search();
    }

    private SearchPage onSearchPage() {
        return getPages().currentPageAt(SearchPage.class);
    }

    private SearchPage searchPage() {
        return getPages().currentPageAt(SearchPage.class);
    }

    @Step
	public void should_see_definition_containing_words(String terms) {
        assertThat(searchPage().getDefinitions(), hasItem(containsString(terms)));
	}

    @Step
         public void is_the_home_page() {
        onSearchPage().open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}
