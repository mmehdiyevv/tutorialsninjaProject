# 📝 Selenium-Cucumber-Demo-Framework Documentation

---

| Tool     | Intention                            | Version  |                         Docs                          |
|:---------|:-------------------------------------|:--------:|:-----------------------------------------------------:|
| Java     | Programming Language                 | JDK - 20 |  [JDK20](https://docs.oracle.com/en/java/javase/20/)  |
| Maven    | Build Tool and Dependency Management |  3.9.5   | [Maven 3](https://maven.apache.org/guides/index.html) |
| Selenium | UI Test Automation                   |  4.15.0  | [Selenium 4](https://www.selenium.dev/documentation/) |
| TestNG   | Test Framework                       |  7.10.2  |             [TestNG](https://testng.org)              |
| JUnit    | Test Framework                       |  4.13.2  |         [JUnit 4](https://junit.org/junit4/)          |
| Cucumber | BDD Framework                        |  7.15.0  |   [Cucumber 7](https://cucumber.io/docs/cucumber/)    |

---

## 🛠 Framework Creation

1. **Create a new project with:**
    - Java as programming language 🌐
    - Maven as build tool 🛠
    - Git for source version control 🔄

2. **Add necessary dependencies** 📦
    - Selenium, JUnit 4 (testNG), Cucumber - Java, Cucumber - JUnit (Cucumber - testNG)

3. **Create folder structure** 📁
    - Pages, Step_definitions, Utilities, Runner, Resources.features
    - ```text
         test
         ├── java
         │   ├── pages
         │   ├── runner
         │   ├── step_definitions
         │   └── utilities
         └── resources
            └── features
      ```

4. **Start by creating your first Cucumber file** 🥒
    - feature-name.feature
    - make sure the file extension is `.feature`

5. **Add necessary plugins** 🔄
    - Cucumber for Java
    - Ensure Gherkin is installed

6. **Running your first feature:** 🏃
    - I. Create a StepDefinition class containing Java methods that define each step from the feature file
      ```java
      package step_definitions;
      public class LoginSteps(){
          // Example of a Step Definition in Java
          @Given("user is on the login page")
          public void userIsOnLoginPage() {
             // code to navigate to login page
          }
      }
      ```
    - II. Create a TestRunner class connecting feature file steps with Java methods from step definitions
        - TestRunner uses JUnit 4 annotation @RunWith() to run tests with Cucumber.class type
            - Customize binding and framework execution with @CucumberOptions():
                - `feature = "path/to/features"`: provides the path to features of the framework
                - `glue = "step definitions location"`: connects the step definitions with feature files steps
                - `dryRun = true/false` options:
                    - If set to true, it checks if all steps in the feature file are defined but doesn't run test cases
                    - If set to false, it runs the test cases and throws an error if steps aren't defined
                - `monochrome = true` : makes the console logs more readable
                - `plugin = {"pretty", "html:target/reports/cucumber-reports.html"}`
                - `tags = "@smoke"`
                  ```java
                  @RunWith(Cucumber.class)
                  @CucumberOptions(
                      features = "src/test/resources/features",
                      glue = "step_definitions",
                      monochrome = true,
                      dryRun = false,
                      tags = ("@runValid and @smoke"),
                      plugin = {"pretty", "html:target/reports/cucumber-reports.html"}
                  )
                  public class TestRunner {
                  // no need to add code here
                  }
                  ```
7. **Cucumber Keywords definitions in feature files** 🗝️
    - **`Feature`:** _Short description of the feature to be tested_
        - Examples:
          ```gherkin
          #Example 1: 
          Feature: User Login Functionality
          #Example 2:
          Feature: Reset Password Functionality
          ```  
    - **`Background`** _Will run the steps of background before each Scenario_
        - Examples:
          ```gherkin
          #Example 1:
          Background: Preliminary Steps
             Given user navigates to hrm login page
           ```
    - **`Scenario`:** _Brief use case description from a user perspective_
        - Examples:
            ```gherkin
          #Example 1: 
          Scenario: Login with valid credentials
          #Example 2:
          Scenario: Login with invalid credentials
          ```
    - **Given, When, Then, And, But, \* Keywords:**
        - **`Given`** - _Preconditions or starting points_
            - Examples:
              ```gherkin
              #Example 1:
              Given user navigates to login page
              #Example 2:
              Given admin user lands on the home page
              ```
        - **`When`** - _Main actions performed_
            - Examples:
              ```gherkin
              #Example 1:
              When user enters username and password
              #Example 2:
              When user clicks on admin tab
              ```
        - **`Then`** - _Outcome or result of actions, usually at this step you need to perform an assertion_
            - Examples:
              ```gherkin
              #Example 1:
              Then user is redirected to the homepage
              #Example 2:
              Then user can see an error message
              ```
        - **`And`** - _Connects multiple steps within Given, When, or Then_
            - _Used to add more detail or steps without repeating the Given, When, or Then keywords_
            - Examples:
              ```gherkin
              #Example: notice how And keyword connects any steps on Given, When, Then
              Scenario: Login with valid credentials
                Given user is on the login page
                And user has a valid account
                When user enters their username
                And user enters their password
                And user clicks on the login button
                Then user is redirected to the dashboard
                And user receives a welcome message
              ```
        - **`But`** - _Describes an exception or a contrasting scenario_
            - Example:
              ```gherkin
              #Example: notice how But keyword provides a logical output when the credentials 
              # are about to expire you still can login but a message will be shown
              Scenario: Login with expiring credentials
                Given user is on the login page
                And user has a valid account
                When user enters their username
                And user enters their password
                And user clicks on the login button
                Then user is redirected to the dashboard
                But user can see a warning message to change credentials
              ```
        - **`*`** - _Asterisks:_
            - _The asterisk * is a more generic step keyword that can be used in place of any of the other keywords (
              Given, When, Then, And, But)._
            - _It is often used when the specific type of step (setup, action, or assertion) is either clear from
              context
              or not important to the clarity of the scenario._
            - _The use of * doesn't imply a technical or undefined behavior; it's more about flexibility in writing
              the scenario._
              ```gherkin
                  # Example using steps with keywords:
                      Given I am logged in
                      And I have items in my cart
                      When I go to the checkout page
                      Then I should see the total price
                  # Example using steps with asteriks:
                      * I am logged in
                      * I have items in my cart
                      * I go to the checkout page
                      * I should see the total price
              ```

8. > ### More information about Gherkin syntax can be found here:
   > [Cucumber - Gherkin Syntax](https://cucumber.io/docs/gherkin/reference/)

---

## Framework Definition

    In the IT world, the term "framework" is used extensively and refers to a set of pre-written code, tools, and guidelines that aid in software development. To put it in a simpler context:

    ### Analogy: Furnishing with an IKEA Bookshelf

    Imagine you want to furnish your home with a new bookshelf. You have two main options:

- **DIY Approach**: Design and build the bookshelf from scratch. This involves selecting the wood, cutting it to size, sanding, joining, and painting. It requires significant skill, time, and effort.
- **IKEA Approach**: Buy a bookshelf from IKEA, which comes as a flat-pack with all the pieces pre-cut, holes pre-drilled, and includes the necessary tools and instructions for assembly.

    ### Correlation with IT Frameworks

- **Pre-Made Components**:
    - **IKEA**: Comes with pre-cut pieces.
    - **IT Framework**: Provides pre-written code and components, saving time and effort.

- **Instructions and Guidelines**:
    - **IKEA**: Assembly instructions guide the process.
    - **IT Framework**: Offers guidelines and conventions for structuring code and building applications.

- **Customization**:
    - **IKEA**: Allows some customization (e.g., placement, additional decorations).
    - **IT Framework**: While using pre-built components, customization in functionality and design is possible.

- **Consistency and Quality**:
    - **IKEA**: Known for consistent quality and design.
    - **IT Framework**: Ensures a level of consistency and reliability, incorporating best coding practices.

- **Community and Support**:
    - **IKEA**: Online forums and videos for assistance.
    - **IT Framework**: Supported by large communities, offering additional tools and resources.

---

### Meetings for Defining Acceptance Criteria

#### 1. Sprint Planning Meeting (Agile Framework)

- **Participants**: Product Owner, Development Team, Scrum Master (in Scrum).
- **Purpose**: To plan the work for the upcoming sprint. This is where user stories are discussed, and acceptance criteria are defined to ensure everyone has a clear understanding of what needs to be done.

#### 2. Three Amigos Meeting
- 
- **Participants**: A representative from Business (usually Product Owner), Development, and Testing.
- **Purpose**: This is a more informal, yet focused discussion where these three perspectives converge to define what a user story means, how it will function, and how it will be tested.

#### 3. Grooming/Backlog Refinement Sessions

- **Participants**: Product Owner, Development Team, and often the Scrum Master.
- **Purpose**: To refine and estimate backlog items, including user stories. Acceptance criteria are refined here to ensure they are clear and testable.

---

### ATDD vs BDD

#### ATDD (Acceptance Test Driven Development)

- **Approach**: Focuses on defining a user story with acceptance tests (AT), ensuring everyone involved clearly understands the requirements. Developers and Testers then work in parallel to fulfill these criteria.

#### BDD (Behavior Driven Development)

- **Approach**: BDD extends ATDD by emphasizing user behaviors and expected outcomes. It involves writing acceptance tests in a language that describes the behavior of the software from the end-user's perspective.

#### Examples

#### ATDD Approach Example

_User Story_: "As a user, I want to reset my password so that I can access my account if I forget it."

_Acceptance Criteria_:
- Users can initiate a password reset from the login page.
- A reset link is sent to the user’s registered email, expiring after 24 hours.
- Users can set a new password using the reset link.

#### BDD Approach Example

_User Story_: "As a user, I want to reset my password to access my account if I forget it."

_Acceptance Criteria_:

```gherkin
    Scenario: Requesting a password reset
        Given I am on the login page
        When I click on "Forgot Password"
        Then I should enter my registered email

    Scenario: Receiving a password reset email
        Given I requested a password reset
        When I submit my email
        Then I should receive a reset email within 5 minutes

    Scenario: Resetting password using the link
        Given I received a reset email
        When I use the link to set a new password
        Then my password should update and I’m redirected to login
```
---

## Cucumber Parametrization
>Parameterization in Cucumber is a technique used to create data-driven tests, which allows you to run the same test with different sets of data.
It increases the reusability and flexibility of your tests.
Here, in given examples we can see the use of different data types like String, Integer, Boolean, and Double.

The idea is that we can pass data directly from the step to methods in step definitions

**String parameters**  
_Feature file:_
```gherkin
    Feature: Login functionality

    Scenario: Logging in with different usernames
        Given I am on the login page
        When I enter "my_username" and "password123"
        Then I should be logged in
```
_Step definition:_
```java
    @When("I enter {string} and {string}")
    public void i_enter_username_and_password(String username, String password) {
    // Code to enter username and password
    }
```

**Integer parameters**  
_Feature file:_
```gherkin
Feature: Product quantity selection

  Scenario Outline: Selecting different product quantities
    Given I have selected a product
    When I choose a quantity of 25
    Then the total should be updated accordingly
```
_Step definition:_
```java
@When("I choose a quantity of {int}")
public void i_choose_a_quantity_of(int quantity) {
    // Code to select the quantity
}
```

**Double parameters**  
_Feature file:_
```gherkin
Feature: Payment processing

  Scenario Outline: Processing payments of different amounts
    Given I am making a payment
    When I enter the amount 55.99
    Then the payment should be processed
```
_Step definition:_
```java
@When("I enter the amount {double}")
public void i_enter_the_amount(double amount) {
    // Code to enter the payment amount
}
```

---

## Scenario Outline same as Scenario Template
> Scenario Outline in Cucumber is a key feature for data-driven testing.
> It allows you to run the same test scenario multiple times with different sets of input values.
> This is extremely useful in cases where you need to test the same functionality under various conditions.

Syntax:
```gherkin
Scenario Outline: Generic name for scenario
    Given some step "<placeholder1>"
    When some step "<placeholder2>"
Examples:
|placeholder1|placeholder2|
|data1       |data2       |
|value1      |value2      |
```
Here we can see that the steps have a placeholder wrapped in <> angle brackets.
Angle brackets makes cucumber look for that placeholder in the Examples table column name
Once found it will pick data from that column.
Make sure that table column name matches with placeholder in steps. Otherwise, it won't pick the data from there.

**_The Scenario Outlines are good candidate for:_**
- Scenarios that are similar in steps and only data changes
- Where each scenario is a new user web app usage
    - For example one user can use both username and password as invalid creds
    - Others can use differen tabs empty etc..
    - Here each of these represents a new user launch to the app.
- We use outlines for:
    - Login, Forms with error message fields, search bars...

**_We can also have more than one Example tables per each Scenario Outline/Template_**
[See example]("https://github.com/dmytro-ch21/Selenium-Cucumber-Demo-Framework/blob/master/src/test/resources/features/user-search.feature")

---

### Data Tables - In cucumber we can pass a larger set of data at once for a step in scenario
That sets of data can be in different forms - List, Map, List<List>, List<Maps>

Examples:
- #### Data Table as a List
```gherkin
  @listDataTable
  Example: Data table as a List
    Given this is a data table as a list
      | Omar  |
      | John  |
      | Merry |
      | Jane  |
```
```java
    @Given("this is a data table as a list")
    public void this_is_a_data_table_as_a_list(List<String> names) {
      // code
    }
```
- #### Data Table as a Map
```gherkin
  @mapDataTable
  Example: Data Table as a Map
     Given this is a data table as a map
       | first_name  | Omar |
       | middle_name | Mark |
       | last_name   | Ramo |
```
```java
    @Given("this is a data table as a map")
    public void this_is_a_data_table_as_a_map(Map<String, String> person){
      // code  
    }
```
- #### Data Table as a List<List<String>>
```gherkin
  @listOfListsDataTable
  Example: Data Table as a List of Lists
    Given this is a data table as a List of Lists
      | 12313 | Omar Mark          | Ramo      |
      | 13684 | Jonathan Pete Moss | Abernathy |
      | 13724 | test2 nn           | Anotation |
```
```java
    @Given("this is a data table as a List of Lists")
    public void this_is_a_data_table_as_a_list_of_lists(List<List<String>> employees){
      // code  
    }
```

- #### Data Table as a List<Map<String, String>>
> Sometimes we need to pass our table with headers and in such cases use List of Maps where the header will be the key an column values as value to the key.
```gherkin
@listOfMapsDataTable
Example: Data Table as a List of Maps
   Given this is a data table as a List of Maps
   | id    | first_mid_name     | last_name |
   | 12313 | Omar Mark          | Ramo      |
   | 13684 | Jonathan Pete Moss | Abernathy |
   | 13724 | test2 nn           | Anotation |
```
```java
    @Given("this is a data table as a List of Maps")
    public void this_is_a_data_table_as_a_list_of_lists(List<Map<String,String>> employees){
      // code  
    }
```

## Current Issue of framework - Random Driver Instances Created
> Solution - Singleton Design Pattern

Singleton:
There are 3 base rules to create a Singleton Class
1. Private Constructor - to avoid instantiation of this class
2. Private Static Member(Property) - contains the instance of the Driver
3. Static Public Method - will act as a global access point (getter)

Optional:
4. Static Set Up Method - To intialize the browser to a very specific type (setter)
5. Static Clean Up Method - will basically quit the driver

## Reading from properties file

1. The first step we create a file with extension of .properties
    - This file will contain such things as: urls, credentials, environment configs etc..
2. In order to convert/use this information in our code/scripts
3. We need to create an object of Properties class
    - Once we create the object of properties it will be empty with no information
4. To get the information from the file we will use FileInputStream
    - We create an object of FileInputStream
    - Then we pass to the constructor the path to the file itself (we usually start from source folder src/)
    - Once the information if read , it is stored in the FileInputStream object as 0s and 1s
    - Then we can load this information to our properties file so now our properties object has the information written to the .properties file