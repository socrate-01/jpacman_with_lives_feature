# JPacman (Software Reengineering Build)

## About

Pacman-like game used for teaching. The original JPacman [repository](https://github.com/SERG-Delft/jpacman) was developed at Delft University of Technology.

This fork is used by the [Software Reengineering course](https://ansymore.uantwerpen.be/courses/software-reengineering) at the [University of Antwerp](https://www.uantwerpen.be/en/). **Warning:** if you are not a student for the Software Reengineering course, I strongly recommend you fork the original JPacman repository intead of this one.

This fork contains bad smells and questionable practices (effectively making the code quality worst) introduced on purpose so that students can use reengineering tools to find and refactor these bad practices. Moreover, the testing parts of this fork will change from the original repository. Although, many parts of the code are still left untested intentionally.

## Getting Started

### IntelliJ
1. Git clone the project
2. Open IntelliJ and create new project "from existing sources"
3. Select 'Gradle' in the following screen as external model, and click 'Next'
4. In the next screen, optionally adjust the Gradle options and click 'Finish'
5. To see JPacman in action: run `nl.tudelft.jpacman.Launcher`
6. To run the test suite in IntelliJ: right click on a test or directory -> `Run` or `Run ...Test`
    1. To see the coverage, on the Gradle tasks plugin right click on 'test' and select -> `Run 'jpacman[test]' with Coverage` 

### Command line
1. Git clone the project
2. To build JPacman without running: `./gradlew build`
3. To see JPacman in action: `./gradlew run`
4. To run the tests use: `./gradlew test`
5. For static analysis tools (not used in Software Reengineering): `./gradlew staticAnalysis`
6. For static analysis tools and tests (not used in Software Reengineering): `./gradlew check`
