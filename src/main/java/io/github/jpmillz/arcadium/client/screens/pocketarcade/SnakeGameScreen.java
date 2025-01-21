package io.github.jpmillz.arcadium.client.screens.pocketarcade;

import net.minecraft.client.gui.GuiGraphics;

import java.awt.*;

public class SnakeGameScreen extends PocketArcadeBaseScreen {

    private int gameHeight = 200;
    private int gameWidth = 200;

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        //guiGraphics.fill(this.leftPos, rightPos, leftPos + gameHeight, rightPos + gameHeight, Color.white.getRGB());
    }
}
