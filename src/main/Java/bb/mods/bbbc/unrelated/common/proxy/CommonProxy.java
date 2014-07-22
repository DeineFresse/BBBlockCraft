package bb.mods.bbbc.unrelated.common.proxy;

import cpw.mods.fml.common.SidedProxy;

public abstract class CommonProxy implements IProxy{

	@SidedProxy(clientSide = "bb.mods.bbbc.unrelated.common.proxy.ClientProxy", serverSide = "bb.mods.bbbc.unrelated.common.proxy.ServerProxy")
	public static CommonProxy proxy;

}
