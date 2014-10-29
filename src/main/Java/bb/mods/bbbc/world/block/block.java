package bb.mods.bbbc.world.block;

import cpw.mods.fml.common.registry.GameRegistry;
import bb.mods.bbbc.world.item.CloudWhiteItem;
import net.minecraft.block.Block;

public class block {

	// Block Definitions
	public static Block BlockOreOne;
	public static Block cloudore;
	public static Block CloudWhite;
	public static Block Dark_Stone;

	public static void signBlockID() {
		BlockOreOne = new CopperOre();
		cloudore = new cloudore();
		CloudWhite = new CloudWhite();
		Dark_Stone = new Dark_Stone();
	}

	public static void Blockreg() {

		// Register Blocks

		GameRegistry.registerBlock(BlockOreOne, "CopperOre");
		GameRegistry.registerBlock(Dark_Stone, "Dark_Stone");
		GameRegistry.registerBlock(cloudore, "Cloud_Ore");
		GameRegistry.registerBlock(CloudWhite, CloudWhiteItem.class, "Cloud");
	}
}