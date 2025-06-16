package aufgabe5;

public abstract class BinaeresGatter implements Gatter {
  /**
   * Eingänge-Gatter als Array. Länge 2.
   */
  protected Gatter[] eingaenge;

  @Override
  public abstract boolean getOutput();

  @Override
  public abstract String toString();
}
