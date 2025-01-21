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

    public Direction getDirection(){
        return direction;
    }

    public void changeDirection(Direction newDirection){
        this.direction = newDirection;
    }


    public enum Direction{
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
}
