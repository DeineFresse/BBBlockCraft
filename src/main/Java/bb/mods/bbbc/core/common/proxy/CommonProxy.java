package bb.mods.bbbc.core.common.proxy;

import cpw.mods.fml.common.SidedProxy;

public abstract class CommonProxy implements IProxy {

	@SidedProxy(clientSide = "bb.mods.bbbc.core.common.proxy.ClientProxy", serverSide = "bb.mods.bbbc.core.common.proxy.ServerProxy")
	public static IProxy proxy;
}
