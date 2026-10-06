# ShopSphere QA Test Scenarios

## Customer Account
| Scenario ID | Scenario | Description | Status |
| --- | --- | --- | --- |
| SC-001 | Customer registration | Register a new customer account. | Automated |
| SC-002 | Valid customer login | Log in with configured customer credentials. | Automated |
| SC-003 | Customer logout | Log out from an authenticated customer session. | Automated |
| SC-004 | Account updates | Update customer account or profile details. | Planned / Not Automated |

## Product Browsing
| Scenario ID | Scenario | Description | Status |
| --- | --- | --- | --- |
| SC-005 | View product details | Open the details page for an available product. | Automated |
| SC-006 | Product search | Search for products in the shop. | Planned / Not Automated |
| SC-007 | Filtering and sorting | Filter or sort products in the shop. | Planned / Not Automated |

## Shopping Cart
| Scenario ID | Scenario | Description | Status |
| --- | --- | --- | --- |
| SC-008 | Add product to cart | Add an available product to the cart. | Automated |
| SC-009 | Update cart quantity | Change the quantity of a product in the cart. | Automated |
| SC-010 | Remove product from cart | Remove a product and verify the empty-cart state. | Automated |

## Checkout
| Scenario ID | Scenario | Description | Status |
| --- | --- | --- | --- |
| SC-011 | Checkout page loads | Open checkout with a product in the cart. | Automated |
| SC-012 | Successful guest checkout | Complete checkout as a guest with valid details. | Automated |

## Negative Testing
| Scenario ID | Scenario | Description | Status |
| --- | --- | --- | --- |
| SC-013 | Invalid login | Attempt customer login with invalid credentials. | Automated |
| SC-014 | Checkout required-field validation | Attempt checkout without completing required fields. | Automated |
| SC-015 | Out-of-stock product behavior | Verify behavior when adding an out-of-stock product. | Planned / Not Automated |

## Admin
| Scenario ID | Scenario | Description | Status |
| --- | --- | --- | --- |
| SC-016 | Admin login | Log in to the WordPress admin area. | Automated |
| SC-017 | Admin product CRUD | Create, update, or delete products as an administrator. | Planned / Not Automated |
| SC-018 | Order management | Review and manage orders as an administrator. | Planned / Not Automated |
