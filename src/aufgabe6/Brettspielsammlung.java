package aufgabe6;


import java.util.Arrays;

/**
 * Brettspielsammlung klasse zum Sammeln mehrerer Spiele
 */
public class Brettspielsammlung {
  /**
   * Brettspielsammlung als Array
   */
  private Brettspiel[] brettspielsammlung;

  /**
   * Zähler der Anzahl der Spiele
   */
  private int anzahlBrettspiele;

  /**
   * Konstruktor der Sammlung. Array hat am Anfang länge 0. Anzahl ebenfalls 0.
   */
  public Brettspielsammlung() {
    brettspielsammlung = new Brettspiel[0];
    anzahlBrettspiele = 0;
  }

  /**
   * Methode zum Hinzufügen eines Brettspiels am Ende des Arrays. Argument darf
   * nicht null sein. Wenn das Array voll ist, wird die länge verdoppelt, bevor
   * das neue Spiel angehängt wird. Der Zähler der Spiele wird um eins erhöht.
   *
   * @param brettspiel Brettspiel Objekt (darf nicht null sein)
   */
  public Brettspielsammlung hinzufuegen(Brettspiel brettspiel) {
    if (brettspiel == null) {
      throw new IllegalArgumentException(
          "brettspiel muss ein Brettspiel Objekt sein");
    }

    // Länge der Sammlung überprüfen und ggf. anpassen
    if (anzahlBrettspiele >= brettspielsammlung.length) {
      // überprüfe, auf Multiplikation mit Null.
      int
          newLength =
          (brettspielsammlung.length == 0) ? 1 : brettspielsammlung.length * 2;
      brettspielsammlung = Arrays.copyOf(brettspielsammlung, newLength);
    }

    // brettspiel am Ende des Arrays hinzufügen
    brettspielsammlung[anzahlBrettspiele] = brettspiel;

    anzahlBrettspiele++;

    return this;
  }

  /**
   * Methode zum Entfernen eines Brettspiels aus der Sammlung. Existiert das
   * Brettspiel nicht in der Sammlung passiert nicht. Wenn das Brettspiel in der
   * Mitte der Sammlung entfernt wird, dann rücken die anderen Spiele nach, um
   * die Lücke zu schließen.
   *
   * @param brettspiel Brettspiel, welches Entfernt werden sollen (null nicht
   *                   erlaubt)
   */
  public Brettspielsammlung entfernen(Brettspiel brettspiel) {
    if (brettspiel == null) {
      throw new IllegalArgumentException(
          "brettspiel muss ein Brettspiel Objekt sein");
    }

    // brettspiel index finden
    int index = getIndexFuer(brettspiel);

    // wenn Brettspiel nicht in Sammlung dann passiert nichts
    if (index == -1) {
      return this;
    }

    for (int i = index; i < anzahlBrettspiele - 1; i++) {
      brettspielsammlung[i] = brettspielsammlung[i + 1];
    }

    // letztes Brettspiel mit null überschreiben
    brettspielsammlung[anzahlBrettspiele - 1] = null;

    // Anzahl der Brettspiele anpassen
    anzahlBrettspiele -= 1;

    return this;
  }

  /**
   * Methode zum Leeren der gesamten Sammlung. Die Länge wird beibehalten.
   */
  public void leeren() {
    brettspielsammlung = new Brettspiel[brettspielsammlung.length];
  }

  /**
   * Methode zum Ausgeben der gesamten Sammlung. Ruft die ausgabe Methode der
   * Brettspielobjekte auf.
   */
  public void ausgeben() {
    for (Brettspiel brettspiel : brettspielsammlung) {
      if (brettspiel == null) {
        return; // oder break
      }
      brettspiel.ausgeben();
    }
  }

  /**
   * Hilfsmethode, um ein Brettspiel an einem Index zu bekommen. Der Index darf
   * nicht negativ oder größer als die Anzahl der Spiele sein.
   *
   * @param index Index, von dem das Brettspielobjekt zurückgegeben werden soll
   * @return Das Brettspiel am angegeben index.
   */
  public Brettspiel getBrettspielAnIndex(int index) {
    if (index < 0 || index >= anzahlBrettspiele) {
      throw new IllegalArgumentException("index nicht im Bereich des Arrays");
    }

    return brettspielsammlung[index];
  }

  /**
   * Methode um die Anzahl der gespeicherten Spiele zurückzugeben.
   *
   * @return Anzahl der Brettspiele in der Sammlung
   */
  public int getAnzahlBrettspiele() {
    return anzahlBrettspiele;
  }

  /**
   * Methode zum Finden des Indexes eines Brettspiels in der Sammlung. Wenn das
   * Brettspiel nicht in der Sammlung ist, dann wird -1 zurückgegeben.
   *
   * @param brettspiel Brettspiel Objekt nach dem in der Sammlung gesucht werden
   *                   soll.
   * @return Index des Brettspiels oder -1, wenn Spiel nicht in der Sammlung.
   */
  public int getIndexFuer(Brettspiel brettspiel) {
    for (int index = 0; index < anzahlBrettspiele; index++) {
      if (brettspielsammlung[index] == brettspiel) {
        return index;
      }
    }

    return -1;
  }

}
