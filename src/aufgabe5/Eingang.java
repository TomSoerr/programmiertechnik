package aufgabe5;

public class Eingang implements Gatter{
  /**
   * Konstanter Wert des Eingangsgatters
   */
  private final boolean wert;

  /**
   * Konstruktor für Eingabegatter.
   *
   * @param wert Wert des Eingangsgatters
   */
  public Eingang(boolean wert) {
    this.wert = wert;
  }

  /**
   * Gibt den Konstanten Wert des Eingangs aus.
   *
   * @return Wert des Gatters
   */
  @Override
  public boolean getOutput() {
    return wert;
  }

  /**
   * Beschreibung der aktuellen Eingangsinstanz.
   *
   * @return Zustand des Eingangs WAHR | FALSCH
   */
  @Override
  public String toString() {
    return wert ? "WAHR" : "FALSCH";
  }
}
