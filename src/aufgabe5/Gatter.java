package aufgabe5;

/**
 * Logisches Gatter. Hat beliebige Anzahl an Eingängen. Eingänge sind ebenfalls
 * Gatter. So können mehrere Hatter hintereinader geschaltet werden.
 */
public interface Gatter {
  /**
   * Abfrage des Ausgabewerts des Gatters. Dazu müssen ggf die davor
   * geschalteten Gatter ausgewertet werden.
   *
   * @return Ergebnis der Verknüpfung
   */
  boolean getOutput();

  /**
   * Sinnvolle Beschreibung der Instanz.
   *
   * @return Beschreibung des Zustandes
   */
  String toString();
}
