package bb.mods.bbbc.core.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class ConnectedTileEntity extends TileEntity implements
		IConnectetTileEntity {
	
	private ResourceLocation re;
	
	public ConnectedTileEntity(ResourceLocation res){
		re = res;
	}

	@Override
	public ResourceLocation getResourceLocation() {
		return re;
	}

}
