package bb.mods.bbbc.tileentity;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityFirstMachine extends TileEntityInventoryBB {
	
	public TileEntityFirstMachine(){
		items = new ItemStack[4];
		valid = new int[items.length][1];
		for(int i = 0;i<valid.length;i++){
			valid[i][0] = Block.anvil.blockID;
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
				
				 if (!worldObj.isRemote) { 
					 int newMeta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord)^ 1;
				 
				 worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, newMeta, 3); }
				 
				 break;
		 }
		 case 1:{
			 int meta2 = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
			 
			 worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, meta2 % 2, 3);
			 
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
