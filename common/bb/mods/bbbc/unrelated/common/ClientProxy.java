package bb.mods.bbbc.unrelated.common;

import bb.mods.bbbc.unrelated.render.TestRender;
import bb.mods.bbbc.unrelated.tileentity.render.TileEntityRenderTestRenderer;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	public static int  rederPass;
	public static int testRender;
	
	@Override
	public void registerRenderInformation() {

	}

	@Override
	public void registerTileEntitySpecialRender(/* Placeholder */) {
		ClientRegistry.bindTileEntitySpecialRenderer(bb.mods.bbbc.unrelated.tileentity.TileEntityRenderTest.class,
				new TileEntityRenderTestRenderer());
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
		testRender = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new TestRender());
	}
	
}