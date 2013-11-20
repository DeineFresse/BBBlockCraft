package bb.mods.bbbc.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityHouseMachine extends TileEntityInventoryBB {
	
	private int proccesTimer;
	private final int MAXTIMER = 200;
	
	private boolean inventoryChange = true;
	
	public TileEntityHouseMachine(){
		items = new ItemStack[4];
		valid = new int[4][];
		valid[0] = new int[]{159};
		valid[1] = new int[]{159};
		valid[2] = new int[]{};
		valid[3] = new int[]{159};
		
	}
	
	public boolean hasInventoryChanged(){
		return inventoryChange;
	}
	
	public int getMacTimer(){
		return MAXTIMER;
	}
	
	public int getTimer(){
		return proccesTimer;
	}

	@Override
	public String getInvName() {
		return "First Machine";
	}

	@Override
	public void onInventoryChanged() {
		super.onInventoryChanged();
		
		inventoryChange = true;
	}


	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		
		compound.setInteger("proccesTimer", proccesTimer);
		
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
		
		proccesTimer = compound.getInteger("proccesTimer");
		
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
}
