package aufgabe5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaeresGatterUndTest {
  @Test
  public void testeToString() {
    Gatter wahr = new Eingang(true);
    Gatter falsch = new Eingang(false);

    String soll = "(WAHR ∧ WAHR)";
    String ist = (new BinaeresGatterUnd(wahr, wahr)).toString();
    assertEquals(soll,
        ist,
        "Teste toString von UND mit Eingabe Gatter wahr und wahr");

    soll = "(FALSCH ∧ WAHR)";
    ist = (new BinaeresGatterUnd(falsch, wahr)).toString();
    assertEquals(soll,
        ist,
        "Teste toString von UND mit Eingabe Gatter falsch und wahr");
  }

  @Test
  public void testeGetOutput() {
    Gatter wahr = new Eingang(true);
    Gatter falsch = new Eingang(false);

    boolean ist = (new BinaeresGatterUnd(wahr, wahr)).getOutput();
    assertTrue(ist, "Teste getOutput von UND mit wahr und wahr");

    ist = (new BinaeresGatterUnd(wahr, falsch)).getOutput();
    assertFalse(ist, "Teste getOutput von UND mit wahr und falsch");

    ist = (new BinaeresGatterUnd(falsch, falsch)).getOutput();
    assertFalse(ist, "Teste getOutput von UND mit falsch und falsch");
  }
}
