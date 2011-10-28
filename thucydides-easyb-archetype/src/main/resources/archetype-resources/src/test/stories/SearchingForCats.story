#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import ${package}.steps.EndUserSteps
import ${package}.requirements.Application.Search.SearchBySingleKeyword

using "thucydides"

thucydides.uses_default_base_url "http://www.wikipedia.com"
thucydides.uses_steps_from EndUserSteps
thucydides.tests_story SearchBySingleKeyword

scenario "Searching for cats", {
    given "the user is on the home page", {
        end_user.is_on_the_wikipedia_home_page()
    }
    when "the end user searches for 'cats'", {
        end_user.searches_by_keyword('cats')
    }
    then "they should see the corresponding article", {
       end_user.should_see_article_with_title("Cat - Wikipedia, the free encyclopedia")
    }
}
