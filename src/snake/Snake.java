package snake;

public class Snake {
  // size of the playable area
  int areaX = 10;
  int areaY = 15;

  // current position of the snake without scaling
  // starting from 0 till not including AREA_X, AREA_Y
  int positionX = 3;
  int positionY = 5;

  char direction = 's';

  /**
   *
   *
   * @param sizeX
   * @param sizeY
   */
  public Snake(int sizeX, int sizeY) {

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

  /*
   * Check if current position is legal and go back if so
   * Uses the global positionY, positionX, AREA_X, and AREA_Y variables
   *
   * @return void
   */
  void updateIllegalPosition() {
    if (positionX < 0) {
      positionX = 0;
    }
    if (positionY < 0) {
      positionY = 0;
    }

    if (positionX >= AREA_X) {
      positionX = AREA_X - 1;
    }
    if (positionY >= AREA_Y) {
      positionY = AREA_Y - 1;
    }
  }
}
