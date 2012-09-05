
Scenario: Looking up the definition of 'apple'
Given the user is on the Wikionary home page
When the user looks up the definition of the word 'apple'
Then they should see a definition containing the words 'A common, round fruit'

Scenario: Looking up the definition of 'banana'
Given the user is on the Wikionary home page
When the user looks up the definition of the word 'banana'
Then they should see a definition containing the words 'An elongated curved fruit'
