package bb.mods.bbbc;

import bb.mods.bbbc.world.block.block;
import bb.mods.bbbc.world.lib.Reference;
import bb.mods.bbbc.world.reciepe.crafting;
import bb.mods.bbbc.world.reciepe.smelting;
import bb.mods.bbbc.world.gen.BBWorldGen;
import bb.mods.bbbc.world.common.CommonProxy;
import bb.mods.bbbc.world.config.ConfigHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(channels = { Reference.MOD_CHANNEL }, clientSideRequired = true, serverSideRequired = false, packetHandler = bb.mods.bbbc.world.common.network.PacketHandler.class)
public class BBBlockCraftWorld {

	// Gen Definition

	public static bb.mods.bbbc.world.gen.BBWorldGen worldGen = new BBWorldGen();

	@Instance(Reference.MOD_ID)
	public static BBBlockCraftWorld instance;

	@SidedProxy(clientSide = "bb.mods.bbbc.world.common.ClientProxy", serverSide = "bb.mods.bbbc.world.common.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		ConfigHandler.init(event.getSuggestedConfigurationFile());

		proxy.initSounds();
		proxy.initRenderers();

		block.signBlockID();
		block.Blockreg();

	}

	@EventHandler
	public void init(FMLInitializationEvent evtent) {

		smelting.SmeltingRecipe();
		crafting.Recipe();
		crafting.ShapelessRecipe();

		GameRegistry.registerWorldGenerator(worldGen);
		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {

	}

}