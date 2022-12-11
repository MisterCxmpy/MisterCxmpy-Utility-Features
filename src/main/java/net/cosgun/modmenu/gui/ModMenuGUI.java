package net.cosgun.modmenu.gui;

import net.cosgun.modmenu.ModMenu;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class ModMenuGUI extends Screen {

    public ModMenuGUI() {
        super(Text.literal("Mod Menu Settings"));
    }

    Text autoFishingText() {
        if (ModMenu.autoFishingEnabled)
            return Text.literal("Auto Fishing: §2Enabled");
        else
            return Text.literal("Auto Fishing: §cDisabled");
    }

    Text flyingText() {
        if (ModMenu.flyingEnabled)
            return Text.literal("Flying: §2Enabled");
        else
            return Text.literal("Flying: §cDisabled");
    }

    Text autoFarmingText() {
        if (ModMenu.autoFarmingEnabled)
            return Text.literal("Auto Farming: §2Enabled");
        else
            return Text.literal("Auto Farming: §cDisabled");
    }

    Text boatFlyingText() {
        if (ModMenu.boatFlyingEnabled)
            return Text.literal("Boat flying: §2Enabled");
        else
            return Text.literal("Boat flying: §cDisabled");
    }

    Text xRayText() {
        if (ModMenu.xRayEnabled)
            return Text.literal("XRay: §2Enabled");
        else
            return Text.literal("XRay: §cDisabled");
    }

    Text instaMineText() {
        if (ModMenu.instaMineEnabled)
            return Text.literal("Insta Mine: §2Enabled");
        else
            return Text.literal("Insta Mine: §cDisabled");
    }

    Text noFallText() {
        if (ModMenu.noFallEnabled)
            return Text.literal("NoFall: §2Enabled");
        else
            return Text.literal("NoFall: §cDisabled");
    }

    Text flyBreakSpeedText() {
        if (ModMenu.flyBreakSpeedEnabled)
            return Text.literal("Fly Break: §2Enabled");
        else
            return Text.literal("Fly Break: §cDisabled");
    }

    Text alwaysCritText() {
        if (ModMenu.alwaysCritEnabled)
            return Text.literal("Always Crit: §2Enabled");
        else
            return Text.literal("Always Crit: §cDisabled");
    }

    Text noAttackSpeedCooldownText() {
        if (ModMenu.noAttackCooldownEnabled)
            return Text.literal("No Cooldown: §2Enabled");
        else
            return Text.literal("No Cooldown: §cDisabled");
    }

    Text itemPickupText() {
        if (ModMenu.itemPickupEnabled)
            return Text.literal("Item Pickup: §2Enabled");
        else
            return Text.literal("Item Pickup: §cDisabled");
    }

    protected void init() {
        this.addDrawableChild(ButtonWidget.builder(autoFishingText(), (button) -> {
            ModMenu.autoFishingEnabled = !ModMenu.autoFishingEnabled;
            button.setMessage(autoFishingText());
        }).dimensions(this.width / 2 - 132, this.height / 4 + 0 + -16, 132, 20).build());

        this.addDrawableChild(ButtonWidget.builder(autoFarmingText(), (button) -> {
            ModMenu.autoFarmingEnabled = !ModMenu.autoFarmingEnabled;
            button.setMessage(autoFarmingText());
        }).dimensions(this.width / 2 + 4, this.height / 4 + 0 + -16, 132, 20).build());

        this.addDrawableChild(ButtonWidget.builder(flyingText(), (button) -> {
            ModMenu.flyingEnabled = !ModMenu.flyingEnabled;
            ModMenu.getInstance().flying.EnableFlying(MinecraftClient.getInstance());
            button.setMessage(flyingText());
        }).dimensions(this.width / 2 - 132, this.height / 4 + 24 + -16, 132, 20).build());

        this.addDrawableChild(ButtonWidget.builder(boatFlyingText(), (button) -> {
            ModMenu.boatFlyingEnabled = !ModMenu.boatFlyingEnabled;
            button.setMessage(boatFlyingText());
        }).dimensions(this.width / 2 + 4, this.height / 4 + 24 + -16, 132, 20).build());

        this.addDrawableChild(ButtonWidget.builder(xRayText(), (button) -> {
            ModMenu.xRayEnabled = !ModMenu.xRayEnabled;
            MinecraftClient.getInstance().worldRenderer.reload();
            button.setMessage(xRayText());
        }).dimensions(this.width / 2 - 132, this.height / 4 + 48 + -16, 132, 20).build());

        this.addDrawableChild(ButtonWidget.builder(instaMineText(), (button) -> {
            ModMenu.instaMineEnabled = !ModMenu.instaMineEnabled;
            ModMenu.LOGGER.info(String.valueOf(ModMenu.instaMineEnabled));
            button.setMessage(instaMineText());
        }).dimensions(this.width / 2 + 4, this.height / 4 + 48 + -16, 132, 20).build());

        this.addDrawableChild(ButtonWidget.builder(noFallText(), (button) -> {
            ModMenu.noFallEnabled = !ModMenu.noFallEnabled;
            button.setMessage(noFallText());
        }).dimensions(this.width / 2 - 132, this.height / 4 + 72 + -16, 132, 20).build());

        this.addDrawableChild(ButtonWidget.builder(flyBreakSpeedText(), (button) -> {
            ModMenu.flyBreakSpeedEnabled = !ModMenu.flyBreakSpeedEnabled;
            button.setMessage(flyBreakSpeedText());
        }).dimensions(this.width / 2 + 4, this.height / 4 + 72 + -16, 132, 20).build());

        this.addDrawableChild(ButtonWidget.builder(alwaysCritText(), (button) -> {
            ModMenu.alwaysCritEnabled = !ModMenu.alwaysCritEnabled;
            button.setMessage(alwaysCritText());
        }).dimensions(this.width / 2 - 132, this.height / 4 + 96 + -16, 132, 20).build());

        this.addDrawableChild(ButtonWidget.builder(noAttackSpeedCooldownText(), (button) -> {
            ModMenu.noAttackCooldownEnabled = !ModMenu.noAttackCooldownEnabled;
            button.setMessage(noAttackSpeedCooldownText());
        }).dimensions(this.width / 2 + 4, this.height / 4 + 96 + -16, 132, 20).build());

        this.addDrawableChild(ButtonWidget.builder(itemPickupText(), (button) -> {
            ModMenu.itemPickupEnabled = !ModMenu.itemPickupEnabled;
            button.setMessage(itemPickupText());
        }).dimensions(this.width / 2 - 132, this.height / 4 + 120 + -16, 132, 20).build());
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 50, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }
}
