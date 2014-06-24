package bb.mods.bbbc.core.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InputSlot extends Slot {

	private Item[] valid;

	/**
	 * @param valid
	 * list of valid inputs 
	 * **/
	public InputSlot(IInventory inventory, int x, int y, int z, Item[] valid) {
		super(inventory, x, y, z);
		this.valid = valid;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		if (valid != null) {
			for (int i = 0; i < valid.length; i++) {
				if (stack.getItem() == valid[i]) {
					return true;
				}
			}
		}
		/*if(stack == null){
			return true;
		}*/
		return false;
	}

}
