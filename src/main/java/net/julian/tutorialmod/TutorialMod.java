package net.julian.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.julian.tutorialmod.block.ModBlocks;
import net.julian.tutorialmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	// --- Set MOD_ID to mod name
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// --- Initialize blocks and items on startup
	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}