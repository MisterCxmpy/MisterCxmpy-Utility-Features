package net.cosgun.modmenu.config;

import net.cosgun.modmenu.ModMenu;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import java.util.HashSet;

public class XRay {

    private HashSet<String> xrayBlocks = new HashSet();

    public XRay() {
        xrayBlocks.add("Block{minecraft:coal_ore}");
        xrayBlocks.add("Block{minecraft:iron_ore}");
        xrayBlocks.add("Block{minecraft:gold_ore}");
        xrayBlocks.add("Block{minecraft:redstone_ore}");
        xrayBlocks.add("Block{minecraft:diamond_ore}");
        xrayBlocks.add("Block{minecraft:emerald_ore}");
        xrayBlocks.add("Block{minecraft:lapis_ore}");

        xrayBlocks.add("Block{minecraft:deepslate_coal_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_iron_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_gold_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_redstone_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_diamond_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_emerald_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_lapis_ore}");

        xrayBlocks.add("Block{minecraft:chest}");
        xrayBlocks.add("Block{minecraft:mod_spawner}");
        xrayBlocks.add("Block{minecraft:spawner}");
        xrayBlocks.add("Block{minecraft:bookshelf}");
        xrayBlocks.add("Block{minecraft:ancient_debris}");
        xrayBlocks.add("Block{minecraft:nether_gold_ore}");
        xrayBlocks.add("Block{minecraft:nether_quartz_ore}");
        xrayBlocks.add("Block{minecraft:blackstone}");
        xrayBlocks.add("Block{minecraft:glowstone}");
        xrayBlocks.add("Block{minecraft:gold_block}");
        xrayBlocks.add("Block{minecraft:bone_block}");
        xrayBlocks.add("Block{minecraft:obsidian}");
        xrayBlocks.add("Block{minecraft:nether_brick}");
        xrayBlocks.add("Block{minecraft:magma_block}");
        xrayBlocks.add("Block{minecraft:lava}");
        xrayBlocks.add("Block{minecraft:water}");
    }

    public boolean showBlock(Block state) {
        if (xrayBlocks.contains(state.toString())) {
            return true;
        }
        return false;
    }

}
