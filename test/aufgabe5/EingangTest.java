package aufgabe5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EingangTest {
  @Test
  public void testeToString() {
    String soll = "WAHR";
    String ist = (new Eingang(true)).toString();
    assertEquals(soll, ist, "Teste toString mit true");

    soll = "FALSCH";
    ist = (new Eingang(false)).toString();
    assertEquals(soll, ist, "Teste toString mit false");
  }

  @Test
  public void testeGetOutput() {
    boolean ist = (new Eingang(true)).getOutput();
    assertTrue(ist, "Teste getOutput mit Wert-Zustand true");

    ist = (new Eingang(false)).getOutput();
    assertFalse(ist, "Teste getOutput mit Wert-Zustand false");
  }
}
