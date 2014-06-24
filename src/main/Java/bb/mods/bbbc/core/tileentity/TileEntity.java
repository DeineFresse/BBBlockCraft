package bb.mods.bbbc.core.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntity {

	public static void regTileEntity() {
		GameRegistry.registerTileEntity(ConnectedTileEntity.class, "ConnectedBB");
		GameRegistry.registerTileEntity(TileEntityInventoryBB.class, "InventoryBB");
	}

}
