package bb.mods.bbbc.interfaces;

import bb.mods.bbbc.tileentity.TileEntityFirstMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerFirstMachine extends Container{

	private TileEntityFirstMachine  machine;
	
	public ContainerFirstMachine(InventoryPlayer invPlayer,TileEntityFirstMachine machine){
		this.machine = machine;
		
		for(int x = 0;x<9;x++){
			addSlotToContainer(new Slot(invPlayer,x,8+18*x,142));
		}
		
		for(int y=0;y<3;y++){
			for(int x = 0;x<9;x++){
				addSlotToContainer(new Slot(invPlayer,x+y*9+9,8+18*x,84+y*18));
			}
		}
		
		for(int x = 0;x<4;x++){
			addSlotToContainer(new SlotAnvil(machine,x,8+18*x,8));
		}
		
	}
	
	public TileEntityFirstMachine getMachine(){
		return machine;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return machine.isUseableByPlayer(entityplayer);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player,int i){
		return null;
	}

}
