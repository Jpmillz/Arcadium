package io.github.jpmillz.arcadium.games.snakegame;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.awt.*;

public class GameGridScreen {
    private final int width = 200;
    private final int height = 200;
    private final int gridPixelSize = 5;
    private final int rows = height / gridPixelSize;
    private final int columns = width / gridPixelSize;

    private GameGrid gameGrid;

    private SnakeGame game;

    public GameGridScreen(GameGrid gameGrid){
        this.gameGrid = gameGrid;
        this.game = new SnakeGame();
    }

    public void renderGrid(GuiGraphics graphics){
        for (int r = 0; r < gameGrid.getRows(); r++){
            for (int c = 0; c < gameGrid.getColumns(); c++){
                GameGrid.TileTypes type = gameGrid.getTileType(r, c);
                int minX = width + (c * gridPixelSize);
                int minY = height + (r * gridPixelSize);
                int maxX = minX + 5;
                int maxY = minY + 5;
                graphics.fill(minX, minY, maxX, maxY, getTileColor(type));
            }
        }
    }

    public int getTileColor(GameGrid.TileTypes type){
        switch (type){
            case EMPTY:
                return Color.black.getRGB();
            case SNAKEPIECE:
                return Color.white.getRGB();
            case OBJECTIVE:
                return Color.red.getRGB();
        }
        return -1;
    }


    public void tick(){
        game.tick();
    }



}
