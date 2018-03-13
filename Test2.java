package ru.foxit.grayfox;

import java.util.Random;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        guessTask1();

    }
    static void guessTask1() {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        char answer;

        guessGame();

        do {
            System.out.println("Повторить игру еще раз? y/n");
            while (!scanner.hasNext("[yn]")) {
                System.out.println("Не символ. Введите y/n:");
                scanner.next();
            }
            answer = scanner.next().charAt(0);

            if ('n' == answer) {
                isExit = true;
            } else if ('y' == answer) {
                guessGame();
            }
        } while (!isExit);
    }

    private static void guessGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int generate = random.nextInt(10);

        boolean isWin = false;
        int currentNum;

        for (int i = 0; i < 3; i++) {
            System.out.printf("Введите число от 0 до 9: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Не число. Введите число от 0 до 9:");
                scanner.next();
            }

            currentNum = scanner.nextInt();

            if (currentNum == generate) {
                isWin = true;
                break;
            } else if (currentNum > generate) {
                System.out.printf("%d > загаданное\n\n", currentNum);
            } else {
                System.out.printf("%d < загаданное\n\n", currentNum);
            }
        }

        if (isWin) System.out.println("Победа");
        else System.out.printf("GAME OVER. Ответ: %d\n", generate);
    }
}
