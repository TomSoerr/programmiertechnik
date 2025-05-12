package wagenundzug;

public class Anwendung {
  public static final String ENV = "production";
  // public static final String ENV = "production";

  public static void main(String[] args) {

    if (ENV == "development") {
    }

    if (ENV == "production") {
      System.out.println("Wagen und Zug Program aufgerufen");

      Wagen wagen0 = new Wagen();
      Wagen wagen1 = new Wagen();
      Wagen wagen2 = new Wagen();
      Wagen wagen3 = new Wagen();

      Zug zug = new Zug();

      zug.anhaengen(wagen0);
      zug.anhaengen(wagen1);
      zug.anhaengen(wagen2);
      zug.anhaengen(wagen3);

      System.out.println(wagen2.getNaechsterWagen().getId());

      zug.abhaengen(wagen2);
      System.out.println(wagen1.getNaechsterWagen().getId());
    }
  }
}
