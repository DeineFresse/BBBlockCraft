package bb.mods.bbbc;

import bb.mods.bbbc.machines.block.block;
import bb.mods.bbbc.machines.interfaces.GuiHandler;
import bb.mods.bbbc.machines.item.item;
import bb.mods.bbbc.machines.lib.Reference;
import bb.mods.bbbc.machines.reciepe.crafting;
import bb.mods.bbbc.machines.common.CommonProxy;
import bb.mods.bbbc.machines.config.ConfigHandler;
import bb.mods.bbbc.machines.tileentity.TileEntity;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(channels = { Reference.MOD_CHANNEL }, clientSideRequired = true, serverSideRequired = false, packetHandler = bb.mods.bbbc.machines.common.network.PacketHandler.class)
public class BBBlockCraftMachines {

	@Instance(Reference.MOD_ID)
	public static BBBlockCraftMachines instance;

	@SidedProxy(clientSide = "bb.mods.bbbc.machines.common.ClientProxy", serverSide = "bb.mods.bbbc.machines.common.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		proxy.initSounds();
		proxy.initRenderers();

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
		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {

	}

}