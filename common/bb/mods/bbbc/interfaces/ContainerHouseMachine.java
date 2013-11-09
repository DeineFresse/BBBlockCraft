package bb.mods.bbbc.interfaces;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import bb.mods.bbbc.tileentity.TileEntityFirstMachine;
import bb.mods.bbbc.tileentity.TileEntityHouseMachine;

public class ContainerHouseMachine extends Container{

	private TileEntityHouseMachine  machine;
	
	public ContainerHouseMachine(InventoryPlayer invPlayer,TileEntityHouseMachine machine){
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
			addSlotToContainer(new SlotAnvil(machine,x,8+18*x,16));
		}
		
	}
	
	public TileEntityHouseMachine getMachine(){
		return machine;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return machine.isUseableByPlayer(entityplayer);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player,int i){
		Slot slot = getSlot(i);
		if(slot != null && slot.getHasStack()){
			ItemStack stack = slot.getStack();
			ItemStack result = stack.copy();
			
			if(i>=36){
				if(!mergeItemStack(stack,0,36,false)){
					return null;
				}
			}else if(stack.itemID != Block.anvil.blockID||!mergeItemStack(stack,36,36+machine.getSizeInventory(), false)){
				return null;
			}
			
			if(stack.stackSize == 0){
				slot.putStack(null);
			}else {
				slot.onSlotChanged();
			}
			
			slot.onPickupFromSlot(player, stack);
			return result;
		}
		
		return null;
	}

}
