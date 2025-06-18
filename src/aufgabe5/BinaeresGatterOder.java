package aufgabe5;

/**
 * Logische Oder Gatter. Verknüpft die Ergebnisse zweier Eingabegatter miteinander
 */
public class BinaeresGatterOder extends BinaeresGatter {

  /**
   * Konstruktor setzt die beiden Eingänge des BinärenGatters. Argumente dürfen
   * nicht null sein!
   *
   * @param gatterEins Erstes Eingangsgatter
   * @param gatterZwei Zweites Eingangsgatter
   */
  public BinaeresGatterOder(Gatter gatterEins, Gatter gatterZwei) {
    super(gatterEins, gatterZwei);
  }

  /**
   * Berechne den Output für das Gatter.
   *
   * @return Oder-Verknüpfung der zwei Eingabegatter.
   */
  @Override
  public boolean getOutput() {
    Gatter[] eingaenge = getEingaenge();
    return eingaenge[0].getOutput() || eingaenge[1].getOutput();
  }

  /**
   * Beschreibung der aktuellen Oder-Instanz. Ruft die toString Methode der
   * Eingänge auf und benutzt die Rückgaben für die Beschreibung.
   *
   * @return Beschreibung / Zustand des Gatters inkusive der davor geschalteten Gatter
   */
  @Override
  public String toString() {
    Gatter[] eingaenge = getEingaenge();
    return String.format("(%s ∨ %s)", eingaenge[0], eingaenge[1]);
  }
}
