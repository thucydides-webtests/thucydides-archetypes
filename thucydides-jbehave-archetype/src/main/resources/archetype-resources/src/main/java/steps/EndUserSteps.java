#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

import ${package}.pages.DictionaryPage;

public class EndUserSteps extends ScenarioSteps {

    DictionaryPage dictionaryPage;

    public EndUserSteps(Pages pages) {
        super(pages);
        dictionaryPage = getPages().get(DictionaryPage.class);
    }

    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition_containing_words(String terms) {
        assertThat((List)dictionaryPage.getDefinitions(), hasItem(containsString(terms)));
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}
