package bb.mods.bbbc;

import bb.mods.bbbc.unrelated.block.block;
import bb.mods.bbbc.unrelated.lib.Reference;
import bb.mods.bbbc.unrelated.tileentity.TileEntity;
import bb.mods.bbbc.unrelated.item.item;
import bb.mods.bbbc.unrelated.common.CommonProxy;
import bb.mods.bbbc.unrelated.config.ConfigHandler;
import bb.mods.bbbc.unrelated.reciepe.crafting;
import bb.mods.bbbc.unrelated.reciepe.smelting;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(channels = { Reference.MOD_CHANNEL }, clientSideRequired = true, serverSideRequired = false, packetHandler = bb.mods.bbbc.unrelated.common.network.PacketHandler.class)
public class BBBlockCraftUnrelated {


	@Instance(Reference.MOD_ID)
	public static BBBlockCraftUnrelated instance;

	@SidedProxy(clientSide = "bb.mods.bbbc.unrelated.common.ClientProxy", serverSide = "bb.mods.bbbc.unrelated.common.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		proxy.initSounds();
		proxy.initRenderers();
		proxy.registerTileEntitySpecialRender();

		block.signBlockID();
		block.Blockreg();
		
		item.signItemID();
		
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