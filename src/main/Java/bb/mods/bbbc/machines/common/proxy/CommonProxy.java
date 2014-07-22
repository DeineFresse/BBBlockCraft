package bb.mods.bbbc.machines.common.proxy;

import cpw.mods.fml.common.SidedProxy;

public abstract class CommonProxy implements IProxy {

	@SidedProxy(clientSide = "bb.mods.bbbc.machines.common.proxy.ClientProxy", serverSide = "bb.mods.bbbc.machines.common.proxy.ServerProxy")
	public static CommonProxy proxy;
}
