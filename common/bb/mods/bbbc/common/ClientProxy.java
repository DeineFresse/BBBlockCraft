package bb.mods.bbbc.common;

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
}