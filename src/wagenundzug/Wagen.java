package wagenundzug;

public class Wagen {

  private static int idZaehler = 0;
  private String id;
  private Wagen naechsterWagen = null;

  Wagen() {
    id = String.valueOf(idZaehler);
    idZaehler++;
  }

  public Wagen getNaechsterWagen() {
    return naechsterWagen;
  }

  public String getId() {
    return id;
  }

  public void setNaechsterWagen(Wagen naechsterWagen) {
    this.naechsterWagen = naechsterWagen;
  }
}
