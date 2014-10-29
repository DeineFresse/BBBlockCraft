package bb.mods.bbbc;

import bb.mods.bbbc.core.BBBCMod;
import bb.mods.bbbc.transportation.references.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by BB20101997 on 14.08.2014.
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class BBBlockCraftTransportation extends BBBCMod {

    @Mod.Instance(Reference.MOD_ID)
    public static BBBlockCraftTransportation instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {}

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {}

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent evt) {}
}
