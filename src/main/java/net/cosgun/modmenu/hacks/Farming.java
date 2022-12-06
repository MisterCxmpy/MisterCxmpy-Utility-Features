package net.cosgun.modmenu.hacks;

import net.cosgun.modmenu.ModMenu;
import net.minecraft.block.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Farming {

    public static final Block REED_BLOCK = Blocks.SUGAR_CANE;
    public static final Block NETHER_WART = Blocks.NETHER_WART;
    public static final Block BERRY = Blocks.SWEET_BERRY_BUSH;
    public static final Block BAMBOO = Blocks.BAMBOO;
    public static final Block KELP = Blocks.KELP;
    public static final Block KELP_PLANT = Blocks.KELP_PLANT;

    private ClientPlayerEntity p;

    public void tick(MinecraftClient client) {
        if (client.player != null && ModMenu.autoFarmingEnabled) {
            for (int y = -1; y <= 0; y++) {
                for (int x = -2; x <= 2; x++) {
                    for (int z = -2; z <= 2; z++) {
                        tryHarvest(client, client.player.getBlockPos().add(-x, -y, -z));
                        tryPlant(client, client.player.getBlockPos().add(x, y, z));
                    }
                }
            }
        }
    }

    public void tryPlant(MinecraftClient client, BlockPos pos) {
        BlockState blockState = client.world.getBlockState(pos);
        if (blockState.getBlock() instanceof FarmlandBlock) {
            BlockState blockStateUp = client.world.getBlockState(pos.up());
            if (blockStateUp.getBlock() instanceof AirBlock) {
                if (tryUseSeed(client, pos, Hand.MAIN_HAND) || tryUseSeed(client, pos, Hand.OFF_HAND)){

                }
            }
        }
    }

    public void tryHarvest(MinecraftClient client, BlockPos pos) {
        BlockState state = client.player.getEntityWorld().getBlockState(pos);
        Block block = state.getBlock();
        if (isCropMature(client.player.getEntityWorld(), pos, state, block)) {
            if (block == Blocks.SWEET_BERRY_BUSH) {
                Vec3d blockPos = new Vec3d(pos.getX(), pos.getY(), pos.getZ());
                BlockHitResult blockHitResult = new BlockHitResult(blockPos, Direction.UP, pos, false);
                client.interactionManager.interactBlock(client.player, Hand.MAIN_HAND, blockHitResult);
            } else {
                client.interactionManager.attackBlock(pos, Direction.UP);
            }
            return;
        }
    }

    public boolean tryUseSeed(MinecraftClient client, BlockPos pos, Hand hand) {
        Item item = client.player.getStackInHand(hand).getItem();
        if (item == Items.WHEAT_SEEDS || item == Items.BEETROOT_SEEDS || item == Items.POTATO || item == Items.CARROT || item == Items.MELON_SEEDS || item == Items.PUMPKIN_SEEDS) {
            Vec3d blockPos = new Vec3d(pos.getX(), pos.getY(), pos.getZ());
            BlockHitResult hit = new BlockHitResult(blockPos, Direction.UP, pos, false);
            client.interactionManager.interactBlock(client.player, hand, hit);
            return true;
        }
        return false;
    }

    public static boolean isCropMature(World w, BlockPos pos, BlockState stat, Block b) {
        if (b instanceof CropBlock) {
            return ((CropBlock) b).isMature(stat);
        } else if (b == BERRY) {
            return stat.get(SweetBerryBushBlock.AGE) == 3;
        } else if (b == NETHER_WART) {
            if (b instanceof NetherWartBlock)
                return stat.get(NetherWartBlock.AGE) >= 3;
            return false;
        } else if (b == REED_BLOCK || b == BAMBOO || (b == KELP || b == KELP_PLANT)) {
            Block blockDown = w.getBlockState(pos.down()).getBlock();
            Block blockDown2 = w.getBlockState(pos.down(2)).getBlock();
            return (blockDown == REED_BLOCK && blockDown2 != REED_BLOCK) ||
                    (blockDown == BAMBOO && blockDown2 != BAMBOO) ||
                    (blockDown == KELP_PLANT && blockDown2 != KELP_PLANT);
        }
        return false;
    }


}
