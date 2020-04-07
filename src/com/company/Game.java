package com.company;

import com.company.entity.XO;

public class Game {
    int n = 3;
    private XO[][] field = new XO[n][n];
    public boolean endGame = false;
    public XO winner;
    private int moveCount = 0;

    private XO getField(int i, int j) {
        return field[i][j];
    }

    private void setField(int i, int j, XO move) {
        this.field[i][j] = move;
        moveCount++;
    }

    public boolean playerMove(int i, int j) {
        if (field[i][j] == null) {
            if ((moveCount % 2) == 0) this.setField(i, j, XO.X);
            else this.setField(i, j, XO.O);
            return true;
        } else {
            System.out.println("Поле занято, введите другое поле!");
            return false;
        }
    }


    public void showField() {
        System.out.println("\n   0     1     2");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < n; j++) {
                XO move = getField(i, j);

                if (move == null) System.out.print("   ");
                else System.out.print(" " + move + " ");
                if (j != (n - 1)) System.out.print(" | ");
            }
            if (i != (n - 1)) System.out.println("\n  _______________");
        }
        System.out.println("\n");
    }
    public void showWinnerLog(){
        if(winner == null) System.out.println("Конец игры. Ничья.");
        else  System.out.println("Конец игры. \nПоздравляем победителя!!!!!!   **** " + winner+ " ****");
    }

    public void winnerCheck() {
        // Проверяем строки и столбцы
        for (int i = 0; i < n; i++) {
            if (compare(field[i]) || compare(getColumn(i))) {
                endGame = true;
                break;
            }
        }
        // проверяем по диагонали
        if ((!endGame) && ((compare(getDiagonal1()) || compare(getDiagonal2())))) {
            endGame = true;
        }
        if (moveCount == n * n) endGame = true;
    }

    private XO[] getDiagonal1() {
        XO[] set = new XO[n];
        for (int i = 0; i < n; i++) {
            set[i] = field[i][i];
        }
        return set;
    }

    private XO[] getDiagonal2() {
        XO[] set = new XO[n];
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            set[i] = field[i][j];
        }
        return set;
    }

    private XO[] getColumn(int index) {
        XO[] set = new XO[n];
        for (int i = 0; i < n; i++) {
            set[i] = field[i][index];
        }
        return set;
    }

    private boolean compare(XO[] set) {
        boolean check = false;
        for (int i = 0; i < set.length - 1; i++) {
            if ((set[i] != null) && (set[i] == set[i + 1])) {
                check = true;
                winner = set[i];
            } else {
                winner = null;
                check = false;
                break;
            }
        }
        return check;
    }


}
