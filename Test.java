package ru.foxit.grayfox;

import java.lang.*;
import java.util.Objects;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int nnn = 1;
        while (nnn == 1) {

            String a = "Ошибка, число больше загаданного";
            String b = "В точку! вы угадали. Хотите попробовать ещё раз?";
            String c = "Ошибка, число меньше загаданного";

            int nn = 0;
            int max = 9;
            int min = 0;
            int rn1 = min + (int) (Math.random() * max);
            Scanner in = new Scanner(System.in);
            System.out.println("Отгадайте число от нуля до девяти");


            // System.out.println(rn1);

            int n = in.nextInt();
            if (n < rn1) {
                System.out.println(c);
                nn++;
            }
            if (n > rn1) {
                System.out.println(a);
                nn++;
            }
            if (n == rn1) {
                System.out.println(b);
            }

            Scanner in2 = new Scanner(System.in);
            System.out.println("Отгадайте число от нуля до девяти");
            int n2 = in2.nextInt();
            if (n2 < rn1) {
                System.out.println(c);
                nn++;
            }
            if (n2 > rn1) {
                System.out.println(a);
                nn++;
            }
            if (n2 == rn1) {
                System.out.println(b);
            }
            Scanner in3 = new Scanner(System.in);
            System.out.println("Отгадайте число от нуля до девяти");
            int n3 = in3.nextInt();
            if (n3 < rn1) {
                System.out.println(c);
                nn++;
            }
            if (n3 > rn1) {
                System.out.println(a);
                nn++;
            }
            if (n3 == rn1) {
                System.out.println(b);
            }

            if (nn == 3) {

                System.out.println("Вы использовали макс. кол-во попыток, пропробуйте снова");

            }
            System.out.println("Хотите продолжить(y=yes, n=no)");
            Scanner in4 = new Scanner(System.in);
            String yesno = in4.next();
            if (Objects.equals(yesno, "y")) {
                nnn = 1;
            } else {
                nnn = 0;
            }
        }
    }
}
