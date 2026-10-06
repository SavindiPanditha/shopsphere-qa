# ShopSphere QA

This repository contains QA artifacts and an automation framework for the ShopSphere WordPress + WooCommerce demo site.

Repository layout
- `automation-framework/` — Selenium + TestNG automation code and tests
- `docs/` — test plan, test cases, scenarios, RTM and bug template

Overview
- Purpose: QA automation for a local WordPress + WooCommerce ShopSphere demo site.

Tech stack
- Java 17, Maven
- Selenium 4 (selenium-java)
- TestNG
- WebDriverManager (auto-manages Chromedriver)
- dotenv-java for environment configuration

Test coverage
- 12 automated smoke and functional tests are implemented in `automation-framework/src/test/java/com/shopsphere/qa/tests/`:
	- `LoginTests`: login, logout, registration
	- `ProductTests`: view product details
	- `CartTests`: add, update quantity, remove
	- `CheckoutTests`: checkout page, successful guest checkout
	- `NegativeTests`: invalid login, checkout required-field validation
	- `AdminLoginTests`: admin login
- Checkout validation is covered by the negative test suite.

Latest full-suite result
- 12 passed
- 0 failed
- 0 skipped
- Command: `mvn clean test`

Configuration
- `automation-framework/src/main/java/com/shopsphere/qa/utils/Config.java` reads environment variables or `.env` values:
	- `SHOPSPHERE_BASE_URL` (default: http://shopspherelocal.local)
	- `SHOPSPHERE_ADMIN_USER`, `SHOPSPHERE_ADMIN_PASS`
	- `SHOPSPHERE_TEST_USER`, `SHOPSPHERE_TEST_PASS`
	- `SHOPSPHERE_HEADLESS` (true|false)
- `.env` contains local credentials and must not be committed.

Run tests
1. Ensure the WordPress + WooCommerce site is running at `SHOPSPHERE_BASE_URL`.
2. From the repo root:
```bash
cd automation-framework
mvn clean test
```

Artifacts & reporting
- Surefire/TestNG HTML report: `automation-framework/target/surefire-reports/index.html`
- Failure screenshots (if any): `automation-framework/target/surefire-reports/screenshots/`

Notes
- Allure integration was removed; the suite now writes failure screenshots instead.
- For CI, run the Maven command on the CI agent and archive `target/surefire-reports`.

Future Scope
- Product search
- Filtering and sorting
- Account updates
- Admin product CRUD
- Order management
- Out-of-stock testing

