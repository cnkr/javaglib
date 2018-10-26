package org.lwjglb.game;

import org.lwjglb.engine.IGameLogic;
import org.lwjglb.engine.GameEngine;

public class Main {

    public static void main(String[] args) {
        try {
            boolean vSync = true;
            IGameLogic gameLogic = new DummyGame();
            GameEngine gameEng = new GameEngine(
                    "Game",
                    600,
                    480,
                    vSync,
                    gameLogic
            );
            gameEng.start();
        } catch (Exception excp) {
            excp.printStackTrace();
            System.exit(-1);
        }
    }
}

