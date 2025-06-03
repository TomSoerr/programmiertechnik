package aufgabe4;

public class Wagen {

  /**
   * Statischer Zähler für die Id
   */
  private static int idZaehler = 0;

  /**
   * Id eines Wagens
   */
  private String id;

  /**
   * Hinteres Ende des Wagens, an welches ein anderer Wagen gehängt werden kann
   * oder welches das absolute Ende des Wagens darstellt.
   */
  private Wagen naechsterWagen = null;

  /**
   * Konstrukter für einen Wagen. Zählt die Id hoch.
   */
  public Wagen() {
    id = "wagen" + idZaehler;
    idZaehler++;
  }

  /**
   * Getter für naechsterWagen
   *
   * @return Wert von naechsterWagen
   */
  public Wagen getNaechsterWagen() {
    return naechsterWagen;
  }

  /**
   * Setter für naechsterWagen.
   *
   * @param naechsterWagen Die neue Referenz.
   */
  public void setNaechsterWagen(Wagen naechsterWagen) {
    System.out.println(naechsterWagen);
    this.naechsterWagen = naechsterWagen;
  }
}
