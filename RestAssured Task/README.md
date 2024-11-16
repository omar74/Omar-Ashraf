# Rest Assured API Automation Project

This project implements automated testing for RESTful APIs using the Rest Assured framework. It is designed to ensure the proper functionality and reliability of the API endpoints through structured test cases.

---

## Proposed Test Cases for REST API Automation

### 1. Get All Users
- **Description**: Retrieve all user data from the API.
- **Expected Result**:
   - Status code: `200`
   - A valid JSON response containing user details.

### 2. Create a New User
- **Description**: Submit a new user to the API.
- **Expected Result**:
   - Status code: `201`
   - The created user should be retrievable with correct details.

### 3. Check Created User
- **Description**: Retrieve the newly created user to verify the details.
- **Expected Result**:
   - Status code: `200`
   - The user details should match the input data provided during creation.

---

## Explanation of the Solution

### Test Framework
- The tests are implemented using the **Rest Assured framework**, which provides a straightforward and efficient way to test RESTful APIs in Java.

### Base URL
- The `BASE_URL` variable is configured to hold the API endpoint, ensuring flexibility and maintainability.

### HTTP Methods
- Each test case corresponds to a specific HTTP method (`GET`, `POST`, `PUT`, `DELETE`) for interacting with the API endpoints.

### Assertions
- Assertions are included in each test to:
   - Verify the **response status code**.
   - Ensure the **correctness of the returned data**.

### Parameterization
- The API key is passed as a parameter to authenticate requests. This is required for accessing the Best Buy API.

---

## Benefits of the Approach

This structured testing approach provides:
1. **Comprehensive Coverage**: Ensures all critical API functionalities are tested.
2. **Automation Efficiency**: Reduces manual effort while enhancing accuracy.
3. **Scalability**: Easy to extend with additional test cases as the API evolves.
4. **Reliability**: Continuous validation ensures the API behaves as expected under different scenarios.

---