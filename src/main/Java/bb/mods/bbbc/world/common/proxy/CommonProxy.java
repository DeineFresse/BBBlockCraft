package bb.mods.bbbc.world.common.proxy;

import cpw.mods.fml.common.SidedProxy;

public abstract class CommonProxy implements IProxy {

	@SidedProxy(clientSide = "bb.mods.bbbc.world.common.proxy.ClientProxy", serverSide = "bb.mods.bbbc.world.common.proxy.ServerProxy")
	public static bb.mods.bbbc.world.common.proxy.IProxy proxy;

}
