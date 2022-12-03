package net.cosgun.modmenu;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Hand;

public class Flying{

    public void EnableFlying(MinecraftClient client) {
        client.player.getAbilities().allowFlying = ModMenu.flyingEnabled;
    }

}
