# ShopSphere QA Test Plan

## 1. Overview
This test plan defines the QA scope, approach, and deliverables for the local WordPress + WooCommerce ShopSphere demo site.

## 2. Objectives
- Validate the current core ecommerce and account flows.
- Provide a baseline for automated smoke and regression testing.
- Track planned coverage separately from the current automated suite.

## 3. Current Test Scope
- Registration.
- Login and logout.
- Product details.
- Cart add, quantity update, and remove.
- Checkout and successful guest checkout.
- Checkout required-field validation.
- Invalid login.
- Admin login.
- 12 automated tests currently run in the suite.
- Latest result: 12 passed, 0 failed, 0 skipped.

## 4. Future/Planned Scope
- Product search.
- Filtering and sorting.
- Account updates.
- Admin product CRUD.
- Order management.
- Out-of-stock testing.

## 5. Out of Scope
- Payment gateways beyond Cash on Delivery.
- Real shipping integrations or tax services.
- Production hardening, PCI compliance, and external monitoring.

## 6. Test Environment
- Platform: LocalWP on macOS
- Application: local WordPress + WooCommerce ShopSphere demo site
- URL: http://shopspherelocal.local
- Currency: LKR
- Browser: Chrome
- Roles: Guest, Registered Customer, Admin
- Automation: Java 17, Maven, Selenium WebDriver, TestNG

## 7. Test Types
- Functional testing (automated).
- Regression testing (automation suite).
- Smoke testing.

## 8. Entry Criteria
- WordPress + WooCommerce installed and running.
- Products and categories available.
- Shipping and Cash on Delivery configured.

## 9. Exit Criteria
- All critical and high defects resolved or accepted.
- Smoke suite pass rate >= 95%.
- Automation suite runs without blocking errors and produces a result report.

## 10. Risks and Mitigations
- Local environment instability: keep site snapshot and backup.
- Plugin updates causing regressions: lock versions during testing.
- Data resets: maintain a test data seeding checklist.

## 11. Deliverables
- Test plan, scenarios, test cases, RTM, bug report template.
- Automation framework and execution reports.
