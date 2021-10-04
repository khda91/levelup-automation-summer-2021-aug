Feature: User Bug Red examples

  Scenario: User registration example
    Given I open User Bug Red Main page
    And I click 'Войти' button on the Main page
    When I fill 'Имя' field on the Main page
    And I fill 'Email' field on the Main page
    And I fill 'Password' field on the Main page
    And I click 'Зарегистрироваться' button on the Main page
    Then user name dropdown should be visible
    And user name should be equal entered user name
