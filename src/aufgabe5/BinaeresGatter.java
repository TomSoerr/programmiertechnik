package aufgabe5;

public abstract class BinaeresGatter implements Gatter {
  /**
   * Eingänge-Gatter als Array. Länge 2.
   */
  private final Gatter[] eingaenge ;
  // wie lässt sich die länge sonst festlegen?

  /**
   * Konstruktor setzt die beiden Eingänge des BinärenGatters.
   *
   * @param gatterEins Erstes Eingangsgatter
   * @param gatterZwei Zweites Eingangsgatter
   */
  public BinaeresGatter(Gatter gatterEins, Gatter gatterZwei) {
    if (gatterEins == null || gatterZwei == null) {
      throw new IllegalArgumentException("Eingabegatter müssen Objekte sein");
    }
    eingaenge = new Gatter[]{gatterEins, gatterZwei};
  }

  /**
   * Getter für eingänge.
   *
   * @return Eingangsgatter-Array mit länge 2
   */
  public Gatter[] getEingaenge() {
    return eingaenge;
  }

  // Dokumentation im Interface!

  @Override
  public abstract boolean getOutput();

  @Override
  public abstract String toString();
}
