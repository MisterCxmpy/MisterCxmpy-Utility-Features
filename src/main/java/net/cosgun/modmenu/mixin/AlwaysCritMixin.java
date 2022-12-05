package net.cosgun.modmenu.mixin;

import net.cosgun.modmenu.ModMenu;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class AlwaysCritMixin {

    @ModifyVariable( method = "attack", at = @At("STORE"), name = "bl3")
    public boolean attack(boolean bl3, Entity target) {
        if (ModMenu.alwaysCritEnabled) {
            return true;
        }
        return bl3;
    }


}
