package bb.mods.bbbc.interfaces;

import bb.mods.bbbc.tileentity.TileEntityFirstMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerFirstMachine extends Container{

	private TileEntityFirstMachine  machine;
	
	public ContainerFirstMachine(InventoryPlayer invPlayer,TileEntityFirstMachine machine){
		this.machine = machine;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return machine.isUseableByPlayer(entityplayer);
	}

}
