package ${package}

import ${package}.steps.EndUserSteps
import ${package}.requirements.Application.Search.SearchByKeyword

using "thucydides"

thucydides.uses_default_base_url "http://www.google.com"
thucydides.uses_steps_from EndUserSteps
thucydides.tests_story SearchByKeyword

scenario "Searching for cats", {
    given "the user is on the home page", {
        end_user.is_the_google_home_page()
    }
    when "the end user searches for 'bethany'", {
        end_user.looks_for "bethany"
    }
    then "they should see the corresponding article", {
       end_user.should_see_article_with_title_containing "Bethany - Wikipedia, the free encyclopedia"
    }
}
