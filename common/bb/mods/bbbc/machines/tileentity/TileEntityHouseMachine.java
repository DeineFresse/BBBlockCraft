package bb.mods.bbbc.machines.tileentity;

import bb.mods.bbbc.core.tileentity.TileEntityInventoryBB;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityHouseMachine extends TileEntityInventoryBB {
	
	private int proccesTimer;
	private final int MAXTIMER = 200;
	
	private boolean inventoryChange = true;
	
	public TileEntityHouseMachine(){
		items = new ItemStack[4];
		valid = new Item[4][];
		valid[0] = new Item[]{Item.func_150898_a(Blocks.hardened_clay)};
		valid[1] = new Item[]{Item.func_150898_a(Blocks.hardened_clay)};
		valid[2] = new Item[]{};
		valid[3] = new Item[]{Item.func_150898_a(Blocks.hardened_clay)};
		
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
				
			 /*
			  * xCoord = field_145851_c
			  * yCoord = field_145848_d
			  * zCoord = field_145849_e
			  * */
			 
				 if (!worldObj.isRemote) { 
					 int newMeta = worldObj.getBlockMetadata(field_145851_c, field_145848_d, field_145849_e)^ 1;
				 
				 worldObj.setBlockMetadataWithNotify(field_145851_c, field_145848_d, field_145849_e, newMeta, 3); }
				 
				 break;
		 }
		 case 1:{
			 int meta2 = worldObj.getBlockMetadata(field_145851_c, field_145848_d, field_145849_e);
			 
			 worldObj.setBlockMetadataWithNotify(field_145851_c, field_145848_d, field_145849_e, meta2 % 2, 3);
			 
			 break;
		 }
		}		
	}
}
