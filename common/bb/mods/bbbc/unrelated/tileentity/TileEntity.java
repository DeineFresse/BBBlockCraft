package bb.mods.bbbc.unrelated.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntity {

	public static void regTileEntity() {
		GameRegistry.registerTileEntity(TileEntityFace.class, "FaceEntity");
		GameRegistry.registerTileEntity(TileEntityRenderTest.class,"RenderTest");
		GameRegistry.registerTileEntity(TileEntityAufgabenblock.class,"TileEntityAufgabenblock");
	}

}
