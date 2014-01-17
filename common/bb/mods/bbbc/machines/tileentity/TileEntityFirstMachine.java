package bb.mods.bbbc.machines.tileentity;

import bb.mods.bbbc.core.tileentity.TileEntityInventoryBB;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityFirstMachine extends TileEntityInventoryBB {
	
	public TileEntityFirstMachine(){
		items = new ItemStack[4];
		valid = new Item[items.length][1];
		for(int i = 0;i<valid.length;i++){
			valid[i][0] = Item.func_150898_a(Blocks.anvil);
		}
		
	}
	
	@Override
	public String getInvName() {
		return "First Machine";
	}

	@Override
	public void onInventoryChanged() {
		super.onInventoryChanged();
		
		anvils = -1;
	}


	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		
		NBTTagList items = new NBTTagList();
		for (int i = 0;i<getSizeInventory();i++){
			ItemStack stack = getStackInSlot(i);
			
			if(stack!=null){
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte)i);
				stack.writeToNBT(item);
				items.appendTag(item);
			}
		}
		compound.setTag("Items", items);
	}
	
 	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		
		NBTTagList items = compound.getTagList("Items");
		
		for(int i=0;i<items.tagCount();i++){
			NBTTagCompound item = (NBTTagCompound)items.tagAt(i);
			int slot = item.getByte("Slot");
			
			if(slot>=0&&slot<getSizeInventory()){
				setInventorySlotContents(slot,ItemStack.loadItemStackFromNBT(item));
			}
		}
	}

	public void receiveButtonEvent(byte buttonId) {
		switch(buttonId){
		 case 0:{
			 
			 /*
			  * xCoord = field_145851_c
			  * yCoord = field_145848_d
			  * zCoord = field_145849_e
			  * */
				
				 if (!worldObj.isRemote) { 
					 int newMeta = worldObj.getBlockMetadata(field_145851_c,field_145848_d, field_145849_e)^ 1;
				 
				 worldObj.setBlockMetadataWithNotify(field_145851_c,field_145848_d,field_145849_e, newMeta, 3); }
				 
				 break;
		 }
		 case 1:{
			 int meta2 = worldObj.getBlockMetadata(field_145851_c,field_145848_d, field_145849_e);
			 
			 worldObj.setBlockMetadataWithNotify(field_145851_c,field_145848_d, field_145849_e, meta2 % 2, 3);
			 
			 break;
		 }
		}		
	}

	private int anvils = -1;
	
	public int getAnvils() {
		if(anvils == -1){
			calculateAnvilCount();
		}
		
		return anvils;
	}
	
	private void calculateAnvilCount() {
		anvils = 0;
		for(int i = 0;i<getSizeInventory();i++){
			ItemStack stack = getStackInSlot(i);
			if (stack != null && isItemValidForSlot(i,stack)){
				anvils += stack.stackSize;
			}
		}
	}
}
