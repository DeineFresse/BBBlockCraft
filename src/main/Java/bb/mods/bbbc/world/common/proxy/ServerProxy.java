package bb.mods.bbbc.world.common.proxy;

import cpw.mods.fml.common.SidedProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.world.World;

public class ServerProxy implements IProxy{

	@SidedProxy(clientSide = "bb.mods.bbbc.world.common.proxy.ClientProxy", serverSide = "bb.mods.bbbc.world.common.proxy.CommonProxy")
	public static ServerProxy proxy;


	public void registerRenderInformation()
	{

	}

	public void registerTileEntitySpecialRender(/* PLACEHOLDER */ )
	{

	}

	@Override
	public Object getClientGuiElement( int ID, EntityPlayer player, World world, int x, int y, int z )
	{
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return null;
	}

	public World getClientWorld() {
		return null;
	}

	public void initSounds() {

	}

	public void initRenderer() {

	}

	@Override
	public EntityPlayer getPlayerFromNetHandler (INetHandler handler) {
		if (handler instanceof NetHandlerPlayServer ) {
			return ((NetHandlerPlayServer) handler).playerEntity;
		} else {
			return null;
		}
	}

}
