package wagenundzug;

/**
 * Ein Zug der als Startpunkt für mehrere Wagons genutzt wird
 */
public class Zug {
  /**
   * Erster Wagen im Zug
   */
  private Wagen ersterWagen = null;

  /**
   * Um die unterschiedlichen privaten Methoden zu testen, lässt es sich
   * zwischen rekursiv und iterativ wechseln.
   */
  public static String prozess = "iterativ";

  /**
   * Gibt den ersten Wagen im Zug zurück.
   *
   * @return Erster Wagen. Kann null sein!
   */
  public Wagen getErsterWagen() {
    return ersterWagen;
  }

  /**
   * Rekursive Methode um den letzten Wagen des Zuges zu finden
   *
   * @param wagen Startwagen
   * @return Wagen der auf null zeigt und somit am Ende des Zuges ist
   */
  private Wagen getLetzterWagenRec(Wagen wagen) {
    Wagen naechsterWagen = wagen.getNaechsterWagen();
    return naechsterWagen == null ? wagen : getLetzterWagenRec(naechsterWagen);
  }

  /**
   * Iterative Methode um den letzten Wagen des Zuges zu finden
   *
   * @param wagen Startwagen
   * @return Wagen der auf null zeigt und somit am Ende des Zuges ist
   */
  private Wagen getLetzterWagenIter(Wagen wagen) {
    Wagen naechsterWagen = wagen.getNaechsterWagen();
    while (naechsterWagen != null) {
      wagen = naechsterWagen;
      naechsterWagen = wagen.getNaechsterWagen();
    }

    return wagen;
  }

  /**
   * Methode zum Anhängen eines Wagens am Ende des Zuges.
   *
   * @param neuerWagen Referenz des Wagens, der ans Ende gehängt werden soll.
   */
  public void anhaengen(Wagen neuerWagen) {
    if (ersterWagen == null) {
      ersterWagen = neuerWagen;
      return;
    }

    Wagen letzterWagen;
    if (prozess.equals("iterativ")) {
      letzterWagen = getLetzterWagenIter(ersterWagen);
    } else {
      letzterWagen = getLetzterWagenRec(ersterWagen);
    }

    letzterWagen.setNaechsterWagen(neuerWagen);
  }

  private Wagen getWagenVorRef(Wagen wagen, Wagen ref) {
    Wagen naechsterWagen = wagen.getNaechsterWagen();

    if (naechsterWagen == ref) {
      return wagen;
    }


    return naechsterWagen == null ? null : getWagenVorRef(naechsterWagen, ref);
  }

  /**
   * Methode zum Abhängen eines Wagens vom Zug. Setzt die Referenz
   * vom abgehängten Wagen zurück auf null. Die nachfolgenden Wagen werden
   * an den vorherigen Wagen gehängt.
   *
   * @param wagen Referenz des Wagens, der abgehängt werden soll.
   * @exception IllegalArgumentException Wenn das Argument null ist
   * @return Wahrheitswert, ob etwas abgehängt wurde order nicht
   */
  public boolean abhaengen(Wagen wagen) {
    // Basisfälle
    if (wagen == null) {
      throw new IllegalArgumentException("Wagen muss eine gültige Referenz sein");
    }
    if (ersterWagen == null) {
      return false;
    }
    if (ersterWagen == wagen) {
      ersterWagen = wagen.getNaechsterWagen();
      return true;
    }

    // Rekursive Fälle
    Wagen vorgaenger = getWagenVorRef(ersterWagen, wagen);

    if (vorgaenger == null) {
      return false;
    }
    vorgaenger.setNaechsterWagen(wagen.getNaechsterWagen());
    wagen.setNaechsterWagen(null);
    return true;
  }

}
