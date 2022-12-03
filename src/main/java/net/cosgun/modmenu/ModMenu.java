package net.cosgun.modmenu;

import net.cosgun.modmenu.hacks.BoatFlying;
import net.cosgun.modmenu.hacks.AutoFishing;
import net.cosgun.modmenu.hacks.Farming;
import net.cosgun.modmenu.hacks.Flying;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModMenu implements ModInitializer {

	static ModMenu instance;

	public AutoFishing autoFishing;
	public Flying flying;
	public Farming farming;
	public BoatFlying boatFlying;

	public static final String MOD_ID = "modmenu";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static boolean autoFishingEnabled;
	public static boolean flyingEnabled;
	public static boolean autoFarmingEnabled;
	public static boolean boatFlyingEnabled;

	@Override
	public void onInitialize() {
		instance = this;
		autoFishing = new AutoFishing();
		flying = new Flying();
		farming = new Farming();
		boatFlying = new BoatFlying();

		ClientTickEvents.END_CLIENT_TICK.register(farming::tick);
		ClientTickEvents.END_CLIENT_TICK.register(boatFlying::tick);
	}

	public static ModMenu getInstance() {
		return instance;
	}

}
