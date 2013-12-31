package bb.mods.bbbc.machines.config;

import java.io.File;

import bb.mods.bbbc.machines.lib.DefaultIDs;
import bb.mods.bbbc.machines.lib.LoadedIDs;
import net.minecraftforge.common.Configuration;

public class ConfigHandler {
	
	/**
	 * @param file is the config file to use
	 * **/
	public static void init(File file) {
		Configuration config = new Configuration(file);

		config.load();
		LoadedIDs.Item_LayoutCard = config.getItem("LayoutCard", DefaultIDs.ITEM_LAYOUTCARD)
				.getInt();

		LoadedIDs.Block_FirstMachine = config.getBlock("FirstMachine",
				DefaultIDs.BLOCK_FIRSTMACHINE).getInt();
		LoadedIDs.Block_Housemachine = config.getBlock("HouseMachine",
				DefaultIDs.BLOCK_HOUSEMACHINE).getInt();


		config.save();
	}

}
