# Kindred QA Automation Basic Project

## Overview

This project was developed as part of my QA Automation interview for Kindred.
Its purpose is to create a basic automation framework for testing API functionalities.

## Technologies

- Programming Language: Java 23
- Test Automation Framework: TestNG
- API Testing Framework: RestAssured
- Build Tool: Maven
- IDE: IntelliJ IDEA
- Version Control: Git

## Setup

1. Install JDK 23 and set up `JAVA_HOME`.
2. Install GIT.
3. Install IntelliJ IDEA.
4. Clone this repository: `git clone https://github.com/rodicad/kindred-api-exam.git`.
5. Navigate to the project directory and run: `mvn clean install`.

## Running Tests

Execute the tests with:

```bash
mvn test
```

## Test Scenarios
### Api tests
- Test API response and data validation for sport and matches scenarions
- Ensure correct handling of API requests

## Improvements and Future Work
The project is still in its early stages and there are several areas for improvement:
- Add more test scenarios
- Improve error handling and data validation
- Add more API endpoints to test

## Questions and Assumptions
- When the "Jurisdiction" field is missing from header, requesting the sport list will return an 400 error - I assumed this was expected behavior.
- When the "Jurisdiction" field is missing from header, requesting the contests for a specific sport and league will return an 404 status code - I assumed this was expected behavior, but why not 400?.

# Author
[Rodica Dan](https://github.com/rodicad)
