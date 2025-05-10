package snake;

import java.util.Scanner;

public class Snake {
  // size of the playable area
  int areaX;
  int areaY;

  // current position of the snake without scaling
  // starting from 0 till not including areaX, areaY
  int positionX = 3;
  int positionY = 5;

  char direction = 's';

  /**
   * @param areaX
   * @param areaY
   */
  public Snake(int areaX, int areaY) {
    if (areaX < 4 || areaY < 4) {
      throw new IllegalArgumentException("Playable area to small");
    }

    this.areaX = areaX;
    this.areaY = areaY;
  }

  /**
   * Main game function. Starts the game.
   */
  void play() {
    System.out.println("game started");
    draw();
    Scanner scanner = new Scanner(System.in);
    char input;

    while (true) {
      input = scanner.next().charAt(0);
      if (input == 'w' || input == 'a' || input == 's' || input == 'd') {
        direction = input;
      } else if (input == 'e') {
        scanner.close();
        break;
      }
      moveSnake();
      updateIllegalPosition();
      draw();
    }
  }

  /**
   * Update the position of the snake according to the direction
   * Uses the global positionY and positionX variables.
   */
  void moveSnake() {
    switch (direction) {
      case 'w':
        positionY -= 1;
        break;
      case 's':
        positionY += 1;
        break;
      case 'a':
        positionX -= 1;
        break;
      case 'd':
        positionX += 1;
        break;
    }
  }

  /**
   * Check if current position is legal and go back if so
   * Uses the global positionY, positionX, AREA_X, and AREA_Y variables
   */
  void updateIllegalPosition() {
    if (positionX < 0) {
      positionX = 0;
    }
    if (positionY < 0) {
      positionY = 0;
    }

    if (positionX >= areaX) {
      positionX = areaX - 1;
    }
    if (positionY >= areaY) {
      positionY = areaY - 1;
    }
  }

  /**
   * Helper function for the draw function
   *
   * @param str   The string that is repeated
   * @param times The number how many times the string gets repeated
   * @return The new string containing the string multiple times
   */
  String mulString(String str, int times) {
    String res = "";
    for (int x = 0; x < times; x++) {
      res += str;
    }
    return res;
  }

  /**
   * Print the game to the console using println and chars
   */
  void draw() {
    // print top border
    System.out.println(mulString("#", areaX + 2));

    // print game area
    for (int row = 0; row < areaY; row++) {
      if (positionY != row) {
        System.out.println("#" + mulString(" ", areaX) + "#");
      } else {
        System.out.println("#" +
            mulString(" ", positionX) +
            "x" +
            mulString(" ", areaX - positionX - 1) +
            "#");
      }
    }

    // print bottom border
    System.out.println(mulString("#", areaX + 2));
  }
}
