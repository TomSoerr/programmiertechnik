package snake;

public class SnakeTest {
  Snake snake = null;

  void test() {
    boolean allTestsPassed = true;
    snake = new Snake(10, 15);

    allTestsPassed = updateIllegalPositionTest();
    allTestsPassed = allTestsPassed && moveSnakeTest();
    allTestsPassed = allTestsPassed && mulStringTest();

    System.out.println(allTestsPassed
                       ? "All tests passed"
                       : "Something went wrong");
  }

  /**
   * Test two int values and prints a message in case they are unequal
   *
   * @param expected the expected value
   * @param gotten   the result value
   * @param errorMsg the error message
   * @return returns true if the test has passed
   */
  boolean testValues(String expected, String gotten, String errorMsg) {
    if (!expected.equals(gotten)) {
      System.out.println("Failed: " +
          errorMsg +
          "  ::  expected: " +
          expected +
          "  ::  gotten: " +
          gotten);
      return false;
    }

    return true;
  }

  /**
   * Test two int values and prints a message in case they are unequal
   *
   * @param expected the expected value
   * @param gotten   the result value
   * @param errorMsg the error message
   * @return returns true if the test has passed
   */
  boolean testValues(int expected, int gotten, String errorMsg) {
    if (expected != gotten) {
      System.out.println("Failed: " +
          errorMsg +
          "  ::  expected: " +
          expected +
          "  ::  gotten: " +
          gotten);
      return false;
    }

    return true;
  }

  /**
   * Test the updateIllegalPosition function. The position gets moved inside
   * or outside the playable area, and then it gets tested if the state is
   * moved back into the legal area. W
   */
  boolean updateIllegalPositionTest() {
    boolean testRes = true;

    // test the start position
    testRes = testRes && moveSnakeAndCheckPosition(
        snake.positionX,
        snake.positionY,
        snake.positionX,
        snake.positionY,
        "Test if start position is legal"
    );

    // test top left corner
    testRes = testRes && moveSnakeAndCheckPosition(
        0,
        0,
        0,
        0,
        "Test if top left corner position is legal"
    );

    // test bottom right corner
    testRes = testRes && moveSnakeAndCheckPosition(
        snake.areaX - 1,
        snake.areaY - 1,
        snake.areaX - 1,
        snake.areaY - 1,
        "Test if bottom right corner position is legal"
    );

    // test random playable area
    int x = (int) (Math.random() * snake.areaX); // random number [0, areaX)
    int y = (int) (Math.random() * snake.areaY);
    testRes = testRes && moveSnakeAndCheckPosition(
        x,
        y,
        x,
        y,
        "Test if random inside position is legal"
    );

    // test top left outside playable area
    testRes = testRes && moveSnakeAndCheckPosition(
        -1,
        -1,
        0,
        0,
        "Test if top left outside position is illegal"
    );

    // test bottom right outside playable area
    testRes = testRes && moveSnakeAndCheckPosition(
        snake.areaX,
        snake.areaY,
        snake.areaX - 1,
        snake.areaY - 1,
        "Test if bottom right outside position is illegal"
    );

    // test random outside playable area
    testRes = testRes && moveSnakeAndCheckPosition(
        (int) (Math.random() * 100 + snake.areaX),
        (int) (Math.random() * 100 + snake.areaY),
        snake.areaX - 1,
        snake.areaY - 1,
        "Test if random outside position is illegal"

    );

    // test random outside playable area
    testRes = testRes && moveSnakeAndCheckPosition(
        (int) (Math.random() * -100), // random number (-100, 0]
        (int) (Math.random() * -100),
        0,
        0,
        "Test if random outside position is illegal"
    );

    return testRes;
  }

  /**
   * Changes the position state to test if the updateIllegalPosition()
   * will revert any illegal moves.
   *
   * @param newPositionX      the x position the snake is moved to before the test
   * @param newPositionY      the Y position the snake is moved to before the test
   * @param expectedPositionX the X position the snake should be after check
   * @param expectedPositionY the Y position the snake should be after check
   * @param testMsg           the message if the test fails
   */
  boolean moveSnakeAndCheckPosition(
      int newPositionX,
      int newPositionY,
      int expectedPositionX,
      int expectedPositionY,
      String testMsg
  ) {
    boolean testRes = true;

    // update the current state
    snake.positionX = newPositionX;
    snake.positionY = newPositionY;

    // call the tested function that uses these states
    snake.updateIllegalPosition();

    testRes = testValues(
        expectedPositionX,
        snake.positionX,
        testMsg + " (X Position)"
    );

    // check if state has changed
    return testRes && testValues(
        expectedPositionY,
        snake.positionY,
        testMsg + " (Y Position)"
    );
  }

  /**
   * Test the moveSnake function that moves the snake on every render. Will
   * test every 4 direction that the snake can move.
   */
  boolean moveSnakeTest() {
    boolean testRes = true;

    snake.positionX = 1;
    snake.positionY = 1;

    snake.direction = 'd';
    snake.moveSnake();
    testRes = testValues(2, snake.positionX, "Test move right");

    snake.direction = 's';
    snake.moveSnake();
    testRes = testRes &&
        testValues(2, snake.positionY, "Test move down");

    snake.direction = 'a';
    snake.moveSnake();
    testRes = testValues(1, snake.positionX, "Test move left");

    snake.direction = 'w';
    snake.moveSnake();
    testRes = testRes &&
        testValues(1, snake.positionY, "Test move up");

    return testRes;
  }

  boolean mulStringTest() {
    boolean testRes = true;

    testRes = testValues("",
        snake.mulString("aa", 0),
        "Test mul string by 0");

    testRes = testRes && testValues("",
        snake.mulString("aa", -1),
        "Test mul string by neg number");

    testRes = testRes && testValues("aaaa",
        snake.mulString("aa", 2),
        "Test mul string with aa times 2");

    testRes = testRes && testValues("az",
        snake.mulString("az", 1),
        "Test mul string with aa times 1");

    return testRes;
  }
}
