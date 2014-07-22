package bb.mods.bbbc.world.common.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.world.World;

/**
 * Created by Modding on 22.07.2014.
 */
public interface IProxy
{
	public void registerRenderInformation();
	public void registerTileEntitySpecialRender(/* PLACEHOLDER */ );
	public Object getClientGuiElement( int ID, EntityPlayer player, World world, int x, int y, int z );
	public Object getServerGuiElement( int ID, EntityPlayer player, World world, int x, int y, int z );
	public World getClientWorld();
	public void initSounds();
	public void initRenderer();
	public EntityPlayer getPlayerFromNetHandler( INetHandler handler );
}
