package ru.foxit.grayfox;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

/**
*
Ниже напишу то, что написал Максим Ресчиков
-----------------------------------------------Исправлено ниже-----------------------------------------------------
Scanner sc = new Scanner(System.in);

Random random = new Random();
Обьекты надо создавать вне цикла, в данной задаче нет такой необходимости.
На garbage collector надейся, а сам не плошай. в цикле будет куча объетов.
—--------------------------------------------Исправлено ниже-----------------------------------------------------
Scanner sc2 = new Scanner(System.in);
Нужно обойтись одним сканером на всю игру
—-------------------------------------------------Не исправлено-----------------------------------------------------
while (!sc2.hasNextInt()) { // Цикл для того, чтобы проверить, правильно ли ты вводишь цифры.
System.out.println("Вы ввели не число. Повторить игру еще раз? 1 – да / 0 – нет");
sc2.next(); //Ну а тут мы пропускаем введенное значение, если это цифры.
}
String yesno = sc2.next();
здесь 2 раза идет одно и толже вычисление sc2.next(); надо совместить, возможно придеться изменить алгоритм.
—----------------------------------------------------Не исправлено--------------------------------------------------
int start = 1; // Инициализируем int start и присваиваем 1.
while (start == 1) {
зачем? это я так понимаю внешний основной цикл. может проще воспользоваться do while, ведь нам все равно придется один раз пройти игру, если уж мы запустили программу.
—----------------Это я понял, но пусть пока будет в Main--------------------------------------------
Вообще желательно код было разбить на несколько методов, читаемость лучще. надо ознакомиться с процедурным программированием.
—----Комментарии я делаю для себя, чтобы понимать что я пишу--------------------
Правильное название переменных и методов, может польностью исключить комментарии. в них отпадает необходимость.
—----------------Спрошу на занятиях, как можно это по другому реализовать--------
if (Objects.equals(yesno, "1")) это конечно можно, но вы ведь работает со строками, так и желательно работать с методами строк, тем более что для строк в java метод equals переопределять не надо
посмотри:
https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
сравни для строк:
public boolean equals(Object anObject) {
if (this == anObject) {
return true;
}
if (anObject instanceof String) {
String anotherString = (String)anObject;
int n = value.length;
if (n == anotherString.value.length) {
char v1[] = value;
char v2[] = anotherString.value;
int i = 0;
while (n— != 0) {
if (v1[i] != v2[i])
return false;
i++;
}
return true;
}
}
return false;
}
для обьектов:
public static boolean equals(Object a, Object b) {
return (a == b) || (a != null && a.equals(b));
}

public boolean equals(Object obj) {
return (this == obj);
}
*
**/

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

