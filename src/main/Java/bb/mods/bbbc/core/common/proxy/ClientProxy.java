package bb.mods.bbbc.core.common.proxy;

import bb.mods.bbbc.core.render.ConnectedRenderer;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy
{

	public static int connectedRender;
	
	@Override
	public void registerRenderInformation() {

	}

	@Override
	public Object getServerGuiElement( int ID, EntityPlayer player, World world, int x, int y, int z )
	{
		return null;
	}

	@Override
	public Object getClientGuiElement( int ID, EntityPlayer player, World world, int x, int y, int z )
	{
		return null;
	}

	@Override
	public void initRenderer()
	{

	}

	@Override
	public void registerTileEntitySpecialRender(/* Placeholder */) {
		connectedRender = RenderingRegistry.getNextAvailableRenderId();
		ClientRegistry.bindTileEntitySpecialRenderer(
				bb.mods.bbbc.core.tileentity.ConnectedTileEntity.class,
				new ConnectedRenderer());
	
	}

	@Override
	public World getClientWorld() {
		return FMLClientHandler.instance().getClient().theWorld;
	}

	@Override
	public void initSounds() {
	}
	
	@Override
	public EntityPlayer getPlayerFromNetHandler (INetHandler handler) {
		if (handler instanceof NetHandlerPlayServer) {
			return ((NetHandlerPlayServer) handler).playerEntity;
		} else {
			return Minecraft.getMinecraft().thePlayer;
		}
	}
}