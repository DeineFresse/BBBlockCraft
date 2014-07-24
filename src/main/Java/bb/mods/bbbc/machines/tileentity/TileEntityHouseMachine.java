package bb.mods.bbbc.machines.tileentity;

import bb.mods.bbbc.core.util.LogHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import bb.mods.bbbc.core.tileentity.IGUITileEntity;
import bb.mods.bbbc.core.tileentity.TileEntityInventoryBB;

public class TileEntityHouseMachine extends TileEntityInventoryBB implements
		IGUITileEntity {

	private int proccesTimer;
	private final int MAXTIMER = 200;

	private boolean inventoryChange = true;

	public TileEntityHouseMachine() {
		items = new ItemStack[4];
		valid = new Item[4][];
		valid[0] = new Item[] { Item.getItemFromBlock(Blocks.hardened_clay) };
		valid[1] = new Item[] { Item.getItemFromBlock(Blocks.hardened_clay) };
		valid[2] = new Item[] {};
		valid[3] = new Item[] { Item.getItemFromBlock(Blocks.hardened_clay) };

	}

	public boolean hasInventoryChanged() {
		return inventoryChange;
	}

	public int getMacTimer() {
		return MAXTIMER;
	}

	public int getTimer() {
		return proccesTimer;
	}

	@Override
	public String getInventoryName() {
		return "First Machine";
	}

	@Override
	public void onInventoryChanged() {
		super.onInventoryChanged();

		inventoryChange = true;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		compound.setInteger("proccesTimer", proccesTimer);

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

		proccesTimer = compound.getInteger("proccesTimer");

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

	@Override
	public void onReceiveButtonEvent(byte buttonId) {
        LogHelper.info("Received ButtonPress!");
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
		if (!worldObj.isRemote) {
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord,
					newMeta, 3);
		}
	}

}
