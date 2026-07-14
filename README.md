JUnit 5 Sample Project

A minimal Maven project demonstrating JUnit 5 (Jupiter) testing.

Requirements


Java 17+ (change maven.compiler.source/target in pom.xml for older JDKs)
Maven 3.6+


Run the tests

bashmvn test

Project structure

junit-sample/
├── pom.xml
├── src/
│   ├── main/java/com/example/
│   │   ├── Calculator.java
│   │   └── StringUtils.java
│   └── test/java/com/example/
│       ├── CalculatorTest.java
│       └── StringUtilsTest.java

What's demonstrated


@Test, @DisplayName — basic tests with readable names
@BeforeEach / @AfterEach — setup and teardown per test
@Nested — grouping related tests (see Division tests)
assertEquals, assertTrue, assertFalse, assertAll
assertThrows — verifying exceptions and their messages
@ParameterizedTest with @CsvSource, @ValueSource, @NullAndEmptySource