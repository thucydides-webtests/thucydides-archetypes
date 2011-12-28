package ${package}

import ${package}.steps.EndUserSteps
import ${package}.requirements.Application.Search.SearchByKeyword

using "thucydides"

thucydides.uses_default_base_url "http://en.wiktionary.org/wiki/Wiktionary:Main_Page"
thucydides.uses_steps_from EndUserSteps
thucydides.tests_story SearchByKeyword

scenario "Searching for the definition of 'apple'", {
    given "the user is on the Wikionary home page", {
        end_user.is_the_home_page()
    }
    when "the end user looks up the definition of the word 'apple'", {
        end_user.looks_for "apple"
    }
    then "they should see the definition of 'apple", {
       end_user.should_see_definition_containing_words "A common, round fruit"
    }
}
