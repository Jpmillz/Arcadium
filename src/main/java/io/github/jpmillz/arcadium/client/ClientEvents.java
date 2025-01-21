package io.github.jpmillz.arcadium.client;

import io.github.jpmillz.arcadium.Arcadium;
import io.github.jpmillz.arcadium.client.screens.pocketarcade.SnakeGameScreen;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class ClientEvents {

    @SubscribeEvent
    public void clickEvent(PlayerInteractEvent.RightClickEmpty event){
        if (event.getEntity().isShiftKeyDown()) {
            Minecraft.getInstance().setScreen(new SnakeGameScreen());
        }
    }
}
