package snake;

public class Application {
  //String ENV = "development";
  public static final String ENV = "production";

  public static void main(String[] args) {

    if (ENV == "development") {
      // stops the draw function from running continuously
      SnakeTest unitTests = new SnakeTest();
      unitTests.test();
    }

    if (ENV == "production") {
      Snake game = new Snake();

    }

    System.out.println("Snake Application called");
  }
}
