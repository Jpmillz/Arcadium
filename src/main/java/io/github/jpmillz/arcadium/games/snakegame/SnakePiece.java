package io.github.jpmillz.arcadium.games.snakegame;

public class SnakePiece {

    private int x;
    private int y;
    private Direction direction;

    public SnakePiece(int x, int y, Direction movementDirection){
        this.x = x;
        this.y = y;
        this.direction = movementDirection;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Direction getDirection(){
        return direction;
    }

    public void changeDirection(Direction newDirection){
        this.direction = newDirection;
    }

    public Direction getNextDirection(SnakePiece piecesAhead){
        return piecesAhead.direction;
    }

    public void move(){
        switch (this.direction){
            case LEFT:
                this.x--;
            case RIGHT:
                this.x++;
            case UP:
                this.y--;
            case DOWN:
                this.y++;
        }
    }


    public enum Direction{
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
}
