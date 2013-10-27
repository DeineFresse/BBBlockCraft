package bb.mods.bbbc.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import bb.mods.bbbc.itemblock.BigBlockItem;
import bb.mods.bbbc.itemblock.CloudWhiteItem;
import bb.mods.bbbc.lib.Block_Names;
import bb.mods.bbbc.lib.LoadedIDs;
import net.minecraft.block.Block;

public class block {

	// Block Definitions
	public static Block BlockOreOne;
	public static Block TestBlock;
	public static Block cloudore;
	public static Block CloudWhite;
	public static Block Dark_Stone;
	public static Block Faceblock;
	public static Block BigBlock;
	public static Block ConnectedGlass;

	public static void signBlockID() {
		BlockOreOne = new BlockOreOne(LoadedIDs.Block_BlockOreOne);
		TestBlock = new TestBlock(LoadedIDs.Block_TestBlock);
		cloudore = new cloudore(LoadedIDs.Block_cloudore);
		CloudWhite = new CloudWhite(LoadedIDs.Block_CloudWhite);
		Dark_Stone = new Dark_Stone(LoadedIDs.Block_Dark_Stone);
		Faceblock = new Faceblock(LoadedIDs.Block_Faceblock);
		BigBlock = new BigBlock(LoadedIDs.Block_BigBlock);
		ConnectedGlass = new ConnectedGlass(LoadedIDs.Block_ConnectedGlass);
	}

	public static void Blockreg() {

		// Register Blocks

		GameRegistry.registerBlock(BlockOreOne, "BlockOreOne");
		GameRegistry.registerBlock(Dark_Stone, "Dark_Stone");
		GameRegistry.registerBlock(TestBlock, "TestBlock");
		GameRegistry.registerBlock(cloudore, "Cloud_Ore");
		GameRegistry.registerBlock(CloudWhite, CloudWhiteItem.class, "Cloud");
		GameRegistry.registerBlock(Faceblock, "Faceblock(Fakeblock)");
		GameRegistry.registerBlock(BigBlock, BigBlockItem.class, "BigBlock");
		GameRegistry.registerBlock(ConnectedGlass, "ConnectedGlass");

	}

	public static void Blockname() {
		LanguageRegistry.instance().addNameForObject(BlockOreOne, "en_US",
				Block_Names.BLOCKOREONE);
		LanguageRegistry.instance().addNameForObject(TestBlock, "en_US",
				Block_Names.TESTBLOCK);
		LanguageRegistry.instance().addNameForObject(cloudore, "en_US",
				Block_Names.CLOUDORE);
		LanguageRegistry.instance().addNameForObject(CloudWhite, "en_US",
				Block_Names.CLOUDWHITE);
		LanguageRegistry.instance().addNameForObject(Dark_Stone, "en_US",
				Block_Names.DARKSTONE);
		LanguageRegistry.instance().addNameForObject(ConnectedGlass, "en_US",
				Block_Names.CONNECTEDGLASS);
	}

}
