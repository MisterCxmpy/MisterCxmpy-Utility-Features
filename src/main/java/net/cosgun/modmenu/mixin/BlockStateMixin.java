package net.cosgun.modmenu.mixin;

import net.cosgun.modmenu.ModMenu;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(Block.class)
public class BlockStateMixin {

    private static Random rand = new Random();

    @Inject(at = @At("HEAD"), method = "shouldDrawSide", cancellable = true)
    private static void shouldDrawSide(BlockState state, BlockView world, BlockPos pos, Direction side, BlockPos otherPos, CallbackInfoReturnable ci) {
        if (ModMenu.xRayEnabled) {
            ci.setReturnValue(ModMenu.getInstance().xRay.showBlock(state));
        }
    }

}
