# SauceDemo Automation Project

This project contains automated tests for the SauceDemo website using Selenium WebDriver, TestNG, and Allure Report.

## Prerequisites

- Java 17
- Maven

## How to Run Tests

By default, tests run in **Chrome** in **headed** mode.

### Run with Chrome
```bash
mvn clean test -Dbrowser=chrome
```

### Run with Firefox
```bash
mvn clean test -Dbrowser=firefox
```

### Run in Headless Mode
You can add `-Dheadless=true` to run tests without a browser UI (useful for CI).
```bash
mvn clean test -Dbrowser=chrome -Dheadless=true
```

## Allure Report

### Generate and Open Report Locally
1. Run the tests.
2. Generate the report:
```bash
mvn allure:report
```
3. Open the report:
```bash
mvn allure:serve
```

## Troubleshooting

### Firefox Binary Not Found
If you see an error like `Expected browser binary location, but unable to find binary in default location`, it means Firefox is not installed in the standard location on your system.
- **Solution**: Install Firefox or ensure it's in your Applications folder (macOS) or Program Files (Windows).
- **Note**: This error usually only happens locally. The **GitHub Actions** environment has both Chrome and Firefox pre-installed, so the CI pipeline will work correctly.

### Driver Issues
The project uses `WebDriverManager` to handle driver binaries automatically. If you encounter issues, try clearing the cache:
```bash
mvn dependency:purge-local-repository
```
