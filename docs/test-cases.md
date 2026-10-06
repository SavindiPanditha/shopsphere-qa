# ShopSphere QA Test Cases

## Format
- Test Case ID, Title, Description, Preconditions, Test Steps, Expected Result, Test Data

## Functional Test Cases

### TC-001: Register New Customer
- Description: Verify that a new customer can register successfully.
- Preconditions: Site is running and the registration form is available.
- Test Steps: Open My Account; enter a unique email address and password; submit the registration form.
- Expected Result: The customer account is created and the account area is displayed.
- Test Data: A unique generated email address; password `Test@12345`.
- Status: Automated

### TC-002: Login With Valid Credentials
- Description: Verify that an existing customer can log in.
- Preconditions: Site is running and a customer account exists.
- Test Steps: Open My Account; enter the configured customer credentials; submit the login form.
- Expected Result: The customer account area and account greeting are displayed.
- Test Data: `SHOPSPHERE_TEST_USER` and `SHOPSPHERE_TEST_PASS`.
- Status: Automated

### TC-003: Logout Customer
- Description: Verify that a logged-in customer can log out.
- Preconditions: Site is running and a customer account exists.
- Test Steps: Log in with the configured customer credentials; select the logout option.
- Expected Result: The login or registration form is displayed after logout.
- Test Data: `SHOPSPHERE_TEST_USER` and `SHOPSPHERE_TEST_PASS`.
- Status: Automated

### TC-004: Login With Invalid Credentials
- Description: Verify that invalid customer credentials are rejected.
- Preconditions: Site is running and the login form is available.
- Test Steps: Open My Account; enter invalid credentials; submit the login form.
- Expected Result: An error message is displayed.
- Test Data: Username `invalid_user`; password `invalid_pass`.
- Status: Automated

### TC-005: View Product Details
- Description: Verify that product details can be opened from the shop page.
- Preconditions: Site is running and at least one product is available.
- Test Steps: Open the shop page; select the first available product.
- Expected Result: The product details page displays product information and a price.
- Status: Automated

### TC-006: Add Product to Cart
- Description: Verify that an available product can be added to the cart.
- Preconditions: Site is running and at least one product is available.
- Test Steps: Open the first available product; select the add-to-cart option; open the cart.
- Expected Result: The product is present in the cart.
- Status: Automated

### TC-007: Update Cart Quantity
- Description: Verify that the quantity of a cart product can be updated.
- Preconditions: A product is in the cart.
- Test Steps: Open the cart; change the product quantity to 2; submit or apply the quantity update.
- Expected Result: The cart product quantity is updated to 2.
- Test Data: Quantity `2`.
- Status: Automated

### TC-008: Remove Product From Cart
- Description: Verify that a product can be removed from the cart.
- Preconditions: A product is in the cart.
- Test Steps: Open the cart; remove the cart product.
- Expected Result: The product is removed and the empty-cart state is displayed.
- Status: Automated

### TC-009: Checkout Page Loads
- Description: Verify that the checkout page loads for a cart containing a product.
- Preconditions: A product is available and can be added to the cart.
- Test Steps: Add the first available product to the cart; open the checkout page.
- Expected Result: The checkout form and payment section are displayed, including Cash on Delivery.
- Status: Automated

### TC-010: Successful Guest Checkout
- Description: Verify that a guest can complete checkout with valid details.
- Preconditions: A product is in the cart and checkout is available.
- Test Steps: Open checkout; select Sri Lanka when the country field is available; enter valid guest details; select Cash on Delivery; place the order.
- Expected Result: An order confirmation is displayed with an order number.
- Test Data: `guest.checkout@example.com`; Guest Customer; `123 Test Street`; Colombo; `10100`.
- Status: Automated

### TC-011: Checkout Required-Field Validation
- Description: Verify that checkout prevents submission when required fields are empty.
- Preconditions: A product is in the cart and checkout is available.
- Test Steps: Open checkout; attempt to place the order without completing the required fields.
- Expected Result: Checkout validation errors are displayed.
- Status: Automated

### TC-012: Admin Login
- Description: Verify that an administrator can log in to WordPress.
- Preconditions: Site is running and administrator credentials are configured.
- Test Steps: Open the WordPress admin login page; enter the configured administrator credentials; submit the login form.
- Expected Result: The WordPress admin area is displayed.
- Test Data: `SHOPSPHERE_ADMIN_USER` and `SHOPSPHERE_ADMIN_PASS`.
- Status: Automated

## Planned Coverage
- Product search
- Filtering and sorting
- Account updates
- Admin product CRUD
- Order management
- Out-of-stock testing
- Status: Planned / Not Automated
