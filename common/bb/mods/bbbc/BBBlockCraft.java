package bb.mods.bbbc;

import bb.mods.bbbc.block.block;
import bb.mods.bbbc.item.item;
import bb.mods.bbbc.lib.Reference;
import bb.mods.bbbc.reciepe.crafting;
import bb.mods.bbbc.reciepe.smelting;
import bb.mods.bbbc.stats.Achievements;
import bb.mods.bbbc.world.gen.BBWorldGen;
import bb.mods.bbbc.common.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(channels = { "BBBlockCraft_alt" }, clientSideRequired = true, serverSideRequired = false, packetHandler = bb.mods.bbbc.common.network.PacketHandler.class)
public class BBBlockCraft {
	static boolean settingdebug = Reference.DEBUGMODE;

	// New Creative Tab

	// Gen Definition

	public static bb.mods.bbbc.world.gen.BBWorldGen worldGen = new BBWorldGen();

	
	public static BBBlockCraft instance;

	@SidedProxy(clientSide = "bb.mods.bbbc.common.ClientProxy", serverSide = "bb.mods.bbbc.common.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		block.signBlockID();
		block.Blockreg();
		block.Blockname();
		item.signItemID();
		item.Itemname();
	}

	@EventHandler
	public void init(FMLInitializationEvent evtent) {

		Achievements.addAchievementLocalizations();
		Achievements.addAchievementPage();

		smelting.SmeltingRecipe();
		crafting.Recipe();
		crafting.ShapelessRecipe();

		GameRegistry.registerWorldGenerator(worldGen);

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {

	}


}
