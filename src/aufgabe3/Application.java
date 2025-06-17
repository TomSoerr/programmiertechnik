package aufgabe3;

public class Application {
  public static final String ENV = "development";
  // public static final String ENV = "production";

  public static void main(String[] args) {

    if (ENV == "development") {
      // stops the draw function from running continuously
      SnakeTest snakeTest = new SnakeTest();
      snakeTest.test();
    }

    if (ENV == "production") {
      Snake game = new Snake(13, 8); // or 15, 8. not clear
      game.play();
    }
  }
}
