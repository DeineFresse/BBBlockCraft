package bb.mods.bbbc.unrelated.config;

import java.io.File;

import bb.mods.bbbc.unrelated.lib.DefaultIDs;
import bb.mods.bbbc.unrelated.lib.LoadedIDs;
import net.minecraftforge.common.Configuration;

public class ConfigHandler {
	
	/**
	 * @param file is the config file to use
	 * **/
	public static void init(File file) {
		Configuration config = new Configuration(file);

		config.load();
		
		// Item ID´s
		LoadedIDs.Item_MyFirstItem = config.getItem("My First Item",
				DefaultIDs.ITEM_MYFIRSTITEM).getInt();
		LoadedIDs.Item_NineBrickStairItem = config.getItem("NBSI",
				DefaultIDs.ITEM_NINEBRICKSTAIRITEM).getInt();
		LoadedIDs.Item_BookWallItem = config.getItem("BWI",
				DefaultIDs.ITEM_BOOKWALLITEM).getInt();
		LoadedIDs.Item_SwordUp = config.getItem("SwordUp", DefaultIDs.ITEM_SWORDUP)
				.getInt();
		
		// Block ID´s
		LoadedIDs.Block_TestBlock = config.getBlock("TestBlock",
				DefaultIDs.BLOCK_TESTBLOCK).getInt();
		LoadedIDs.Block_Faceblock = config.getBlock("Faceblock",
				DefaultIDs.BLOCK_FACEBLOCK).getInt();
		LoadedIDs.Block_BigBlock = config.getBlock("BigBlock",
				DefaultIDs.BLOCK_BIGBLOCK).getInt();		
		LoadedIDs.Block_ConnectedGlass = config.getBlock("ConnectedGlass",
				DefaultIDs.BLOCK_CONNECTEDGLASS).getInt();
		LoadedIDs.Block_RenderTestBlock = config.getBlock("RenderTestBlock",DefaultIDs.BLOCK_RENDERTESTBLOCK).getInt();
		

		config.save();

	}

}
