package io.github.jpmillz.arcadium.games.snakegame;

public class GameGrid {

    private TileTypes[][] grid;
    private Snake snake;
    private int columns;
    private int rows;

    public GameGrid(int rows, int columns){
        this.columns = columns;
        this.rows = rows;
        this.snake = new Snake();
        grid = new TileTypes[rows][columns];
        initGrid();
        setTileType(snake.getHeadPiece().getX(), snake.getHeadPiece().getY(), TileTypes.SNAKEPIECE);
    }

    public int getColumns(){
        return this.columns;
    }

    public int getRows(){
        return this.rows;
    }

    public TileTypes getTileType(int row, int column){
        return grid[column][row];
    }

    public TileTypes[][] getGrid() {
        return grid;
    }

    public void setTileType(int row, int column, TileTypes type){
        grid[column][row] = type;
    }

    public void initGrid() {
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < columns; c++){
                    setTileType(r, c, TileTypes.EMPTY);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder returnS = new StringBuilder();
        for (int r = 0; r < grid.length; r++){
            StringBuilder builder = new StringBuilder();
            for (int c = 0; c < grid.length; c++){
                builder.append("row: " + r + "Col: " + c + " " + getTileType(r, c) + " ");
            }
            returnS.append(builder + "\n");
        }
        return returnS.toString();
    }

    public enum TileTypes{
        EMPTY,
        SNAKEPIECE,
        OBJECTIVE,
        BONUS;
    }
}
