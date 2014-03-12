package bb.mods.bbbc.machines.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {

	@SidedProxy(clientSide = "bb.mods.bbbc.machines.common.ClientProxy", serverSide = "bb.mods.bbbc.machines.common.CommonProxy")
	public static CommonProxy proxy;
	
	public void registerRenderInformation() {

	}

	public void registerTileEntitySpecialRender(/* PLACEHOLDER */) {

	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
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

	public void initRenderers() {

	}
}
