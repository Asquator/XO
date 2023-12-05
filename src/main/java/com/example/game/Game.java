package com.example.game;

public class Game {

    private GameDetails gd;
    private byte[][] grid;

    public Game(GameDetails gd){
        this.gd = gd;
        int n = gd.size();
        grid = new byte[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = '0';

    }

    public void mark(int i, int j){
        grid[i][j] = gd.mark();
    }

    public void opponentMark(int i, int j){
        grid[i][j] = gd.opponentMark();
    }

    public String getName() {
        return gd.name();
    }

    public String getOpponentName() {
        return gd.opponentName();
    }

    public int getN() {
        return gd.size();
    }

    public byte getMark() {
        return gd.mark();
    }

    public byte getMark2() {
        return gd.opponentMark();
    }

    public GameDetails getGameDetails() {
        return gd;
    }
}
