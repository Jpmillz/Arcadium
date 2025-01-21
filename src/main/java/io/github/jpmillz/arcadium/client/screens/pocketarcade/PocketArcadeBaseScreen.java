package io.github.jpmillz.arcadium.client.screens.pocketarcade;

import io.github.jpmillz.arcadium.Arcadium;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class PocketArcadeBaseScreen extends Screen {

    private int imageHeight = 225;
    private int imageWidth = 182;
    protected int leftPos;
    protected int rightPos;
    private float scaleFactor;
    private float maxScale;

    private static final ResourceLocation GAMEPAD_GUI = ResourceLocation.fromNamespaceAndPath(Arcadium.MODID, "textures/screens/gamepadgui.png");

    public PocketArcadeBaseScreen() {
        super(Component.literal("Pocket Arcade"));
    }

    @Override
    protected void init() {
        super.init();
        this.maxScale = 4;
        this.scaleFactor = 1;

        this.leftPos = (width - imageWidth) / 2;
        this.rightPos = (height - imageHeight) / 2;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        zoomIn(guiGraphics, partialTick);
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(width / 2 - ((imageWidth * scaleFactor) /2), height / 2 - ((imageHeight * scaleFactor) /2) + 140, 0);
        guiGraphics.pose().scale(scaleFactor, scaleFactor,0);
        guiGraphics.blit(RenderType::guiTextured, GAMEPAD_GUI, 0, 0, 0, 0, imageWidth, imageHeight,
                256, 256);
        guiGraphics.pose().popPose();
    }

    public void zoomIn(GuiGraphics graphics, float partialTicks){
        if (this.scaleFactor < maxScale){
            scaleFactor += .12;
        }
    }


    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
