Feature: Product Categories Reachability

  Scenario: Reachability of Clothing category
    When I visit the website clothing
    And I click on the clothing category
    Then I should be taken to the clothing category
    And the clothing category should show at least 10 products
    When I click on the first clothing product in the results
    Then I should be taken to the details page for that clothing

  Scenario: Reachability of Dresses category
    When I visit the website dresses
    And I click on the dresses category
    Then I should be taken to the dresses category
    And the dresses category should show at least 10 products
    When I click on the first dresses product in the results
    Then I should be taken to the details page for that dress

  Scenario: Reachability of Tops category
    When I visit the website tops
    And I click on the tops category
    Then I should be taken to the tops category
    And the tops category should show at least 10 products
    When I click on the first tops product in the results
    Then I should be taken to the details page for that top

  Scenario: Reachability of Trousers category
    When I visit the website trousers
    And I click on the trousers category
    Then I should be taken to the trousers category
    And the trousers category should show at least 10 products
    When I click on the first trousers product in the results
    Then I should be taken to the details page for that trousers

  Scenario: Reachability of Shoes category
    When I visit the website shoes
    And I click on the shoes category
    Then I should be taken to the shoes category
    And the shoes category should show at least 10 products
    When I click on the first shoes product in the results
    Then I should be taken to the details page for that shoes

  Scenario: Search functionality
    When I search for a product using the term "skirts"
    Then I should see the search results
    And there should be at least 5 products in the search results
    When I click on the first one in the results
    Then I should go to the details page for that skirt
    Then I should click on add button to cart for that skirt
    Then the cart items should display
    Then I should click on remove from cart for that skirt
    Then I should click on checkout for that skirt
