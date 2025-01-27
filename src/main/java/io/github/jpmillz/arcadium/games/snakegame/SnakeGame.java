package io.github.jpmillz.arcadium.games.snakegame;

public class SnakeGame {

    private GameGrid grid;
    private Snake snake;

    public SnakeGame(){
        this.grid = new GameGrid(10, 10);
        this.snake = new Snake();
    }


    public void updateTilePieces(){
       for (int i = 0; i < snake.getSize(); i++){
           SnakePiece piece = snake.getPieceAt(i);
           grid.setTileType(piece.getX(), piece.getY(), GameGrid.TileTypes.SNAKEPIECE);
       }
    }

    public void moveSnakePiece(){

    }

    public boolean isInvalidMovemoent(){
        SnakePiece piece = snake.getHeadPiece();
        return switch (piece.getDirection()){
            case UP -> piece.getY() - 1 < 0;
            case DOWN -> piece.getY() + 1 > grid.getGrid().length;
            case LEFT -> piece.getX() - 1 < 0;
            case RIGHT -> piece.getX() + 1 > grid.getGrid().length;
        };
    }


    public void moveSnake(){
        if (!isInvalidMovemoent()) {
            snake.getHeadPiece().move();
            if (snake.hasBodyPieces()) {
                for (int i = 1; i < snake.getSize(); i++) {
                    SnakePiece currentPiece = snake.getPieceAt(i);
                    SnakePiece pieceAhead = snake.getPieceAt(i - 1);
                    SnakePiece.Direction aheadDirection = pieceAhead.getDirection();
                    if (snake.shouldChangeDirection(pieceAhead, currentPiece)) {
                        currentPiece.changeDirection(aheadDirection);
                    }
                    if (i == snake.getSize() - 1) {
                        grid.setTileType(currentPiece.getX(), currentPiece.getY(), GameGrid.TileTypes.EMPTY);
                    }
                    currentPiece.move();
                }
            }
        }
    }

    public void tick(){
        updateTilePieces();
        moveSnake();
    }
}
