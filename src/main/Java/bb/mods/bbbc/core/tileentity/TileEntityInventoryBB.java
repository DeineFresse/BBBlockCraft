package bb.mods.bbbc.core.tileentity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityInventoryBB extends TileEntity implements IInventory {

	protected ItemStack[] items;
	protected Item[][] valid;
	
	public Item[] getValidItems(int slot){
		return valid[slot];
	}
	
	@Override
	public int getSizeInventory() {
		return items.length;
	}
	
	public void onInventoryChanged(){
		markDirty();
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
		onInventoryChanged();
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
	
	//was getInvName()
	
	public String getInventoryName() {
		return "Unnamed";
	}

	@Override
	
	//was isInvNameLocalized()
	
	public boolean hasCustomInventoryName() {
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
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	public void addValid(int slot,Item item){
		Item[][] a = valid;
		valid = new Item[a.length][];
		List<Item> b = new ArrayList<Item>();
        b.addAll(Arrays.asList(a[slot]));
		b.add(item);
		for(int i = 0;i<a.length;i++){
			if(i!=slot){
				valid[i]=a[i];
			}
		}
		Item[] c = new Item[b.size()];
		for(int i = 0;i<c.length;i++){
			c[i] = b.get(i);
		}
		valid[slot]= c;
	}
	
	public void removeValid(int slot,Item item){
		Item[][] a = valid;
		valid = new Item[a.length][];
		List<Item> b = new ArrayList<Item>();
		for(int i = 0;i<a[slot].length;i++){
			if(a[slot][i]!=item){
			b.add(a[slot][i]);
			}
		}
		for(int i = 0;i<a.length;i++){
			if(i!=slot){
				valid[i]=a[i];
			}
		}
		Item[] c = new Item[b.size()];
		for(int i = 0;i<c.length;i++){
			c[i] = b.get(i);
		}
		valid[slot]= c;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		if(valid!=null){
		for(int q = 0;q<valid[i].length;q++){
			if(valid[i][q] == itemstack.getItem()){
				return true;
			}
		}
		}
		return false;
	}

}
