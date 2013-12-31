package bb.mods.bbbc.world.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {

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
