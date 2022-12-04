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
            return Text.literal("Auto Fishing is enabled");
        else
            return Text.literal("Auto Fishing is disabled");
    }

    Text flyingText() {
        if (ModMenu.flyingEnabled)
            return Text.literal("Flying is enabled");
        else
            return Text.literal("Flying is disabled");
    }

    Text autoFarmingText() {
        if (ModMenu.autoFarmingEnabled)
            return Text.literal("Auto Farming is enabled");
        else
            return Text.literal("Auto Farming is disabled");
    }

    Text boatFlyingText() {
        if (ModMenu.boatFlyingEnabled)
            return Text.literal("Boat flying is enabled");
        else
            return Text.literal("Boat flying is disabled");
    }

    Text xRayText() {
        if (ModMenu.xRayEnabled)
            return Text.literal("XRay is enabled");
        else
            return Text.literal("XRay is disabled");
    }

    protected void init() {
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 102, this.height / 4 + 24 + -16, 204, 20, autoFishingText(), (button) -> {
            ModMenu.autoFishingEnabled = !ModMenu.autoFishingEnabled;
            button.setMessage(autoFishingText());
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 102, this.height / 4 + 48 + -16, 204, 20, flyingText(), (button) -> {
            ModMenu.flyingEnabled = !ModMenu.flyingEnabled;
            ModMenu.getInstance().flying.EnableFlying(MinecraftClient.getInstance());
            button.setMessage(flyingText());
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 102, this.height / 4 + 72 + -16, 204, 20, autoFarmingText(), (button) -> {
            ModMenu.autoFarmingEnabled = !ModMenu.autoFarmingEnabled;
            button.setMessage(autoFarmingText());
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 102, this.height / 4 + 96 + -16, 204, 20, boatFlyingText(), (button) -> {
            ModMenu.boatFlyingEnabled = !ModMenu.boatFlyingEnabled;
            button.setMessage(boatFlyingText());
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 102, this.height / 4 + 120 + -16, 204, 20, xRayText(), (button) -> {
            ModMenu.xRayEnabled = !ModMenu.xRayEnabled;
            MinecraftClient.getInstance().worldRenderer.reload();
            button.setMessage(xRayText());
        }));
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 50, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }
}
