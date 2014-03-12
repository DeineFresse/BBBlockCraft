package bb.mods.bbbc.unrelated.block;

import cpw.mods.fml.common.registry.GameRegistry;
import bb.mods.bbbc.unrelated.item.BigBlockItem;
import net.minecraft.block.Block;

public class block {

	// Block Definitions
	
	public static Block TestBlock;
	public static Block Faceblock;
	public static Block BigBlock;
	public static Block ConnectedGlass;
	public static Block RenderTestBlock;
	

	public static void signBlockID() {
		TestBlock = new TestBlock();
		Faceblock = new Faceblock();
		BigBlock = new BigBlock();
		ConnectedGlass = new ConnectedGlass();
		RenderTestBlock = new RenderTestBlock();;
	}

	public static void Blockreg() {

		// Register Blocks
		GameRegistry.registerBlock(RenderTestBlock,"RenderTestBlock");	
		GameRegistry.registerBlock(TestBlock, "TestBlock");
		GameRegistry.registerBlock(Faceblock, "Faceblock(Fakeblock)");
		GameRegistry.registerBlock(BigBlock, BigBlockItem.class, "BigBlock");
		GameRegistry.registerBlock(ConnectedGlass, "ConnectedGlass");
		
	}
}