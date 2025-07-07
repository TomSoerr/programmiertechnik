package aufgabe6;

public class Anwendung {
  public static void main(String[] args) {
    Brettspiel gloomhaven = new Brettspiel("Gloomhaven", new int[]{1, 4}, 12);
    Brettspiel catan = new Brettspiel("Catan", new int[]{3, 4}, 10);
    Brettspiel carcassonne = new Brettspiel("Carcassonne", new int[]{2, 5}, 8);
    Brettspiel pandemic = new Brettspiel("Pandemic", new int[]{2, 4}, 8);
    Brettspiel azul = new Brettspiel("Azul", new int[]{2, 4}, 8);

    Brettspielsammlung sammlung1 = new Brettspielsammlung();
    sammlung1.hinzufuegen(gloomhaven)
        .hinzufuegen(catan)
        .hinzufuegen(carcassonne);


    Brettspielsammlung sammlung2 = new Brettspielsammlung();
    sammlung2.hinzufuegen(carcassonne).hinzufuegen(pandemic).hinzufuegen(azul);

    sammlung1.ausgeben();
    sammlung2.ausgeben();
  }
}
