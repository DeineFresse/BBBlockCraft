package bb.mods.bbbc;

import bb.mods.bbbc.core.BBBCMod;
import bb.mods.bbbc.unrelated.block.block;
import bb.mods.bbbc.unrelated.common.proxy.CommonProxy;
import bb.mods.bbbc.unrelated.item.item;
import bb.mods.bbbc.unrelated.lib.Reference;
import bb.mods.bbbc.unrelated.reciepe.crafting;
import bb.mods.bbbc.unrelated.reciepe.smelting;
import bb.mods.bbbc.unrelated.tileentity.TileEntity;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class BBBlockCraftUnrelated extends BBBCMod{


	@Instance(Reference.MOD_ID)
	public static BBBlockCraftUnrelated instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		CommonProxy.proxy.initSounds();
		CommonProxy.proxy.initRenderers();
		CommonProxy.proxy.registerTileEntitySpecialRender();

		block.signBlockID();
		block.Blockreg();
		
		item.signItemID();
		item.registerItems();
		
		TileEntity.regTileEntity();

	}

	@EventHandler
	public void init(FMLInitializationEvent evtent) {

		smelting.SmeltingRecipe();
		crafting.Recipe();
		crafting.ShapelessRecipe();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {

	}

}