package net.cosgun.modmenu.mixin;

import net.cosgun.modmenu.ModMenu;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlayerEntity.class)
public abstract class AlwaysCritMixin {

    @ModifyVariable( method = "attack", at = @At("STORE"), ordinal = 2)
    public boolean attack(boolean bl3, Entity target) {
        if (ModMenu.alwaysCritEnabled) {
            return true;
        }
        return bl3;
    }


}
