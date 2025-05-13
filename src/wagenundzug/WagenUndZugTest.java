package wagenundzug;

public class WagenUndZugTest {
  /**
   * Haupt Testmethode des Packages wagenundzug
   */
  public void teste() {
    boolean alleTestsErfolgreich = true;

    alleTestsErfolgreich = testeWagen();
    alleTestsErfolgreich = alleTestsErfolgreich && testeZug();

    System.out.println(alleTestsErfolgreich
                       ? "Alle Tests erfolgreich"
                       : "Etwas ist schiefgelaufen");
  }

  /**
   * Methode zum Testen, ob zwei Wägen gleich sind.
   *
   * @param soll Erwartungswert
   * @param ist Istwert
   * @param errorMsg Nachricht, die bei einer Abweichung ausgegeben wird
   * @return Wahr, wenn es keine Abweichung gibt.
   */
  private boolean testeRef(Wagen soll, Wagen ist, String errorMsg) {
    if (soll != ist) {
      System.out.println("Failed: " +
          errorMsg +
          "  ::  soll: " +
          soll +
          "  ::  ist: " +
          ist);
      return false;
    }

    return true;
  }

  /**
   * Methode zum Testen, ob zwei boolean gleich sind.
   *
   * @param soll Erwartungswert
   * @param ist Istwert
   * @param errorMsg Nachricht, die bei einer Abweichung ausgegeben wird
   * @return Wahr, wenn es keine Abweichung gibt.
   */
  private boolean testeBool(boolean soll, boolean ist, String errorMsg) {
    if (soll != ist) {
      System.out.println("Failed: " +
          errorMsg +
          "  ::  soll: " +
          soll +
          "  ::  gotten: " +
          ist);
      return false;
    }

    return true;
  }

  /**
   * Testet die Wagen Klasse
   *
   * @return Wahr wenn alle Tests der Klasse Wagen erfolgreich sind
   */
  private boolean testeWagen() {
    boolean testErg = true;

    // Setup
    Wagen wagen0 = new Wagen();
    Wagen wagen1 = new Wagen();

    // Testfälle
    wagen0.setNaechsterWagen(wagen1);
    testErg = testeRef(
        wagen1,
        wagen0.getNaechsterWagen(),
        "Teste anhängen von Wagen 1");

    wagen1.setNaechsterWagen(wagen0);
    testErg = testErg && testeRef(
        wagen0,
        wagen1.getNaechsterWagen(),
        "Teste anhängen von Wage 0");

    testErg = testErg && testeRef(
        wagen1,
        wagen1.getNaechsterWagen().getNaechsterWagen(),
        "Teste Kreis von Wägen");

    return testErg;
  }

  /**
   * Testet die Zug Klasse
   *
   * @return Wahr wenn alle Tests der Klasse Zug erfolgreich sind
   */
  private boolean testeZug() {
    boolean testErg = true;

    // Setup
    Wagen wagen0 = new Wagen();
    Wagen wagen1 = new Wagen();
    Wagen wagen2 = new Wagen();

    Zug zug = new Zug();

    // Testfälle

    // Können noch nicht IllegalArgumentException testen!
    testErg = testeBool(
        false,
        zug.abhaengen(wagen0),
        "Teste leeren Zug");

    zug.anhaengen(wagen0);
    testErg = testErg && testeBool(
        true,
        zug.abhaengen(wagen0),
        "Teste erster Wagen abhängen Zug (Rückgabewert)");
    testErg = testErg && testeRef(
        null,
        zug.getErsterWagen(),
        "Teste erster Wagen abhängen Zug (Zustand)");

    zug.anhaengen(wagen0);
    zug.anhaengen(wagen1);
    testErg = testErg && testeBool(
        false,
        zug.abhaengen(wagen2),
        "Teste keinen Wagen abhängen von nicht leeren Zug (Rückgabewert)");
    testErg = testErg && testeRef(
        wagen1,
        zug.getErsterWagen().getNaechsterWagen(),
        "Teste keinen Wagen abhängen von nicht leeren Zug (Zustand)");

    zug.anhaengen(wagen2);
    testErg = testErg && testeBool(
        true,
        zug.abhaengen(wagen1),
        "Teste mittleren Wagen abhängen von Zug (Rückgabewert)");
    testErg = testErg && testeRef(
        wagen2,
        zug.getErsterWagen().getNaechsterWagen(),
        "Teste mittleren Wagen abhängen von Zug 1 (Zustand)");
    testErg = testErg && testeRef(
        wagen0,
        zug.getErsterWagen(),
        "Teste mittleren Wagen abhängen von Zug 2 (Zustand)");

    // Neue Reihenfolge wagen0 -> wagen2 -> wagen1
    zug.anhaengen(wagen1);

    testErg = testErg && testeBool(
        true,
        zug.abhaengen(wagen0),
        "Teste ersten Wagen abhängen von Zug (Rückgabewert)");
    testErg = testErg && testeRef(
        wagen1,
        zug.getErsterWagen().getNaechsterWagen(),
        "Teste ersten Wagen abhängen von Zug 1 (Zustand)");
    testErg = testErg && testeRef(
        wagen2,
        zug.getErsterWagen(),
        "Teste ersten Wagen abhängen von Zug 2 (Zustand)");

    // Neue Reihenfolge wagen2 -> wagen1 -> wagen0
    zug.anhaengen(wagen0);

    testErg = testErg && testeBool(
        true,
        zug.abhaengen(wagen0),
        "Teste letzten Wagen abhängen von Zug (Rückgabewert)");
    testErg = testErg && testeRef(
        wagen1,
        zug.getErsterWagen().getNaechsterWagen(),
        "Teste letzten Wagen abhängen von Zug 1 (Zustand)");
    testErg = testErg && testeRef(
        wagen2,
        zug.getErsterWagen(),
        "Teste letzten Wagen abhängen von Zug 2 (Zustand)");

    return testErg;
  }

}
