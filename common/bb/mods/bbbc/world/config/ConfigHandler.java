package bb.mods.bbbc.world.config;

import java.io.File;

import bb.mods.bbbc.world.lib.DefaultIDs;
import bb.mods.bbbc.world.lib.LoadedIDs;
import net.minecraftforge.common.Configuration;

public class ConfigHandler {
	
	/**
	 * @param file is the config file to use
	 * **/
	public static void init(File file) {
		Configuration config = new Configuration(file);

		config.load();
		
		// Block ID´s
		LoadedIDs.Block_BlockOreOne = config.getBlock("BlockOreOne",
				DefaultIDs.BLOCK_BLOCKOREONE).getInt();
		LoadedIDs.Block_cloudore = config.getBlock("cloudore",
				DefaultIDs.BLOCK_CLOUDORE).getInt();
		LoadedIDs.Block_CloudWhite = config.getBlock("CloudWhite",
				DefaultIDs.BLOCK_CLOUDWHITE).getInt();
		LoadedIDs.Block_Dark_Stone = config.getBlock("Dark_Stone",
				DefaultIDs.BLOCK_DARK_STONE).getInt();

		config.save();
	}

}
