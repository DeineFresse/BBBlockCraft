package bb.mods.bbbc;

import bb.mods.bbbc.core.BBBCMod;
import bb.mods.bbbc.machines.block.block;
import bb.mods.bbbc.machines.interfaces.GuiHandler;
import bb.mods.bbbc.machines.item.item;
import bb.mods.bbbc.machines.lib.Reference;
import bb.mods.bbbc.machines.reciepe.crafting;
import bb.mods.bbbc.machines.common.CommonProxy;
import bb.mods.bbbc.machines.common.network.PacketHandler;
import bb.mods.bbbc.machines.tileentity.TileEntity;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class BBBlockCraftMachines extends BBBCMod{

	@Instance(Reference.MOD_ID)
	public static BBBlockCraftMachines instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		CommonProxy.proxy.initSounds();
		CommonProxy.proxy.initRenderers();

		block.signBlockID();
		block.Blockreg();

		item.signItemID();
		
		TileEntity.regTileEntity();
	}

	@EventHandler
	public void init(FMLInitializationEvent evtent) {

		crafting.Recipe();
		crafting.ShapelessRecipe();

		new GuiHandler();
		
		channels = NetworkRegistry.INSTANCE.newChannel(Reference.MOD_CHANNEL,new PacketHandler());
		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {

	}

}