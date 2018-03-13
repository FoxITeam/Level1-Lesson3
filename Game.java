package ru.foxit.grayfox;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Game {
    // 1. Написать программу, которая загадывает случайное число от 0 до 9,
    // и пользователю дается 3 попытки угадать это число. При каждой попытке
    // компьютер должен сообщить больше ли указанное пользователем число чем
    // загаданное, или меньше. После победы или проигрыша выводится запрос –
    // «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int receivedNum;
        String warnMin = "Почти угадал, число меньше загаданного";
        String warnMax = "Почти угадал, число больше загаданного";
        int start = 1;
        while (start == 1) {
            int generateNum = random.nextInt(10);
            System.out.print("Введите число от 0 до 9: ");
            int whiles = 0;
            do {
                while (!sc.hasNextInt()) {
                    System.out.println("Вы ввели не число. Введите число от 0 до 9:");
                    sc.next();
                }
                receivedNum = sc.nextInt();
                //Включить, если ты хочешь всегда знать ответ.
                /*
                System.out.println("Число, которое загадала система: " + generateNum);
                System.out.println("Ваше число: " + receivedNum);
                */
                if (receivedNum < generateNum) {
                    System.out.println(warnMax);
                }
                if (receivedNum > generateNum) {
                    System.out.println(warnMin);
                }
                if (receivedNum == generateNum) {
                    System.out.println("Молодец! Ты угадал!");
                    break;
                }
                whiles++;
            } while (whiles < 3);

            System.out.println("Ответ системы: " + generateNum);
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            while (!sc.hasNextInt()) {
                System.out.println("Вы ввели не число. Повторить игру еще раз? 1 – да / 0 – нет");
                sc.next();
            }
            String yesno = sc.next();
            if (Objects.equals(yesno, "1")) {
                start = 1;
            } else {
                start = 0;
            }
        }

        sleep(1000);
        System.out.println("Спасибо за игру! Вы отличный игрок!");
        System.out.println("Завершаю игру через: ");
        sleep(1000);
        System.out.println("3");
        sleep(1000);
        System.out.println("2");
        sleep(1000);
        System.out.println("1");
        sleep(1000);
    }
}

