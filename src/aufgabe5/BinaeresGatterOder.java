package aufgabe5;

// TODO Doku
// test

public class BinaeresGatterOder extends BinaeresGatter {

  public BinaeresGatterOder(Gatter eins, Gatter zwei) {
    if (eins == null || zwei == null) {
      throw new IllegalArgumentException("Eingabegatter müssen Objekte sein");
    }

    this.eingaenge = new Gatter[]{eins, zwei};
  }

  @Override
  public boolean getOutput() {
    return eingaenge[0].getOutput() || eingaenge[1].getOutput();
  }

  @Override
  public String toString() {
    return String.format("(%s ∨ %s)", eingaenge[0], eingaenge[1]);
  }
}
