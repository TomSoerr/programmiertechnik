package aufgabe5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GatterNichtTest {
  @Test
  public void testeToString() {
    Gatter wahr = new Eingang(true);
    Gatter falsch = new Eingang(false);

    String soll = "(¬ WAHR)";
    String ist = (new GatterNicht(wahr)).toString();
    assertEquals(soll, ist, "Teste toString mit Eingabe Gatter true");

    soll = "(¬ FALSCH)";
    ist = (new GatterNicht(falsch)).toString();
    assertEquals(soll, ist, "Teste toString mit Eingabe Gatter false");
  }

  @Test
  public void testeGetOutput() {
    Gatter wahr = new Eingang(true);
    Gatter falsch = new Eingang(false);

    boolean ist = (new GatterNicht(wahr)).getOutput();
    assertFalse(ist, "Teste getOutput mit Wert-Zustand true");

    ist = (new GatterNicht(falsch)).getOutput();
    assertEquals(true, ist, "Teste getOutput mit Wert-Zustand false");
  }
}
