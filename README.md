# ShopSphere QA (mono-repo)

This repository contains QA artifacts and an automation framework for the ShopSphere WordPress + WooCommerce demo site.

This repository contains QA artifacts and an automation framework for the ShopSphere WordPress + WooCommerce demo site.

Repository layout
- `automation-framework/` — Selenium + TestNG automation code and tests
- `docs/` — test plan, test cases, scenarios, RTM and bug template

Overview
- Purpose: automated verification of core e-commerce flows (browse, cart, checkout, account, admin product management) and a smoke/regression suite.

Tech stack
- Java 17, Maven
- Selenium 4 (selenium-java)
- TestNG
- WebDriverManager (auto-manages Chromedriver)
- dotenv-java for environment configuration

Test coverage
- Smoke + functional tests implemented in `automation-framework/src/test/java/com/shopsphere/qa/tests/`:
	- `LoginTests`, `ProductTests`, `CartTests`, `CheckoutTests`, `NegativeTests`, `AdminLoginTests`
- Scenarios derived from `docs/test-cases.md` and `docs/test-scenarios.md` (see those files for the canonical list).
- Current automation focuses on core happy paths and several negative checks; additional test cases in `docs/` are planned for automation.

Configuration
- `automation-framework/src/main/java/com/shopsphere/qa/utils/Config.java` reads environment variables or `.env` values:
	- `SHOPSPHERE_BASE_URL` (default: http://shopspherelocal.local)
	- `SHOPSPHERE_ADMIN_USER`, `SHOPSPHERE_ADMIN_PASS`
	- `SHOPSPHERE_HEADLESS` (true|false)

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

