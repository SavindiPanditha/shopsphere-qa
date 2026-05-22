# ShopSphere QA Test Plan

## 1. Overview
This test plan defines the QA scope, approach, and deliverables for the ShopSphere WordPress + WooCommerce site used in automation portfolio work.

## 2. Objectives
- Validate core ecommerce user flows (browse, cart, checkout, order).
- Ensure account features work for guest and registered users.
- Verify admin product and catalog management.
- Provide a baseline for automation coverage and regression testing.

## 3. In Scope
- Core WooCommerce flows: shop, product, cart, checkout, order confirmation.
- Account management: register, login, logout, profile basics.
- Admin product management: create, update, delete product; category assignment.

## 4. Out of Scope
- Payment gateways beyond Cash on Delivery.
- Real shipping integrations or tax services.
- Production hardening, PCI compliance, and external monitoring.

## 5. Test Environment
- Platform: LocalWP on macOS
- URL: http://shopsphere.local
- Currency: LKR
- Browser targets: Chrome (primary), Safari (secondary)
- Roles: Guest, Registered Customer, Admin

## 6. Test Types
- Functional testing (manual + automated).
- Regression testing (automation suite).
- Smoke testing for each release branch.

## 7. Entry Criteria
- WordPress + WooCommerce installed and running.
- Products and categories available.
- Shipping and Cash on Delivery configured.

## 8. Exit Criteria
- All critical and high defects resolved or accepted.
- Smoke suite pass rate >= 95%.
- Automation suite runs without blocking errors.

## 9. Risks and Mitigations
- Local environment instability: keep site snapshot and backup.
- Plugin updates causing regressions: lock versions during testing.
- Data resets: maintain a test data seeding checklist.

## 10. Deliverables
- Test plan, scenarios, test cases, RTM, bug report template.
- Automation framework and execution reports (later steps).
