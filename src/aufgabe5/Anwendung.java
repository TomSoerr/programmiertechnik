package aufgabe5;

public class Anwendung {
  public static void main(String[] args) {
    // Beispiel Abbildung 2
    Gatter wahr = new Eingang(true);
    Gatter falsch = new Eingang(false);

    Gatter und = new BinaeresGatterUnd(falsch, wahr);
    Gatter oder = new BinaeresGatterOder(und, wahr);
    Gatter nicht = new GatterNicht(oder);

    System.out.println(nicht);
    System.out.println(nicht.getOutput());
  }
}
