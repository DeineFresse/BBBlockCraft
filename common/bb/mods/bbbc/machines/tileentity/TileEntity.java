package bb.mods.bbbc.machines.tileentity;

import bb.mods.bbbc.machines.tileentity.TileEntityFirstMachine;
import bb.mods.bbbc.machines.tileentity.TileEntityHouseMachine;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntity {

	public static void regTileEntity() {
		GameRegistry.registerTileEntity(TileEntityFirstMachine.class, "FirstMachine");
		GameRegistry.registerTileEntity(TileEntityHouseMachine.class, "HouseMachine");
	}

}
