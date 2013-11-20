package bb.mods.bbbc.tileentity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityInventoryBB extends TileEntity implements IInventory {

	protected ItemStack[] items;
	protected int[][] valid;
	
	public int[] getValidItems(int slot){
		return valid[slot];
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
		return "Unnamed";
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
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <=64;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	public void addValid(int slot,int ID){
		int[][] a = valid;
		valid = new int[a.length][];
		List<Integer> b = new ArrayList<Integer>();
		for(int i = 0;i<a[slot].length;i++){
			b.add(a[slot][i]);
		}
		b.add(ID);
		for(int i = 0;i<a.length;i++){
			if(i!=slot){
				valid[i]=a[i];
			}
		}
		int[] c = new int[b.size()];
		for(int i = 0;i<c.length;i++){
			c[i] = b.get(i).intValue();
		}
		valid[slot]= c;
	}
	
	public void removeValid(int slot,int ID){
		int[][] a = valid;
		valid = new int[a.length][];
		List<Integer> b = new ArrayList<Integer>();
		for(int i = 0;i<a[slot].length;i++){
			if(a[slot][i]!=ID){
			b.add(a[slot][i]);
			}
		}
		for(int i = 0;i<a.length;i++){
			if(i!=slot){
				valid[i]=a[i];
			}
		}
		int[] c = new int[b.size()];
		for(int i = 0;i<c.length;i++){
			c[i] = b.get(i).intValue();
		}
		valid[slot]= c;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		if(valid!=null){
		for(int q = 0;q<valid[i].length;q++){
			if(valid[i][q] == itemstack.itemID){
				return true;
			}
		}
		}
		return false;
	}

}
