# ShopSphere QA Test Cases

## Format
- ID, Title, Preconditions, Steps, Expected Result

## Functional Test Cases

### TC-001: Open Shop Page
- Preconditions: Site running
- Steps: Navigate to /shop
- Expected: Product grid loads and products are visible.

### TC-002: View Product Details
- Preconditions: Products exist
- Steps: Click a product from shop page
- Expected: Product detail page displays name, price, add to cart.

### TC-003: Add to Cart
- Preconditions: Product in stock
- Steps: Click Add to cart on a product
- Expected: Cart count increases; product listed in cart.

### TC-004: Update Cart Quantity
- Preconditions: Product in cart
- Steps: Increase quantity; update cart
- Expected: Totals update correctly.

### TC-005: Remove from Cart
- Preconditions: Product in cart
- Steps: Remove product
- Expected: Cart empty message shown.

### TC-006: Guest Checkout
- Preconditions: Product in cart
- Steps: Proceed to checkout; fill required fields; place order
- Expected: Order confirmation page displays.

### TC-007: Required Field Validation
- Preconditions: On checkout
- Steps: Leave required fields empty; attempt place order
- Expected: Field validation errors appear.

### TC-008: Register New User
- Preconditions: None
- Steps: Go to My Account; register with email and password
- Expected: User created and logged in.

### TC-009: Login Valid User
- Preconditions: User exists
- Steps: Login from My Account
- Expected: Account dashboard visible.

### TC-010: Admin Create Product
- Preconditions: Admin access
- Steps: Products -> Add New; create product
- Expected: Product appears in shop.

### TC-011: Admin Update Product
- Preconditions: Product exists
- Steps: Edit product price; save
- Expected: New price appears on product page.

### TC-012: Admin Delete Product
- Preconditions: Product exists
- Steps: Delete product
- Expected: Product removed from shop.
