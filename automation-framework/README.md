# Automation Framework (ShopSphere)

Quick notes to run the tests and find artifacts.

Prerequisites
- Java 17
- Maven
- Chrome browser (Chromedriver is auto-managed)

Environment
- Create a `.env` file in this folder or set environment variables:
  - `SHOPSPHERE_BASE_URL` (e.g. http://shopsphere.local)
  - `SHOPSPHERE_ADMIN_USER` and `SHOPSPHERE_ADMIN_PASS`
  - `SHOPSPHERE_HEADLESS` (true|false)

Run tests
```bash
mvn -f pom.xml clean test
```

Reports and artifacts
- TestNG/Surefire HTML report: `target/surefire-reports/index.html`
- Failure screenshots (if any): `target/surefire-reports/screenshots/`

Notes
- Allure reporting was removed; failures save screenshots instead.
