package bb.mods.bbbc.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntity {

	public static void regTileEntity() {

		GameRegistry.registerTileEntity(TileEntityFace.class, "Face");

	}
}
