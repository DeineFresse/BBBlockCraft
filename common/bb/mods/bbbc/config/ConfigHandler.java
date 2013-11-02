package bb.mods.bbbc.config;

import java.io.File;

import bb.mods.bbbc.lib.DefaultIDs;
import bb.mods.bbbc.lib.LoadedIDs;
import bb.mods.bbbc.lib.Reference;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {

	public static void init(File file) {
		Configuration config = new Configuration(file);

		config.load();
		// Example useless
		int test = config.get("useless stuff", "example", 5).getInt();
		String test2 = config.get("useless stuff", "Some text", "Default text")
				.getString();

		// Item ID´s
		LoadedIDs.Item_MyFirstItem = config.getItem("My First Item",
				DefaultIDs.ITEM_MYFIRSTITEM).getInt();
		LoadedIDs.Item_NineBrickStairItem = config.getItem("NBSI",
				DefaultIDs.ITEM_NINEBRICKSTAIRITEM).getInt();
		LoadedIDs.Item_BookWallItem = config.getItem("BWI",
				DefaultIDs.ITEM_BOOKWALLITEM).getInt();
		LoadedIDs.Item_SwordUp = config.getItem("BWI", DefaultIDs.ITEM_SWORDUP)
				.getInt();

		// Block ID´s
		LoadedIDs.Block_BlockOreOne = config.getBlock("BlockOreOne",
				DefaultIDs.BLOCK_BLOCKOREONE).getInt();
		LoadedIDs.Block_TestBlock = config.getBlock("TestBlock",
				DefaultIDs.BLOCK_TESTBLOCK).getInt();
		LoadedIDs.Block_cloudore = config.getBlock("cloudore",
				DefaultIDs.BLOCK_CLOUDORE).getInt();
		LoadedIDs.Block_CloudWhite = config.getBlock("CloudWhite",
				DefaultIDs.BLOCK_CLOUDWHITE).getInt();
		LoadedIDs.Block_Dark_Stone = config.getBlock("Dark_Stone",
				DefaultIDs.BLOCK_DARK_STONE).getInt();
		LoadedIDs.Block_Faceblock = config.getBlock("Faceblock",
				DefaultIDs.BLOCK_FACEBLOCK).getInt();
		LoadedIDs.Block_BigBlock = config.getBlock("BigBlock",
				DefaultIDs.BLOCK_BIGBLOCK).getInt();		
		LoadedIDs.Block_ConnectedGlass = config.getBlock("ConnectedGlass",
				DefaultIDs.BLOCK_CONNECTEDGLASS).getInt();
		LoadedIDs.Block_FirstMachine = config.getBlock("CFirstMachine",
				DefaultIDs.BLOCK_FIRSTMACHINE).getInt();


		config.save();

		System.out.println(Reference.CHATPREFIX + test + ":" + test2);

	}

}
