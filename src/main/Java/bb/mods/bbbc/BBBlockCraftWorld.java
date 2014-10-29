package bb.mods.bbbc;

import bb.mods.bbbc.core.BBBCMod;
import bb.mods.bbbc.world.block.block;
import bb.mods.bbbc.world.references.Reference;
import bb.mods.bbbc.world.reciepe.crafting;
import bb.mods.bbbc.world.reciepe.smelting;
import bb.mods.bbbc.world.gen.BBWorldGen;
import bb.mods.bbbc.world.common.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class BBBlockCraftWorld extends BBBCMod{
	
	// Gen Definition

	public static final bb.mods.bbbc.world.gen.BBWorldGen worldGen = new BBWorldGen();

	@Instance(Reference.MOD_ID)
	public static BBBlockCraftWorld instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		CommonProxy.proxy.initSounds();
		CommonProxy.proxy.initRenderer();

		block.signBlockID();
		block.Blockreg();

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		smelting.SmeltingRecipe();
		crafting.Recipe();
		crafting.ShapelessRecipe();

		GameRegistry.registerWorldGenerator(worldGen,12);
		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {

	}

}