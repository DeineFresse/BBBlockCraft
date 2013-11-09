package bb.mods.bbbc.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityHouseMachine extends TileEntity implements IInventory{

	private ItemStack[] items;
	private int proccesTimer;
	private final int MAXTIMER = 200;

	private boolean inventoryChange = true;
	
	public TileEntityHouseMachine(){
		items = new ItemStack[4];
		
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
	public int getSizeInventory() {
		return items.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return items[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		ItemStack itemstack = getStackInSlot(i);
		
		if(itemstack != null){
			if(itemstack.stackSize <= j){
				setInventorySlotContents(i,null);
			}
			else{
				itemstack = itemstack.splitStack(j);
				onInventoryChanged();
			}
		}
				return itemstack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		ItemStack item = getStackInSlot(i);
		setInventorySlotContents(i,null);
		return item;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		items[i] = itemstack;
		
		if(itemstack != null && itemstack.stackSize > getInventoryStackLimit()){
			itemstack.stackSize = getInventoryStackLimit();
		}
		
		onInventoryChanged();		
	}

	@Override
	public String getInvName() {
		return "First Machine";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void onInventoryChanged() {
		super.onInventoryChanged();
		
		inventoryChange = true;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <=64;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		
		//TODO : Make the right items be accepted
		return itemstack.itemID == Block.anvil.blockID;
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
