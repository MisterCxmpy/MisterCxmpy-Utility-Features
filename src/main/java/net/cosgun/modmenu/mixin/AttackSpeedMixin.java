package net.cosgun.modmenu.mixin;

import net.cosgun.modmenu.ModMenu;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class AttackSpeedMixin {

    @Inject( method = "getAttackCooldownProgressPerTick", at = @At("HEAD"), cancellable = true)
    public void getAttackCooldownProgressPerTick(CallbackInfoReturnable<Float> info) {
        if (ModMenu.noAttackCooldownEnabled) {
            info.setReturnValue(0.0f);
        }
    }


}