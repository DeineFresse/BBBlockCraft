package bb.mods.bbbc.machines.tileentity;

import bb.mods.bbbc.core.tileentity.IGUITileEntity;
import bb.mods.bbbc.core.tileentity.TileEntityInventoryBB;
import bb.mods.bbbc.core.util.LogHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class TileEntityFirstMachine extends TileEntityInventoryBB implements
		IGUITileEntity {

	public TileEntityFirstMachine() {
		items = new ItemStack[4];
		valid = new Item[items.length][1];
		for (int i = 0; i < valid.length; i++) {
			valid[i][0] = Item.getItemFromBlock(Blocks.anvil);
		}

	}

	@Override
	public String getInventoryName() {
		return "First Machine";
	}

	@Override
	public void onInventoryChanged() {
		super.onInventoryChanged();

		anvils = -1;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		NBTTagList items = new NBTTagList();
		for (int i = 0; i < getSizeInventory(); i++) {
			ItemStack stack = getStackInSlot(i);

			if (stack != null) {
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte) i);
				stack.writeToNBT(item);
				items.appendTag(item);
			}
		}
		compound.setTag("Items", items);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		NBTTagList items = compound.getTagList("Items",
				Constants.NBT.TAG_COMPOUND);

		for (int i = 0; i < items.tagCount(); i++) {
			NBTTagCompound item = items.getCompoundTagAt(i);
			int slot = item.getByte("Slot");

			if (slot >= 0 && slot < getSizeInventory()) {
				setInventorySlotContents(slot,
						ItemStack.loadItemStackFromNBT(item));
			}
		}
	}

	public void onReceiveButtonEvent(byte buttonId) {

        LogHelper.debug("Received ButtonPress!");
		int oldMeta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		int newMeta = oldMeta;

		switch (buttonId) {
		case 0: {
			newMeta = oldMeta ^ 1;
			break;
		}
		case 1: {
			newMeta = oldMeta % 2;
			break;
		}
		}
		//if (!worldObj.isRemote)
		{
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord,
					newMeta, 3);
		}

	}

	private int anvils = -1;

	public int getAnvils() {
		if (anvils == -1) {
			calculateAnvilCount();
		}

		return anvils;
	}

	private void calculateAnvilCount() {
		anvils = 0;
		for (int i = 0; i < getSizeInventory(); i++) {
			ItemStack stack = getStackInSlot(i);
			if (stack != null && isItemValidForSlot(i, stack)) {
				anvils += stack.stackSize;
			}
		}
	}
}
