package ${package}

import ${package}.steps.EndUserSteps
import ${package}.requirements.Application.Search.SearchByKeyword

using "thucydides"

thucydides.uses_default_base_url "http://www.google.com"
thucydides.uses_steps_from EndUserSteps
thucydides.tests_story SearchByKeyword

scenario "Searching for bananas", {
    given "the user is on the google home page", {
        end_user.is_the_google_home_page()
    }
    when "the end user searches for 'bananas'", {
        end_user.looks_for "bananas"
    }
    then "they should see the Wikipedia article on bananas", {
       end_user.should_see_article_with_title_containing "Banana - Wikipedia, the free encyclopedia"
    }
}
