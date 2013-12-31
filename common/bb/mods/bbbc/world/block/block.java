package bb.mods.bbbc.world.block;

import cpw.mods.fml.common.registry.GameRegistry;
import bb.mods.bbbc.world.lib.LoadedIDs;
import bb.mods.bbbc.world.block.BlockOreOne;
import bb.mods.bbbc.world.block.CloudWhite;
import bb.mods.bbbc.world.block.Dark_Stone;
import bb.mods.bbbc.world.block.cloudore;
import bb.mods.bbbc.world.item.CloudWhiteItem;
import net.minecraft.block.Block;

public class block {

	// Block Definitions
	public static Block BlockOreOne;
	public static Block cloudore;
	public static Block CloudWhite;
	public static Block Dark_Stone;

	public static void signBlockID() {
		BlockOreOne = new BlockOreOne(LoadedIDs.Block_BlockOreOne);
		cloudore = new cloudore(LoadedIDs.Block_cloudore);
		CloudWhite = new CloudWhite(LoadedIDs.Block_CloudWhite);
		Dark_Stone = new Dark_Stone(LoadedIDs.Block_Dark_Stone);
	}

	public static void Blockreg() {

		// Register Blocks

		GameRegistry.registerBlock(BlockOreOne, "BlockOreOne");
		GameRegistry.registerBlock(Dark_Stone, "Dark_Stone");
		GameRegistry.registerBlock(cloudore, "Cloud_Ore");
		GameRegistry.registerBlock(CloudWhite, CloudWhiteItem.class, "Cloud");
	}
}