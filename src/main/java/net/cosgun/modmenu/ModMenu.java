package net.cosgun.modmenu;

import net.cosgun.modmenu.config.XRay;
import net.cosgun.modmenu.hacks.BoatFlying;
import net.cosgun.modmenu.hacks.AutoFishing;
import net.cosgun.modmenu.hacks.Farming;
import net.cosgun.modmenu.hacks.Flying;
import net.cosgun.modmenu.interfaces.ISimpleOption;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.SimpleOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModMenu implements ModInitializer {

	static ModMenu instance;

	public MinecraftClient client;

	public AutoFishing autoFishing;
	public Flying flying;
	public Farming farming;
	public BoatFlying boatFlying;
	public XRay xRay;

	public static final String MOD_ID = "modmenu";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static boolean autoFishingEnabled;
	public static boolean flyingEnabled;
	public static boolean autoFarmingEnabled;
	public static boolean boatFlyingEnabled;
	public static boolean xRayEnabled;
	public static boolean noFallEnabled;
	public static boolean instaMineEnabled;

	private double defaultGamma;
	private ISimpleOption<Double> gammaOption2;

	@Override
	public void onInitialize() {
		instance = this;
		autoFishing = new AutoFishing();
		flying = new Flying();
		farming = new Farming();
		boatFlying = new BoatFlying();
		xRay = new XRay();

		ClientTickEvents.END_CLIENT_TICK.register(farming::tick);
		ClientTickEvents.END_CLIENT_TICK.register(boatFlying::tick);
		ClientTickEvents.END_CLIENT_TICK.register(this::tick);

		client = MinecraftClient.getInstance();
	}

	public void tick(MinecraftClient client) {
		if (defaultGamma == 0) {
			defaultGamma = client.options.getGamma().getValue();
			SimpleOption<Double> gammaOption = client.options.getGamma();

			gammaOption2 = (ISimpleOption<Double>)(Object)gammaOption;
		}

		if (xRayEnabled){
			gammaOption2.forceSetValue(1000.0);
		} else {
			gammaOption2.forceSetValue(defaultGamma);
		}
	}

	public static ModMenu getInstance() {
		return instance;
	}

}
