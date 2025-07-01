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

    Brettspielsammlung brettspielsammlung = new Brettspielsammlung();

    Brettspiel brettspiel1 = new Brettspiel("Brettspiel1", new int[]{1, 2}, 2);
    Brettspiel brettspiel2 = new Brettspiel("Brettspiel2", new int[]{1, 2}, 2);
    Brettspiel brettspiel3 = new Brettspiel("Brettspiel3", new int[]{1, 2}, 2);

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
  }

  @Test
  public void testeEntfernen() {
    // Teste brettspiel null
    assertThrows(IllegalArgumentException.class, () -> {
      (new Brettspielsammlung()).hinzufuegen(null);
    }, "Keine IllegalArgumentException bei brettspiel null ");

    Brettspielsammlung brettspielsammlung = new Brettspielsammlung();

    Brettspiel brettspiel1 = new Brettspiel("Brettspiel1", new int[]{1, 2}, 2);
    Brettspiel brettspiel2 = new Brettspiel("Brettspiel2", new int[]{1, 2}, 2);
    Brettspiel brettspiel3 = new Brettspiel("Brettspiel3", new int[]{1, 2}, 2);

    // Teste Sammlung mit einem Spiel hinzufügen
    brettspielsammlung.hinzufuegen(brettspiel1);
    brettspielsammlung.entfernen(brettspiel1);
    assertEquals(-1,
        brettspielsammlung.getIndexFuer(brettspiel1),
        "Das entfernte Spiel 1 darf nicht in der Sammlung sein");

    // Teste Sammlung mit mehreren Spielen
    brettspielsammlung.hinzufuegen(brettspiel2).hinzufuegen(brettspiel3);
    brettspielsammlung.entfernen(brettspiel2).entfernen(brettspiel3);
    assertEquals(-1,
        brettspielsammlung.getIndexFuer(brettspiel2),
        "Das entfernte Spiel 2 darf nicht in der Sammlung sein");
    assertEquals(-1,
        brettspielsammlung.getIndexFuer(brettspiel3),
        "Das entfernte Spiel 3 darf nicht in der Sammlung sein");

    // Teste Nachrücken

    Brettspielsammlung brettspielsammlung2 = new Brettspielsammlung();

    Brettspiel brettspiel4 = new Brettspiel("Brettspiel4", new int[]{1, 2}, 2);
    Brettspiel brettspiel5 = new Brettspiel("Brettspiel5", new int[]{1, 2}, 2);

    brettspielsammlung2.hinzufuegen(brettspiel4).hinzufuegen(brettspiel5);

    assertEquals(0,
        brettspielsammlung2.getIndexFuer(brettspiel4),
        "Der Index vom Spiel 4 muss 0 sein");

    brettspielsammlung2.entfernen(brettspiel4);
    assertEquals(0,
        brettspielsammlung2.getIndexFuer(brettspiel5),
        "Der Index vom Spiel 5 muss 0 sein");

  }

  @Test
  public void testeLeeren() {
    Brettspielsammlung brettspielsammlung = new Brettspielsammlung();

    Brettspiel brettspiel1 = new Brettspiel("Brettspiel1", new int[]{1, 2}, 2);
    Brettspiel brettspiel2 = new Brettspiel("Brettspiel2", new int[]{1, 2}, 2);
    Brettspiel brettspiel3 = new Brettspiel("Brettspiel3", new int[]{1, 2}, 2);

    brettspielsammlung.hinzufuegen(brettspiel1)
        .hinzufuegen(brettspiel2)
        .hinzufuegen(brettspiel3);

    brettspielsammlung.leeren();

    assertEquals(-1,
        brettspielsammlung.getIndexFuer(brettspiel1),
        "Nach dem leeren darf Spiel 1 nicht in der Sammlung sein");
    assertEquals(-1,
        brettspielsammlung.getIndexFuer(brettspiel2),
        "Nach dem leeren darf Spiel 2 nicht in der Sammlung sein");
    assertEquals(-1,
        brettspielsammlung.getIndexFuer(brettspiel3),
        "Nach dem leeren darf Spiel 3 nicht in der Sammlung sein");
  }

  @Test
  public void testeGetBrettspielAnIndex() {
    Brettspielsammlung brettspielsammlung = new Brettspielsammlung();

    Brettspiel brettspiel1 = new Brettspiel("Brettspiel1", new int[]{1, 2}, 2);
    Brettspiel brettspiel2 = new Brettspiel("Brettspiel2", new int[]{1, 2}, 2);

    brettspielsammlung.hinzufuegen(brettspiel1).hinzufuegen(brettspiel2);

    assertEquals(brettspiel1,
        brettspielsammlung.getBrettspielAnIndex(0),
        "Das erste Element in der Sammlung muss Spiel 1 sein");
    assertEquals(brettspiel2,
        brettspielsammlung.getBrettspielAnIndex(1),
        "Das zweite Element in der Sammlung muss Spiel 2 sein");
  }

  @Test
  public void testeGetAnzahlBrettspiele() {
    Brettspielsammlung brettspielsammlung = new Brettspielsammlung();

    Brettspiel brettspiel1 = new Brettspiel("Brettspiel1", new int[]{1, 2}, 2);
    Brettspiel brettspiel2 = new Brettspiel("Brettspiel2", new int[]{1, 2}, 2);

    assertEquals(0,
        brettspielsammlung.getAnzahlBrettspiele(),
        "Sammlung muss am Anfang leer sein");

    brettspielsammlung.hinzufuegen(brettspiel1);

    assertEquals(1,
        brettspielsammlung.getAnzahlBrettspiele(),
        "Anzahl der Spiele muss 1 sein");

    brettspielsammlung.hinzufuegen(brettspiel2);

    assertEquals(2,
        brettspielsammlung.getAnzahlBrettspiele(),
        "Anzahl der Spiele muss 2 sein");
  }

  @Test
  public void testeGetIndexFuer() {
    Brettspielsammlung brettspielsammlung = new Brettspielsammlung();

    Brettspiel brettspiel1 = new Brettspiel("Brettspiel1", new int[]{1, 2}, 2);
    Brettspiel brettspiel2 = new Brettspiel("Brettspiel2", new int[]{1, 2}, 2);

    assertEquals(-1,
        brettspielsammlung.getIndexFuer(brettspiel1),
        "Wenn Spiel nicht in Sammlung ist, wird -1 erwartet");

    brettspielsammlung.hinzufuegen(brettspiel1);

    assertEquals(0,
        brettspielsammlung.getIndexFuer(brettspiel1),
        "Erstes Element muss index 0 haben");

    brettspielsammlung.hinzufuegen(brettspiel2);

    assertEquals(1,
        brettspielsammlung.getIndexFuer(brettspiel2),
        "Zweites Element muss index 1 haben");


  }


}
