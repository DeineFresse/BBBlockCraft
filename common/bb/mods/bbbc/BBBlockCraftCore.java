package bb.mods.bbbc;

import bb.mods.bbbc.machines.interfaces.GuiHandler;
import bb.mods.bbbc.core.lib.Reference;
import bb.mods.bbbc.core.stats.Achievements;
import bb.mods.bbbc.world.gen.BBWorldGen;
import bb.mods.bbbc.core.common.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(channels = { Reference.MOD_CHANNEL }, clientSideRequired = true, serverSideRequired = false, packetHandler = bb.mods.bbbc.core.common.network.PacketHandler.class)
public class BBBlockCraftCore {

	// Gen Definition

	public static bb.mods.bbbc.world.gen.BBWorldGen worldGen = new BBWorldGen();

	@Instance(Reference.MOD_ID)
	public static BBBlockCraftCore instance;

	@SidedProxy(clientSide = "bb.mods.bbbc.core.common.ClientProxy", serverSide = "bb.mods.bbbc.core.common.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	}

	@EventHandler
	public void init(FMLInitializationEvent evtent) {

		new GuiHandler();
		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {
		Achievements.addAchievementLocalizations();
		Achievements.addAchievementPage();
	}

}