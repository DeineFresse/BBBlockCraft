
package bb.mods.bbbc;

import bb.mods.bbbc.machines.interfaces.GuiHandler;
import bb.mods.bbbc.core.BBBCMod;
import bb.mods.bbbc.core.lib.Reference;
import bb.mods.bbbc.core.tileentity.TileEntity;
import bb.mods.bbbc.world.gen.BBWorldGen;
import bb.mods.bbbc.core.common.proxy.CommonProxy;
import bb.mods.bbbc.core.common.network.PacketHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class BBBlockCraftCore extends BBBCMod{

	// Gen Definition

	public static bb.mods.bbbc.world.gen.BBWorldGen worldGen = new BBWorldGen();

	@Instance(Reference.MOD_ID)
	public static BBBlockCraftCore instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		CommonProxy.proxy.registerTileEntitySpecialRender();
		TileEntity.regTileEntity();
	}

	@EventHandler
	public void init(FMLInitializationEvent evtent) {
		
		channels = NetworkRegistry.INSTANCE.newChannel(Reference.MOD_CHANNEL,new PacketHandler());
		new GuiHandler();
		
		
		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {
	}

}