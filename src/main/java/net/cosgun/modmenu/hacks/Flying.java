package net.cosgun.modmenu.hacks;

import net.cosgun.modmenu.ModMenu;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Hand;

public class Flying{

    public void EnableFlying(MinecraftClient client) {
        client.player.getAbilities().allowFlying = ModMenu.flyingEnabled;
    }

}
