package aufgabe5;

/**
 * Negations-Gatter. Negiert das Eingangsgatter.
 */
public class GatterNicht implements Gatter {
  /**
   * Eingangsgatter. Erlaubt nur ein Gatter, weil Negation unär ist.
   */
  private final Gatter eingang;

  /**
   * Konstruktor für das NOT-Gatter.
   *
   * @param eingang Eingabegatter, welches negiert werden soll.
   */
  public GatterNicht(Gatter eingang) {
    if (eingang == null) {
      throw new IllegalArgumentException("Argument muss ein Gatter Objekt sein");
    }

    this.eingang = eingang;
  }

  /**
   * Berechne den Output für das Gatter.
   *
   * @return Negation des Eingabegatters
   */
  @Override
  public boolean getOutput() {
    return !eingang.getOutput();
  }

  /**
   * Beschreibung der aktuellen Negationsinstanz. Ruft die toString Methode des
   * Eingangs auf und benutzt die Rückgabe für die Beschreibung.
   *
   * @return Beschreibung / Zustand des Gatters inkusive der davor geschalteten
   */
  @Override
  public String toString() {
    return "(¬ " + eingang + ")";
  }
}
