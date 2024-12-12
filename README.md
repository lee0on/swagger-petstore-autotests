# Petstore API Automated Tests

This project contains a set of automated tests for the [Swagger Petstore API](https://petstore.swagger.io/). The tests are designed to verify the functionality of various API endpoints, covering positive and negative scenarios.

## Features

1. **Status Code Validation**

   - Verified the status codes for all available API requests.

2. **Header Validation**

   - Implemented validation of response headers for one specific request.

3. **Response Body Validation**

   - Checked the response body of two API requests to ensure correctness of returned data.

4. **Cucumber Integration**

   - Created a Gherkin scenario and implemented corresponding step definitions to test the scenario using the Cucumber framework.

5. **WireMock Testing**

   - Developed a test using the WireMock library to simulate API behavior. (Note: This test was created for learning purposes and is not directly relevant to the tested API due to the lack of internal interactions within the API.)

6. **Negative Scenarios**

   - Included tests for negative scenarios, such as invalid input data and unauthorized requests.

## Tools and Frameworks Used

- **JUnit**: Used as the testing framework.
- **Cucumber**: For Behavior-Driven Development (BDD) testing.
- **Rest-Assured**: For sending HTTP requests and validating API responses.
- **WireMock**: For mocking API responses.
- **Jackson**: For serializing and deserializing JSON payloads.
- **Git**: For version control.

## Project Structure

```
petstore-autotests
├── src
│   ├── main
│   │   └── java
│   │       └── org.example
│   │           ├── checks
│   │           ├── payloads
│   │           ├── requests
│   │           ├── OrderCreationStepDefs.java
│   │           └── RunnerTest.java
│   └── test
│       ├── java
│       │   └── Mocking
│       └── resources
│           └── OrderCreation.feature
└── pom.xml
```

## How to Run the Tests

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/swagger-petstore-autotests.git
   cd swagger-petstore-autotests
   ```

2. Build the project:

   ```bash
   mvn clean install
   ```

3. Run all tests:

   ```bash
   mvn test
   ```

4. Run Cucumber tests:

   ```bash
   mvn test -Dcucumber.features=src/test/resources
   ```

## Future Improvements

- Add more comprehensive validations for headers and response bodies.
- Expand negative scenario coverage.
- Integrate test reporting tools like Allure.
- Implement performance tests for API endpoints.

## License

This project is open-source and available under the [MIT License](LICENSE).

