package io.github.jpmillz.arcadium.games.snakegame;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<SnakePiece> bodyPieces;

    public Snake(){
        this.bodyPieces = new ArrayList<>();
        bodyPieces.add(new SnakePiece(0, 0, SnakePiece.Direction.DOWN));
    }

    public void addPiece(){
        SnakePiece pieceAhead = bodyPieces.get(bodyPieces.size() - 1);
        bodyPieces.add(addNewSnakePiece(pieceAhead));
    }

    public SnakePiece addNewSnakePiece(SnakePiece pieceAhead){
        SnakePiece.Direction direction = pieceAhead.getDirection();
        int x = pieceAhead.getX();
        int y = pieceAhead.getY();
        return switch (direction) {
            case UP -> new SnakePiece(x, y - 1, direction);
            case DOWN -> new SnakePiece(x, y + 1, direction);
            case LEFT -> new SnakePiece(x + 1, y, direction);
            case RIGHT -> new SnakePiece(x - 1, y, direction);
        };
    }

    public int getSize(){
        return bodyPieces.size();
    }

    public SnakePiece getPieceAt(int index){
        return bodyPieces.get(index);
    }

    public SnakePiece getHeadPiece(){
        return bodyPieces.get(0);
    }

    public boolean hasBodyPieces(){
        return this.bodyPieces.size() > 1;
    }

    public boolean shouldChangeDirection(SnakePiece aheadPiece, SnakePiece current){
        return aheadPiece.getDirection() != current.getDirection();
    }


}
