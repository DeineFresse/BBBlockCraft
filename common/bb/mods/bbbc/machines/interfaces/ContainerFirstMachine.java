package bb.mods.bbbc.machines.interfaces;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import bb.mods.bbbc.core.slots.InputSlot;
import bb.mods.bbbc.machines.tileentity.TileEntityFirstMachine;

public class ContainerFirstMachine extends Container{

	private TileEntityFirstMachine machine;
	
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
			addSlotToContainer(new InputSlot(machine,x,8+18*x,16,new Item[]{Item.getItemFromBlock(Block.getBlockFromName("anvil"))}));
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
		Slot slot = getSlot(i);
		if(slot != null && slot.getHasStack()){
			ItemStack stack = slot.getStack();
			ItemStack result = stack.copy();
			
			if(i>=36){
				if(!mergeItemStack(stack,0,36,false)){
					return null;
				}
			}else if(Block.getBlockFromItem(stack.getItem()) != Blocks.anvil||!mergeItemStack(stack,36,36+machine.getSizeInventory(), false)){
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
