package net.cosgun.modmenu.hacks;

import net.cosgun.modmenu.ModMenu;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public class BoatFlying {

    private int toggle = 0;
    private double FALL_SPEED = -0.4;

    public void tick(MinecraftClient client) {
        if (client.player != null && client.player.hasVehicle() && ModMenu.boatFlyingEnabled) {
            Entity vehicle = client.player.getVehicle();
            Vec3d velocity = vehicle.getVelocity();
            double motionY = client.options.jumpKey.isPressed() ? 0.5 : 0;
            vehicle.setVelocity(new Vec3d(velocity.x, motionY, velocity.z));
        }
    }
}
