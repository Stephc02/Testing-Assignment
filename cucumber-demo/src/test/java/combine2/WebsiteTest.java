package combine2;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;




public class WebsiteTest {


    WebDriver driver;
    private ChromeOptions originalOptions;


    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ANNE CREMONA\\Downloads\\webtesting\\chromedriver.exe");
        driver = new ChromeDriver();

    }


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

 //CLOTHING CATEGORY


    @When("I visit the website clothing")
    public void iVisitWebsite1() throws Exception {

        setup();

        driver.get("https://www.missguided.co.uk/");


        // Accepting cookies (modify the selector as per your website's cookie consent element)
        try {
            WebElement acceptCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
            if (acceptCookiesButton.isDisplayed()) {
                acceptCookiesButton.click();
            }
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            // Handle exception if the element is not found or clickable
            System.out.println("Cookie acceptance button not found or not clickable.");
        }

    }

    @And("I click on the clothing category")
    public void iClickOnTheClothingCategory() {
        // Click on the specified category
        String categoryName = "Clothing";
        WebElement category = driver.findElement(By.linkText(categoryName));
        category.click();
    }

    @Then("I should be taken to the clothing category")
    public void iShouldBeTakenToTheClothingCategory() {

        // see if i need to do the expected category
        // Define a pattern or a part of the URL that uniquely identifies the Women Clothing category
        String categoryPattern = "/clothing"; // Adjust this pattern as per your URL structure

        // Get the current URL after the navigation
        String currentURL = driver.getCurrentUrl();

        // Perform the assertion to check if the current URL contains the category pattern
        assertTrue(currentURL.contains(categoryPattern));
    }

    @And("the clothing category should show at least {int} products")
    public void theClothingCategoryShouldShowAtLeastNumberOfProducts(int expectedNumOfProducts) {
        expectedNumOfProducts = 12;

        // Find the element containing the total number of products
        WebElement totalProductsElement = driver.findElement(By.cssSelector(".totalProducts"));

        // Get the text content of the element (which represents the total number of products)
        String totalProductsText = totalProductsElement.getText();

        // Convert the text content to an integer
        int actualProductCount = Integer.parseInt(totalProductsText);

        // Output the actual number of products
        System.out.println("The actual number of products is: " + actualProductCount);

        assertTrue(actualProductCount >= expectedNumOfProducts);
    }



    @When("I click on the first clothing product in the results")
    public void iClickOnFirstClothingProduct() {
        // Click on the first product in the displayed list
        WebElement firstProduct = driver.findElement(By.cssSelector("#navlist > li:first-of-type > div > div.productimage.s-productthumbimage > a.ProductImageList"));
        firstProduct.click();
    }


    @Then("I should be taken to the details page for that clothing")
    public void iShouldGoToClothingDetailsPage() {
        // Verify if the user is on the details page of the product
        WebElement productDetails = driver.findElement(By.id("productDetails"));
        assertTrue(productDetails.isDisplayed());
        tearDown();
    }

    // DRESSES CATEGORY

    @When("I visit the website dresses")
    public void iVisitWebsite2() throws Exception {

        setup();

        driver.get("https://www.missguided.co.uk/");


        // Accepting cookies (modify the selector as per your website's cookie consent element)
        try {
            WebElement acceptCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
            if (acceptCookiesButton.isDisplayed()) {
                acceptCookiesButton.click();
            }
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            // Handle exception if the element is not found or clickable
            System.out.println("Cookie acceptance button not found or not clickable.");
        }

    }

    @And("I click on the dresses category")
    public void iClickOnTheDressesCategory() {
        // Click on the specified category
        String categoryName = "Dresses";
        WebElement category = driver.findElement(By.linkText(categoryName));
        category.click();
    }

    @Then("I should be taken to the dresses category")
    public void iShouldBeTakenToTheDressesCategory() {

        // Define a pattern or a part of the URL that uniquely identifies the Women Clothing category
        String categoryPattern = "/dresses"; // Adjust this pattern as per your URL structure

        // Get the current URL after the navigation
        String currentURL = driver.getCurrentUrl();

        // Perform the assertion to check if the current URL contains the category pattern
        assertTrue(currentURL.contains(categoryPattern));
    }

    @And("the dresses category should show at least {int} products")
    public void theDressesCategoryShouldShowAtLeastNumberOfProducts(int expectedNumOfProducts) {
        expectedNumOfProducts = 12;

        // Find the element containing the total number of products
        WebElement totalProductsElement = driver.findElement(By.cssSelector(".totalProducts"));

        // Get the text content of the element (which represents the total number of products)
        String totalProductsText = totalProductsElement.getText();

        // Convert the text content to an integer
        int actualProductCount = Integer.parseInt(totalProductsText);

        // Output the actual number of products
        System.out.println("The actual number of products is: " + actualProductCount);

        assertTrue(actualProductCount >= expectedNumOfProducts);
    }



    @When("I click on the first dresses product in the results")
    public void iClickOnFirstDressesProduct() {
        // Click on the first product in the displayed list
        WebElement firstProduct = driver.findElement(By.cssSelector("#navlist > li:first-of-type > div > div.productimage.s-productthumbimage > a.ProductImageList"));
        firstProduct.click();
    }


    @Then("I should be taken to the details page for that dress")
    public void iShouldGoToDressesDetailsPage() {
        // Verify if the user is on the details page of the product
        WebElement productDetails = driver.findElement(By.id("productDetails"));
        assertTrue(productDetails.isDisplayed());
       tearDown();
    }

    // TOPS CATEGORY

   @When("I visit the website tops")
    public void iVisitWebsite3() throws Exception {

        setup();

        driver.get("https://www.missguided.co.uk/");


        // Accepting cookies (modify the selector as per your website's cookie consent element)
        try {
            WebElement acceptCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
            if (acceptCookiesButton.isDisplayed()) {
                acceptCookiesButton.click();
            }
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            // Handle exception if the element is not found or clickable
            System.out.println("Cookie acceptance button not found or not clickable.");
        }

    }

    @And("I click on the tops category")
    public void iClickOnTheTopsCategory() {
        // Click on the specified category
        String categoryName = "Tops";
        WebElement category = driver.findElement(By.linkText(categoryName));
        category.click();
    }

    @Then("I should be taken to the tops category")
    public void iShouldBeTakenToTheTopsCategory() {

        // Define a pattern or a part of the URL that uniquely identifies the Women Clothing category
        String categoryPattern = "/tops"; // Adjust this pattern as per your URL structure

        // Get the current URL after the navigation
        String currentURL = driver.getCurrentUrl();

        // Perform the assertion to check if the current URL contains the category pattern
        assertTrue(currentURL.contains(categoryPattern));
    }

    @And("the tops category should show at least {int} products")
    public void theTopsCategoryShouldShowAtLeastNumberOfProducts(int expectedNumOfProducts) {
        expectedNumOfProducts = 12;

        // Find the element containing the total number of products
        WebElement totalProductsElement = driver.findElement(By.cssSelector(".totalProducts"));

        // Get the text content of the element (which represents the total number of products)
        String totalProductsText = totalProductsElement.getText();

        // Convert the text content to an integer
        int actualProductCount = Integer.parseInt(totalProductsText);

        // Output the actual number of products
        System.out.println("The actual number of products is: " + actualProductCount);

        assertTrue(actualProductCount >= expectedNumOfProducts);
    }



    @When("I click on the first tops product in the results")
    public void iClickOnFirstTopsProduct() {
        // Click on the first product in the displayed list
        WebElement firstProduct = driver.findElement(By.cssSelector("#navlist > li:first-of-type > div > div.productimage.s-productthumbimage > a.ProductImageList"));
        firstProduct.click();
    }


    @Then("I should be taken to the details page for that top")
    public void iShouldGoToTopsDetailsPage() {
        // Verify if the user is on the details page of the product
        WebElement productDetails = driver.findElement(By.id("productDetails"));
        assertTrue(productDetails.isDisplayed());
        tearDown();
    }


    // TROUSERS CATEGORY

   @When("I visit the website trousers")
    public void iVisitWebsite4() throws Exception {

        setup();

        driver.get("https://www.missguided.co.uk/");


        // Accepting cookies (modify the selector as per your website's cookie consent element)
        try {
            WebElement acceptCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
            if (acceptCookiesButton.isDisplayed()) {
                acceptCookiesButton.click();
            }
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            // Handle exception if the element is not found or clickable
            System.out.println("Cookie acceptance button not found or not clickable.");
        }

    }

    @And("I click on the trousers category")
    public void iClickOnTheTrousersCategory() {
        // Click on the specified category
        String categoryName = "Trousers";
        WebElement category = driver.findElement(By.linkText(categoryName));
        category.click();
    }

    @Then("I should be taken to the trousers category")
    public void iShouldBeTakenToTheTrousersCategory() {

        String expectedCategory = "Trousers";
        // Define a pattern or a part of the URL that uniquely identifies the Women Clothing category
        String categoryPattern = "/trousers"; // Adjust this pattern as per your URL structure

        // Get the current URL after the navigation
        String currentURL = driver.getCurrentUrl();

        // Perform the assertion to check if the current URL contains the category pattern
        assertTrue(currentURL.contains(categoryPattern));
    }

    @And("the trousers category should show at least {int} products")
    public void theTrousersCategoryShouldShowAtLeastNumberOfProducts(int expectedNumOfProducts) {
        expectedNumOfProducts = 12;

        // Find the element containing the total number of products
        WebElement totalProductsElement = driver.findElement(By.cssSelector(".totalProducts"));

        // Get the text content of the element (which represents the total number of products)
        String totalProductsText = totalProductsElement.getText();

        // Convert the text content to an integer
        int actualProductCount = Integer.parseInt(totalProductsText);

        // Output the actual number of products
        System.out.println("The actual number of products is: " + actualProductCount);

        assertTrue(actualProductCount >= expectedNumOfProducts);
    }



    @When("I click on the first trousers product in the results")
    public void iClickOnFirstTrousersProduct() {
        // Click on the first product in the displayed list
        String categoryName = "Trousers";
        WebElement firstProduct = driver.findElement(By.cssSelector("#navlist > li:first-of-type > div > div.productimage.s-productthumbimage > a.ProductImageList"));
        firstProduct.click();
    }


    @Then("I should be taken to the details page for that trousers")
    public void iShouldGoToTrousersDetailsPage() {
        // Verify if the user is on the details page of the product
        WebElement productDetails = driver.findElement(By.id("productDetails"));
        assertTrue(productDetails.isDisplayed());
        //tearDown();
    }


    // SHOES CATEGORY

   @When("I visit the website shoes")
    public void iVisitWebsite5() throws Exception {

        setup();

        driver.get("https://www.missguided.co.uk/");


        // Accepting cookies (modify the selector as per your website's cookie consent element)
        try {
            WebElement acceptCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
            if (acceptCookiesButton.isDisplayed()) {
                acceptCookiesButton.click();
            }
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            // Handle exception if the element is not found or clickable
            System.out.println("Cookie acceptance button not found or not clickable.");
        }

    }

    @And("I click on the shoes category")
    public void iClickOnTheShoesCategory() {
        // Click on the specified category
        String categoryName = "Shoes";
        WebElement category = driver.findElement(By.linkText(categoryName));
        category.click();
    }

    @Then("I should be taken to the shoes category")
    public void iShouldBeTakenToTheShoesCategory() {

        // Define a pattern or a part of the URL that uniquely identifies the Women Clothing category
        String categoryPattern = "/shoes"; // Adjust this pattern as per your URL structure

        // Get the current URL after the navigation
        String currentURL = driver.getCurrentUrl();

        // Perform the assertion to check if the current URL contains the category pattern
        assertTrue(currentURL.contains(categoryPattern));
    }

    @And("the shoes category should show at least {int} products")
    public void theShoesCategoryShouldShowAtLeastNumberOfProducts(int expectedNumOfProducts) {
        expectedNumOfProducts = 1;

        // Find the element containing the total number of products
        WebElement totalProductsElement = driver.findElement(By.cssSelector(".totalProducts"));

        // Get the text content of the element (which represents the total number of products)
        String totalProductsText = totalProductsElement.getText();

        // Convert the text content to an integer
        int actualProductCount = Integer.parseInt(totalProductsText);

        // Output the actual number of products
        System.out.println("The actual number of products is: " + actualProductCount);

        assertTrue(actualProductCount >= expectedNumOfProducts);
    }



    @When("I click on the first shoes product in the results")
    public void iClickOnFirstShoesProduct() {
        // Click on the first product in the displayed list
        WebElement firstProduct = driver.findElement(By.cssSelector("#navlist > li:first-of-type > div > div.productimage.s-productthumbimage > a.ProductImageList"));
        firstProduct.click();
    }


    @Then("I should be taken to the details page for that shoes")
    public void iShouldGoToShoesDetailsPage() {
        // Verify if the user is on the details page of the product
        WebElement productDetails = driver.findElement(By.id("productDetails"));
        assertTrue(productDetails.isDisplayed());
        tearDown();
    }


    // THIS IS WHERE THE SEARCH STARTS
    @When("I search for a product using the term {string}")
    public void iSearchForProduct(String searchTerm) {
        setup();
        // Navigate to the website
        driver.get("https://www.missguided.co.uk/");

        try {
            WebElement acceptCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
            if (acceptCookiesButton.isDisplayed()) {
                acceptCookiesButton.click();
                WebElement searchBox = driver.findElement(By.id("txtSearch"));
                assertTrue(searchBox.isDisplayed());
                searchBox.sendKeys(searchTerm);
                searchBox.sendKeys(Keys.ENTER);
            }
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            // Handle exception if the element is not found or clickable
            System.out.println("Cookie acceptance button not found or not clickable.");
        }

    }

    @Then("I should see the search results")
    public void iShouldSeeSearchResults() {
        // Verify search results
        WebElement searchResults = driver.findElement(By.id("productlistcontainer"));
        assertTrue(searchResults.isDisplayed());
        //tearDown();
    }


    @Then("there should be at least {int} products in the search results")
    public void atLeastFiveProductsInResults(int expectedNumOfProducts) {
        expectedNumOfProducts = 12;


        // Find the element containing the total number of products
        WebElement totalProductsElement = driver.findElement(By.cssSelector(".totalProducts"));

        // Get the text content of the element (which represents the total number of products)
        String totalProductsText = totalProductsElement.getText();

        // Convert the text content to an integer
        int actualProductCount = Integer.parseInt(totalProductsText);

        // Output the actual number of products
        System.out.println("The actual number of products is: " + actualProductCount);

        assertTrue(actualProductCount >= expectedNumOfProducts);
    }

    @When("I click on the first one in the results")
    public void iClickOnFirstProductInResults() {
        // Click on the first product in the results
        WebElement firstProductInResults = driver.findElement(By.cssSelector("#navlist > li:first-of-type > div > div.productimage.s-productthumbimage > a.ProductImageList"));
        firstProductInResults.click();
    }


    @Then("I should go to the details page for that skirt")
    public void iShouldBeTakenToDetailsPage() {
        // Perform assertions for the details page
        WebElement productDetails = driver.findElement(By.id("productDetails"));
        assertTrue(productDetails.isDisplayed());


    }


}











