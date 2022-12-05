package net.cosgun.modmenu.mixin;

import net.cosgun.modmenu.ModMenu;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class NormalBreakSpeedFlyingMixin {

    @Shadow private PlayerInventory inventory;

    @Inject( method = "getBlockBreakingSpeed", at = @At("HEAD"), cancellable = true)
    public void getBlockBreakingSpeed(BlockState block, CallbackInfoReturnable info) {
        if (ModMenu.flyingEnabled || ModMenu.flyBreakSpeedEnabled) {
            info.setReturnValue(inventory.getBlockBreakingSpeed(block));
        }

    }


}
