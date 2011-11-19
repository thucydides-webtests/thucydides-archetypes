package ${package}

import ${package}.steps.EndUserSteps
import ${package}.requirements.Application.Search.SearchByKeyword

using "thucydides"

thucydides.uses_default_base_url "http://www.google.co.nz"
thucydides.uses_steps_from EndUserSteps
thucydides.tests_story SearchByKeyword

scenario "Searching for bananas", {
    given "the user is on the home page", {
        end_user.is_the_home_page()
    }
    when "the end user searches for 'banana'", {
        end_user.looks_for "banana"
    }
    then "they should see the Wikipedia article on bananas", {
       end_user.should_see_definition_containing_words "An elongated curved fruit"
    }
}
