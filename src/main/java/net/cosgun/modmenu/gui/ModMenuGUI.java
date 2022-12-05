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

    protected void init() {
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 132, this.height / 4 + -24 + -16, 132, 20, autoFishingText(), (button) -> {
            ModMenu.autoFishingEnabled = !ModMenu.autoFishingEnabled;
            button.setMessage(autoFishingText());
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 + 4, this.height / 4 + -24 + -16, 132, 20, autoFarmingText(), (button) -> {
            ModMenu.autoFarmingEnabled = !ModMenu.autoFarmingEnabled;
            button.setMessage(autoFarmingText());
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 132, this.height / 4 + 0 + -16, 132, 20, flyingText(), (button) -> {
            ModMenu.flyingEnabled = !ModMenu.flyingEnabled;
            ModMenu.getInstance().flying.EnableFlying(MinecraftClient.getInstance());
            button.setMessage(flyingText());
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 + 4, this.height / 4 + 0 + -16, 132, 20, boatFlyingText(), (button) -> {
            ModMenu.boatFlyingEnabled = !ModMenu.boatFlyingEnabled;
            button.setMessage(boatFlyingText());
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 132, this.height / 4 + 24 + -16, 132, 20, xRayText(), (button) -> {
            ModMenu.xRayEnabled = !ModMenu.xRayEnabled;
            MinecraftClient.getInstance().worldRenderer.reload();
            button.setMessage(xRayText());
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 + 4, this.height / 4 + 24 + -16, 132, 20, instaMineText(), (button) -> {
            ModMenu.instaMineEnabled = !ModMenu.instaMineEnabled;
            ModMenu.LOGGER.info(String.valueOf(ModMenu.instaMineEnabled));
            button.setMessage(instaMineText());
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 132, this.height / 4 + 48 + -16, 132, 20, noFallText(), (button) -> {
            ModMenu.noFallEnabled = !ModMenu.noFallEnabled;
            button.setMessage(noFallText());
        }));
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 50, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }
}
