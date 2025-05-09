package snake;

import snake.Snake;

public class SnakeTest {
  Snake snake = null;

  void test() {
    snake = new Snake(10, 15);

  }

  /**
   * Test two boolean values and prints a message in case they are unequal
   *
   * @param expected the expected value
   * @param gotten   the result value
   * @param errorMsg the error message
   * @return returns true if the test has passed
   */
  boolean testBoolean(boolean expected, boolean gotten, String errorMsg) {
    if (expected != gotten) {
      System.out.println("Failed: " + errorMsg + "  ::  expected: " + expected + "  ::  gotten: " + gotten);
      return false;
    }

    return true;
  }

  /**
   * Test the updateIllegalPosition function. The position gets moved inside or outside the
   * playable area, and then it gets tested if the state is moved back into the legal area.
   */
  boolean updateIllegalPositionTest() {
    boolean testRes = true;

    testRes = testBoolean(
        snake.areaX > 8 && snake.areaY > 8,
        true,
        "Test if playable area is large enough"
    );

    // test the start position
    testRes = testRes && moveSnakeAndCheckPosition(
        snake.positionX,
        snake.positionY,
        "Test if start position is legal",
        true
    );

    // test top left corner
    testRes = testRes && moveSnakeAndCheckPosition(
        0,
        0,
        "Test if top left corner position is legal",
        true
    );

    // test top left corner
    testRes = testRes && moveSnakeAndCheckPosition(
        snake.areaX - 1,
        snake.areaY - 1,
        "Test if bottom right corner position is legal",
        true
    );

    // test random playable area
    testRes = testRes && moveSnakeAndCheckPosition(
        (int) (Math.random() * snake.areaX), // random number [0, areaX)
        (int) (Math.random() * snake.areaY),
        "Test if random inside position is legal",
        true
    );

    // test top left outside playable area
    testRes = testRes && moveSnakeAndCheckPosition(
        -1,
        -1,
        "Test if top left outside position is illegal",
        false
    );

    // test bottom right outside playable area
    testRes = testRes && moveSnakeAndCheckPosition(
        snake.areaX,
        snake.areaY,
        "Test if bottom right outside position is illegal",
        false
    );


    // test random outside playable area
    testRes = testRes && moveSnakeAndCheckPosition(
        (int) (Math.random() * 100 + snake.areaX), // random number [areaX, areaX + 100)
        (int) (Math.random() * 100 + snake.areaY),
        "Test if random outside position is illegal",
        false
    );

    // test random outside playable area
    testRes = testRes && moveSnakeAndCheckPosition(
        (int) (Math.random() * -100), // random number (-100, 0]
        (int) (Math.random() * -100),
        "Test if random outside position is illegal",
        false
    );

    return testRes;
  }

  /**
   * Changes the position state to test if the updateIllegalPosition()
   * will revert any illegal moves.
   *
   * @param newPositionX the x position the snake is moved to before the test
   * @param newPositionY the Y position the snake is moved to before the test
   * @param testMsg      the message if the test fails
   * @param expected     if the position is legal
   */
  boolean moveSnakeAndCheckPosition(
      int newPositionX,
      int newPositionY,
      String testMsg,
      boolean expected
  ) {

    // update the current state
    snake.positionX = newPositionX;
    snake.positionY = newPositionY;

    // call the tested function that uses these states
    snake.updateIllegalPosition();

    // check if state has changed
    return testBoolean(
        expected,
        newPositionX == snake.positionX && newPositionY == snake.positionY,
        testMsg
    );
  }

  /**
   * Test the moveSnake function that moves the snake on every render.
   */
  boolean moveSnakeTest() {
    boolean testRes = true;

    snake.positionX = 1;
    snake.positionY = 1;

    snake.direction = 'd';
    this.moveSnakeTest();
    testRes = testBoolean(true, snake.positionX == 2, "Test move right");

    snake.direction = 's';
    this.moveSnakeTest();
    testRes = testRes && testBoolean(true, snake.positionY == 2, "Test move down");

    snake.direction = 'a';
    this.moveSnakeTest();
    testRes = testBoolean(true, snake.positionX == 1, "Test move left");

    snake.direction = 'w';
    this.moveSnakeTest();
    testRes = testRes && testBoolean(true, snake.positionY == 1, "Test move up");

    return testRes;
  }
}
