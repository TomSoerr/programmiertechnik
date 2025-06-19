package aufgabe6;

/**
 * Brettspiel klasse zum Speichern eines Spiels.
 */
public class Brettspiel {
  /**
   * Name des Brettspiels
   */
  private final String titel;

  /**
   * Anzahl der empfohlenen spielenden Personen im Paar min und max
   */
  private final int[] spielerzahl;

  /**
   * Das Mindestalter des Spiels
   */
  private final int mindestalter;

  /**
   * Erstellt ein Brettspiel Objekt und setzt alle erforderlichen Werte. Der
   * Titel darf nicht null sein.
   *
   * @param titel        Titel des Brettspiels
   * @param spielerzahl  Spielanzahl als Array mit länge zwei (min, max)
   * @param mindestalter Mindestalter des Spiels
   */
  public Brettspiel(String titel, int[] spielerzahl, int mindestalter) {
    if (titel == null) {
      throw new IllegalArgumentException("titel muss ein String Objekt sein");
    }
    if (spielerzahl.length != 2) {
      throw new IllegalArgumentException(
          "spielzahl muss Array mit länge zwei sein");
    }
    if (spielerzahl[0] < 1 ||
        spielerzahl[0] > spielerzahl[1]) {
      throw new IllegalArgumentException(
          "spielerzahl muss im Format [min, max] sein. Nur natürliche Spielzahlen sind erlaubt");
    }
    if (mindestalter < 0) {
      throw new IllegalArgumentException("mindestalter darf nicht negativ sein");
    }

    this.titel = titel;
    this.mindestalter = mindestalter;
    this.spielerzahl = spielerzahl;
  }

  /**
   * Gibt das Mindestalter des Spiels aus
   *
   * @return Mindestalter als integer
   */
  public int getMindestalter() {
    return mindestalter;
  }

  /**
   * Gibt den Titel des Spiels aus
   *
   * @return Titel des Spiels als String
   */
  public String getTitel() {
    return titel;
  }

  /**
   * Gibt die Anzahl der empfohlen spielenden Personen als Array der länge zwei
   * aus. Wobei der erste Wert die minimal und der zweite Wert die maximale
   * Anzahl ist.
   *
   * @return Spielerzahl als Array[2]
   */
  public int[] getSpielerzahl() {
    return spielerzahl;
  }

  /**
   * Gibt eine formatierte Beschreibung des Brettspiels auf der Konsole aus.
   */
  public void ausgeben() {
    System.out.format("%s (%d-%d Spieler:innen, ab %d Jahren)",
        titel,
        spielerzahl[0],
        spielerzahl[1],
        mindestalter);
  }
}
