package com.company.utils;

import java.util.Scanner;

public class ConsoleInput {
    public int i;
    public int j;


    public void inputMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ваш ход: ");
        while (true) {
            String move = scanner.nextLine();
            if (move.length() == 2) {

                this.i = Character.getNumericValue(move.charAt(0));
                this.j = Character.getNumericValue(move.charAt(1));
                if (this.i > 2 | this.j > 2) {
                    System.out.print("Введите два числа от 0 до 2");
                    continue;
                }
                break;
            } else {
                System.out.print("Введите два числа от 0 до 2");
            }
        }
    }
}
