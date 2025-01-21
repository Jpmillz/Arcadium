package io.github.jpmillz.arcadium.games.snakegame;

public class GameGrid {

    private TileTypes[][] grid;
    private int columns;
    private int rows;

    public GameGrid(int rows, int columns){
        this.columns = columns;
        this.rows = rows;
        initGrid();
    }

    public void initGrid() {
        TileTypes[][] returnGrid = new TileTypes[rows][columns];
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < columns; c++){
                returnGrid[r][c] = TileTypes.EMPTY;
            }
        }
        this.grid = returnGrid;
    }

    public enum TileTypes{
        EMPTY,
        SNAKEPIECE,
        OBJECTIVE,
        BONUS;
    }
}
