# Human Benchmark Testing Framework

This repository contains an automated testing framework for completing all the challenges on the [Human Benchmark website](https://humanbenchmark.com/). The framework is built using Java, TestNG, Selenium, and Cucumber.

## Features
- Automates Human Benchmark challenges
- Comprehensive test coverage for each challenge
- Modular design for easy maintenance and extensibility
### Most Recent Results
![alt text](https://github.com/msyuksel/HumanBenchmarkTesting/blob/main/image.png)

## Technologies
- Java
- TestNG
- Selenium
- Cucumber

## Getting Started
To set up the project on your local machine, follow these steps:

1. Clone the repository:

  in terminal or bash
```bash
git clone https://github.com/yourusername/human-benchmark-testing.git
```

2. Import the project into your preferred IDE as a Maven project.

3. Configure the project's JDK to a version 11 or higher.

4. Install the required dependencies using Maven:


```bash
mvn clean install
```

5. Run the tests using the TestNG runner.


The following tasks are in progress or remaining:

- Add Verbal Memory Page Object
- Add Verbal Memory TestNg runner and .feature files
- Add Verbal Memory tests Step Definitions
- Convert Aim Test, Memory Test, Sequence Memory, and Typing test pages main method tests to cucumber testng tests.
- Make test for reaction time
- Make the regression test open in sequence on the same tab rather than opening a new browser each time.
- Fix Number memory test.
- Configure tests run from testng xml and through Jenkins rather than just TestNG runner
## Contributing
Feel free to contribute to the project by submitting pull requests or opening issues for any bugs or feature requests. Please follow the standard code of conduct and best practices for contributing to open-source projects.
