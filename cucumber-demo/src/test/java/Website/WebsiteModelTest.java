package Website;

import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.GreedyTester;
import org.junit.Test;

import java.util.Random;



public class WebsiteModelTest implements FsmModel {
    // Define state variables
    private WebsiteState currentState;

    // Implement getState method
    public WebsiteState getState() {
        return currentState;
    }

    // Implement reset method
    public void reset(boolean var1) {
        // Reset state variables
        currentState = WebsiteState.NOT_LOGGED_IN;
    }

    // Implement transitions and guards
    public boolean loginGuard() {
        // Guard for login transition
        return currentState == WebsiteState.NOT_LOGGED_IN;
    }

    @Action
    public void login() {
        // Action for login transition
        currentState = WebsiteState.LOGGED_IN;
        // Update other state variables if needed
    }

    // Implement other transitions and guards similarly

    // Click on Category transition
    public boolean clickOnCategoryGuard() {
        return currentState == WebsiteState.NOT_LOGGED_IN;
    }

    @Action
    public void clickOnCategory() {
        currentState = WebsiteState.BROWSING_PRODUCTS;
        // Additional actions to interact with the website
    }

    // Write in Search transition
    public boolean writeInSearchGuard() {
        return currentState == WebsiteState.BROWSING_PRODUCTS;
    }

    @Action
    public void writeInSearch() {
        // Perform search action here
        // Assuming it transitions to a new state or remains in the same state after searching
        // currentState = newState;
        // Additional actions to interact with the website
    }

    // Click on Product transition
    public boolean clickOnProductGuard() {
        return currentState == WebsiteState.SEARCH;
    }

    @Action
    public void clickOnProduct() {
        currentState = WebsiteState.VIEWING_PRODUCT_DETAILS;
        // Additional actions to interact with the website
    }

    // Click on Add button transition
    public boolean clickOnAddButtonGuard() {
        return currentState == WebsiteState.VIEWING_PRODUCT_DETAILS;
    }

    @Action
    public void clickOnAddButton() {
        currentState = WebsiteState.ADDING_PRODUCT_TO_CART;
        // Additional actions to interact with the website
    }


    // Click on Remove button transition
    public boolean clickOnRemoveButtonGuard() {
        return currentState == WebsiteState.VIEW_CART;
    }

    @Action
    public void clickOnRemoveButton() {
        // Perform removal from cart action here
        // Assuming it transitions to a new state or remains in the same state after removal
        // currentState = newState;
        // Additional actions to interact with the website
    }


    // Checkout transition
    public boolean checkoutGuard() {
        return currentState == WebsiteState.VIEW_CART;
    }

    @Action
    public void checkout() {
        currentState = WebsiteState.CHECKING_OUT;
        // Additional actions to interact with the website
    }




    // Test runner
    @Test
    public void WebsiteModelRunner() {
        final GreedyTester tester = new GreedyTester(new WebsiteModelTest());
        tester.setRandom(new Random());
        tester.buildGraph();
        tester.addListener("verbose");
        // Add coverage metrics as needed
        tester.generate(500);
        tester.printCoverage();
    }
}

