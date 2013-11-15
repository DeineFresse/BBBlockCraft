package bb.mods.bbbc.interfaces.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class InputSlot extends Slot {

	private int[] valid;

	public InputSlot(IInventory inventory, int x, int y, int z, int[] valid) {
		super(inventory, x, y, z);
		this.valid = valid;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		if (valid != null) {
			for (int i = 0; i < valid.length; i++) {
				if (stack.itemID == valid[i]) {
					return true;
				}
			}
		}
		if(stack == null){
			return true;
		}
		return false;
	}

}
