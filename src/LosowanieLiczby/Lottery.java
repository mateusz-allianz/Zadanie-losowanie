package LosowanieLiczby;

import java.util.Random;
import java.util.Scanner;

public class Lottery {
    private static final int EXIT = 0;
    private static final int PLAY = 1;
    private static final int MAX_NUMBER = 100;

    private int randomChoice;
    private int userNumber;

    private void numberRandom() {
        Random random = new Random();
        randomChoice = random.nextInt(MAX_NUMBER);
    }

    Scanner scanner = new Scanner(System.in);

    void controlLoop() {
        int option;

        do {
            printOptions();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case PLAY:
                    logic();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Nie ma takiej opcji");
            }
        } while (option != EXIT);

    }

    private void printOptions() {
        System.out.println("Wybierz opcję: ");
        System.out.println(EXIT + " - Wyjście z programu");
        System.out.println(PLAY + " - Graj");
    }

    private void logic() {
        numberRandom();
        System.out.println("Podaj liczbę z zakresu od 0 do 100: ");
        while (userNumber != randomChoice) {
            userNumber = scanner.nextInt();
            if (userNumber < randomChoice) {
                System.out.println("Za mało ");
            } else if (userNumber > randomChoice) {
                System.out.println("Za dużo");
            } else {
                System.out.println("Brało! Trafiłeś");
            }
        }
    }

    private void exit() {
        System.out.println("Koniec programu, papa!");
        scanner.close();
    }
}
