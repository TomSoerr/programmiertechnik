package vorlesung;


public class Main {
  public static void main(String[] args) {
    Zaehler z = new Zaehler();
    System.out.println(z.zaehlerstand);
    z.inkrement();
    System.out.println(z.zaehlerstand);
    z.erhoehen(true, 5);
    System.out.println(z.zaehlerstand);
  }
}

class Zaehler {
  int zaehlerstand;

  void inkrement() {
    zaehlerstand++;

  }

  void erhoehen(boolean wahrheiswert, int zahl) {
    if (wahrheiswert) {
      zaehlerstand += zahl;
    }
  }

}