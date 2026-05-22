# ShopSphere QA Test Scenarios

## A. Shop and Product Browsing
- View shop page and product grid.
- View product details page.
- Filter by category.
- Sort products by price and popularity.

## B. Cart
- Add product to cart from shop page.
- Update quantity in cart.
- Remove product from cart.
- Validate cart totals and shipping fee.

## C. Checkout
- Guest checkout with valid details.
- Registered user checkout.
- Required field validation.
- Cash on Delivery selected by default.

## D. Account Management
- Register new user.
- Login with valid credentials.
- Logout and session reset.
- Update account details (name, email).

## E. Admin Product Management
- Create new product (simple product).
- Edit product price and description.
- Assign categories.
- Delete product and verify removal from shop.

## F. Order Management (Admin)
- Place a test order and verify it appears in admin orders.
- Change order status (Processing to Completed).

## G. Negative Scenarios
- Checkout with missing required fields.
- Login with invalid credentials.
- Add out-of-stock product (if set).
