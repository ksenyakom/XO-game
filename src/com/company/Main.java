package com.company;

import com.company.utils.ConsoleInput;

public class Main {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру \"крестики-нолики\"!!!");
        Game game = new Game();
        game.showField();

        ConsoleInput input = new ConsoleInput();
        while (!game.endGame) {
            input.inputMove();
            if (game.playerMove(input.i, input.j)) game.showField();
            game.winnerCheck();
            if (game.endGame)  game.showWinnerLog();
        }

    }

}
