package bb.mods.bbbc.interfaces;

import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotAnvil extends Slot{

	public SlotAnvil(IInventory inventory, int x, int y, int z) {
		super(inventory, x, y, z);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isItemValid(ItemStack stack){
		return stack.itemID == Block.anvil.blockID;
	}

}
