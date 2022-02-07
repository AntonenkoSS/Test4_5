Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check first article's name
    Given User opens '<homePage>' page
    And User opens news page
    When User checks first article visibility
    Then User checks that name first article

    Examples:
      | homePage             |
      | https://www.bbc.com  |


  Scenario Outline: Check list of name articles from news page
    Given User opens '<homePage>' page
    And User opens news page
    When User checks first article visibility
    Then User checks that names equals expected names

    Examples:
      | homePage             |
      | https://www.bbc.com  |



  Scenario Outline: Check article against the keyword from url
    Given User opens '<homePage>' page
    And User opens news page
    When User checks footer visibility
    And User click first article a
    And User close popup window
    And User take part current url
    And User come back to news page
    When User checks footer visibility
    And User enters in search field the keyword
    Then User checks the title of the first article against the keyword

    Examples:
      | homePage             |
      | https://www.bbc.com  |


  Scenario Outline: Check answer when user enters data
    Given User opens '<homePage>' page
    And User opens news page
    When User checks footer visibility
    And User opens corona tab
    And User opens corona story tab
    When User checks corona story tab visibility
    And User clicks 'Sign In' button on this tab
    And User checks footer visibility on this tab
    When User enters '<email>'
    And User enters '<password>' password
    And User click 'Sign In' button on modal
    Then User gets an answer and checks field contains needed '<answer>'

    Examples:
      | homePage             | email                  |  password    |   answer                               |
      | https://www.bbc.com  | ssantonenko@gmail.com  |  password    |   Sorry, that password isn't valid     |
      | https://www.bbc.com  | ssantonenko            |  password    |   Sorry                                |
      | https://www.bbc.com  | ssantonenko@gmail.com  |              |   Sorry                                |
