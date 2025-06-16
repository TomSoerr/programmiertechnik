package aufgabe5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GatterTest {
  @Test
  public void testKomplexeSchaltung() {
    Gatter wahr = new Eingang(true);
    Gatter falsch = new Eingang(false);

    Gatter und = new BinaeresGatterUnd(falsch, wahr);
    Gatter oder = new BinaeresGatterOder(und, wahr);
    Gatter nicht = new GatterNicht(oder);

    assertFalse(nicht.getOutput(), "Teste getOutput auf komplexer Schaltung");
    assertEquals("(¬ ((FALSCH ∧ WAHR) ∨ WAHR))",
        nicht.toString(),
        "Teste toString auf komplexer Schaltung");
  }
}
