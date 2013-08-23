package bb.mods.bbbc.common;

import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.FMLClientHandler;

@SuppressWarnings("unused")
public class ClientProxy extends CommonProxy
{

	@Override
	public void registerRenderInformation()
	{
	
		//MinecraftForgeClient.preloadTexture("recources/Pic/BBBlockCraftBlocks");
		//MinecraftForgeClient.preloadTexture("/bb/Pic/BBBlockCraftItems.png");
		
	}
	
	@Override public void registerTileEntitySpecialRender(/*Placeholder*/)
	{
		
	}
	
	@Override
	public World getClientWorld()
	{
		return FMLClientHandler.instance().getClient().theWorld;
	}
}