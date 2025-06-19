package aufgabe6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BrettspielTest {
  @Test
  public void testeBrettspiel() {
    // Teste titel null
    assertThrows(IllegalArgumentException.class, () -> {
      new Brettspiel(null, new int[]{1, 2}, 1);
    }, "Keine IllegalArgumentException bei titel null ");

    // Teste falsche länge des Arrays
    assertThrows(IllegalArgumentException.class, () -> {
      new Brettspiel("Test", new int[]{1, 2, 3}, 1);
    }, "Keine IllegalArgumentException bei spielerzahl länge != 2");

    // Teste spielerzahl min kleiner 1
    assertThrows(IllegalArgumentException.class, () -> {
      new Brettspiel("Test", new int[]{-2, 2}, 1);
    }, "Keine IllegalArgumentException bei spielerzahl min < 1");

    // Teste spielerzahl min größer max
    assertThrows(IllegalArgumentException.class, () -> {
      new Brettspiel("Test", new int[]{3, 2}, 1);
    }, "Keine IllegalArgumentException bei spielerzahl min größer max");

    // Teste mindestalter kleiner 0
    assertThrows(IllegalArgumentException.class, () -> {
      new Brettspiel("Test", new int[]{1, 2}, -1);
    }, "Keine IllegalArgumentException mindestalter kleiner 0");
  }

  @Test
  public void testeGetTitel() {
    // Teste ob Titel richtig gespeichert wird
    String titel = "Test";
    Brettspiel bs = new Brettspiel(titel, new int[]{1, 2}, 1);
    assertEquals(titel,
        bs.getTitel(),
        "getMindestalter gibt nicht den gesetzten titel zurück");
  }

  @Test
  public void testeGetSpielerzahl() {
    // Teste ob Spielerzahl richtig gespeichert wird
    int[] spielerzahl = new int[]{1, 2};
    Brettspiel bs = new Brettspiel("Test", spielerzahl, 1);
    assertEquals(spielerzahl,
        bs.getSpielerzahl(),
        "getSpielerzahl gibt nicht die richtige spielerzahl zurück");
  }

  @Test
  public void testeGetMindestalter() {
    // Teste ob Spielerzahl richtig gespeichert wird
    int mindestalter = 3;
    Brettspiel bs = new Brettspiel("Test", new int[]{1, 2}, mindestalter);
    assertEquals(mindestalter,
        bs.getMindestalter(),
        "getSpielerzahl gibt nicht das richtige mindestalter zurück");
  }

}
