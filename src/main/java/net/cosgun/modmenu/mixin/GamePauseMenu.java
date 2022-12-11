package net.cosgun.modmenu.mixin;

import net.cosgun.modmenu.gui.ModMenuGUI;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.advancement.AdvancementsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.GridWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(GameMenuScreen.class)
public abstract class GamePauseMenu extends Screen{

    protected GamePauseMenu(Text title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "initWidgets")
    private void addCustomButton(CallbackInfo ci) {
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Mod Menu"), (button) -> {
            this.client.setScreen(new ModMenuGUI());
        }).dimensions(10, 10, 100, 20).build());
    }
}
