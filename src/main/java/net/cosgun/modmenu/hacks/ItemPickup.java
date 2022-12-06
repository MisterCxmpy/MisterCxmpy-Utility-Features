package net.cosgun.modmenu.hacks;

import net.cosgun.modmenu.ModMenu;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

import java.util.List;

public class ItemPickup implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ServerTickEvents.START_SERVER_TICK.register(minecraftServer -> {
            tick(minecraftServer);
        });
    }

    public void tick(MinecraftServer server) {
        if (MinecraftClient.getInstance().player != null && ModMenu.itemPickupEnabled) {
            List<ServerPlayerEntity> playerList = server.getPlayerManager().getPlayerList();
            for (ServerPlayerEntity player : playerList) {
                    Iterable<ServerWorld> worlds = player.getServer().getWorlds();
                    for (World world : worlds) {
                        List<ItemEntity> entityItems = player.getServer().getWorld(world.getRegistryKey()).getEntitiesByClass(ItemEntity.class, player.getBoundingBox().expand(16.0D), EntityPredicates.VALID_ENTITY);
                        for (ItemEntity entityItemNearby : entityItems) {
                            if (!player.isSneaking()) {
                                entityItemNearby.onPlayerCollision(player);
                            }
                        }
                    }

                }
        }
    }

}
