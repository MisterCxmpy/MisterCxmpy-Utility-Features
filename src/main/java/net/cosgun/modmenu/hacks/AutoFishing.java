package net.cosgun.modmenu.hacks;

import net.cosgun.modmenu.ModMenu;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Hand;

public class AutoFishing {

    public int recastRod = -1;

    public void tick(MinecraftClient client) {
        if (!ModMenu.autoFishingEnabled) return;

        if (recastRod > 0) {
            recastRod--;
        }
        if (recastRod == 0 && ModMenu.autoFishingEnabled) {
            client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
            recastRod = -1;
        }
    }

    public void setRecastRod(int countdown) {
        recastRod = countdown;
        ClientTickEvents.END_CLIENT_TICK.register(this::tick);
    }

}
