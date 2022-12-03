package net.cosgun.modmenu;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.cosgun.modmenu.AutoFishing;

public class ModMenu implements ModInitializer {

	static ModMenu instance;

	public AutoFishing autoFishing;
	public Flying flying;
	public Farming farming;

	public static final String MOD_ID = "modmenu";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static boolean autoFishingEnabled;
	public static boolean flyingEnabled;
	public static boolean autoFarmingEnabled;

	@Override
	public void onInitialize() {
		instance = this;
		autoFishing = new AutoFishing();
		flying = new Flying();
		farming = new Farming();

		ClientTickEvents.END_CLIENT_TICK.register(farming::tick);
	}

	public static ModMenu getInstance() {
		return instance;
	}

}
