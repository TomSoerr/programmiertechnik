package vorlesung;

import java.util.Scanner;

public class Main {
  public static void main(String [] args) {
    Scanner scanner = new Scanner(System.in);

    String str = scanner.nextLine();
    int num = scanner.nextInt();

    System.out.println("Zeichenkette = " + str + " Ganzzahl = " + num);

    scanner.close();
  }
}
