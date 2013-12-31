package bb.mods.bbbc.unrelated.block;

import cpw.mods.fml.common.registry.GameRegistry;
import bb.mods.bbbc.unrelated.lib.LoadedIDs;
import bb.mods.bbbc.unrelated.item.BigBlockItem;
import net.minecraft.block.Block;

public class block {

	// Block Definitions
	
	public static Block TestBlock;
	public static Block Faceblock;
	public static Block BigBlock;
	public static Block ConnectedGlass;
	

	public static void signBlockID() {
		TestBlock = new TestBlock(LoadedIDs.Block_TestBlock);
		Faceblock = new Faceblock(LoadedIDs.Block_Faceblock);
		BigBlock = new BigBlock(LoadedIDs.Block_BigBlock);
		ConnectedGlass = new ConnectedGlass(LoadedIDs.Block_ConnectedGlass);
	}

	public static void Blockreg() {

		// Register Blocks
	
		GameRegistry.registerBlock(TestBlock, "TestBlock");
		GameRegistry.registerBlock(Faceblock, "Faceblock(Fakeblock)");
		GameRegistry.registerBlock(BigBlock, BigBlockItem.class, "BigBlock");
		GameRegistry.registerBlock(ConnectedGlass, "ConnectedGlass");
		
	}
}