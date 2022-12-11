package net.cosgun.modmenu.gui;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.screen.OpenToLanScreen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.resource.language.I18n;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RemoveLanCheating implements ClientModInitializer {

    private static boolean widgetHasKey(ClickableWidget widget, String key) {
        return widget.getMessage().getString().contains(I18n.translate(key));
    }

    private final Logger logger = LogManager.getLogger();

    @Override
    public void onInitializeClient() {
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if (screen instanceof OpenToLanScreen) {
                logger.info(Screens.getButtons(screen).stream()
                        .map(widget -> widget.getMessage().getString())
                        .collect(Collectors.toList()));
                Screens.getButtons(screen).removeIf(widget -> widgetHasKey(widget, "selectWorld.allowCommands"));

                try {
                    ClickableWidget gameModeButton = Screens.getButtons(screen)
                            .stream()
                            .filter(widget -> widgetHasKey(widget, "selectWorld.gameMode"))
                            .findFirst().orElseThrow();
                    gameModeButton.setX(screen.width / 2 - 75);
                } catch (NoSuchElementException e) {
                    logger.error("WTF!?", e);
                }
            }
        });
    }
}
