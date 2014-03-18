package bb.mods.bbbc.machines.common;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderInformation() {

	}

	@Override
	public void registerTileEntitySpecialRender(/* Placeholder */) {

	}

	@Override
	public World getClientWorld() {
		return FMLClientHandler.instance().getClient().theWorld;
	}

	@Override
	public void initSounds() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initRenderers() {
		// TODO Auto-generated method stub

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