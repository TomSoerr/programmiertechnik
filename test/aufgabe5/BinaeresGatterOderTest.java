package aufgabe5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaeresGatterOderTest {
  @Test
  public void testeToString() {
    Gatter wahr = new Eingang(true);
    Gatter falsch = new Eingang(false);

    String soll = "(WAHR ∨ WAHR)";
    String ist = (new BinaeresGatterOder(wahr, wahr)).toString();
    assertEquals(soll,
        ist,
        "Teste toString von ODER mit Eingabe Gatter wahr und wahr");

    soll = "(FALSCH ∨ WAHR)";
    ist = (new BinaeresGatterOder(falsch, wahr)).toString();
    assertEquals(soll,
        ist,
        "Teste toString von ODER mit Eingabe Gatter falsch und wahr");
  }

  @Test
  public void testeGetOutput() {
    Gatter wahr = new Eingang(true);
    Gatter falsch = new Eingang(false);


    boolean ist = (new BinaeresGatterOder(wahr, wahr)).getOutput();
    assertTrue(ist, "Teste getOutput von ODER mit wahr und wahr");

    ist = (new BinaeresGatterOder(wahr, falsch)).getOutput();
    assertTrue(ist, "Teste getOutput von ODER mit wahr und falsch");


    ist = (new BinaeresGatterOder(falsch, falsch)).getOutput();
    assertFalse(ist, "Teste getOutput von ODER mit falsch und falsch");
  }
}
