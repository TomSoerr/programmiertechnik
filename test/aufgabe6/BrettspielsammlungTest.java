package aufgabe6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BrettspielsammlungTest {
  @Test
  public void testeHinzufuegen() {
    // Teste brettspiel null
    assertThrows(IllegalArgumentException.class, () -> {
      (new Brettspielsammlung()).hinzufuegen(null);
    }, "Keine IllegalArgumentException bei brettspiel null ");

    // Teste Sammlung mit keinem Spiel
    Brettspielsammlung brettspielsammlung = new Brettspielsammlung();
    assertEquals(0,
        brettspielsammlung.getAnzahlBrettspiele(),
        "Ausgangszustand muss Länge 0 haben");

    Brettspiel brettspiel1 = new Brettspiel("Brettspiel1", new int[]{1, 2}, 2);
    Brettspiel brettspiel2 = new Brettspiel("Brettspiel2", new int[]{1, 2}, 2);
    Brettspiel brettspiel3 = new Brettspiel("Brettspiel3", new int[]{1, 2}, 2);
    Brettspiel brettspiel4 = new Brettspiel("Brettspiel4", new int[]{1, 2}, 2);

    // Teste Sammlung mit einem Spiel hinzufügen
    brettspielsammlung.hinzufuegen(brettspiel1);
    assertNotEquals(-1,
        brettspielsammlung.getIndexFuer(brettspiel1),
        "Das hinzugefügte Spiel 1 muss in der Sammlung sein");

    // Teste Sammlung mit mehreren Spielen
    brettspielsammlung.hinzufuegen(brettspiel2).hinzufuegen(brettspiel3);
    assertNotEquals(-1,
        brettspielsammlung.getIndexFuer(brettspiel2),
        "Das hinzugefügte Spiel 2 muss in der Sammlung sein");
    assertNotEquals(-1,
        brettspielsammlung.getIndexFuer(brettspiel3),
        "Das hinzugefügte Spiel 3 muss in der Sammlung sein");

    // Teste Sammlung mit nicht vorhandenem Spiel
    assertEquals(-1,
        brettspielsammlung.getIndexFuer(brettspiel4),
        "Das nicht hinzugefügte Spiel 4 darf nicht in der Sammlung sein");

  }


}
