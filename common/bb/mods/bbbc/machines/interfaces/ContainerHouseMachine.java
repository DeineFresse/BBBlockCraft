package bb.mods.bbbc.machines.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import bb.mods.bbbc.core.slots.InputSlot;
import bb.mods.bbbc.machines.tileentity.TileEntityHouseMachine;

public class ContainerHouseMachine extends Container {

	private TileEntityHouseMachine machine;

	public ContainerHouseMachine(InventoryPlayer invPlayer,
			TileEntityHouseMachine machine) {
		this.machine = machine;

		for (int x = 0; x < 9; x++) {
			addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 142));
		}

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9,
						8 + 18 * x, 84 + y * 18));
			}
		}

		addSlotToContainer(new InputSlot(machine, 0, 26, 12,
				machine.getValidItems(0)));
		addSlotToContainer(new InputSlot(machine, 1, 93, 12,
				machine.getValidItems(1)));
		addSlotToContainer(new InputSlot(machine, 2, 26, 52,
				machine.getValidItems(2)));
		addSlotToContainer(new InputSlot(machine, 3, 93, 53,
				machine.getValidItems(3)));
	}

	public TileEntityHouseMachine getMachine() {
		return machine;
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return machine.isUseableByPlayer(entityplayer);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {

		Slot slot = getSlot(i);

		if (slot != null && slot.getHasStack()) {
			ItemStack stack = slot.getStack();
			ItemStack result = stack.copy();

			if (i >= 36) {
				if (!mergeItemStack(stack, 0, 36, false)) {
					return null;
				}
			} else {

				for (int ii = 36; ii < (36 + machine.getSizeInventory()); ii++) {

					if (getSlot(ii).isItemValid(stack)) {

						if (!mergeItemStack(stack, ii, ii + 1, false)) {
							continue;
						}
						else {
							if (stack.stackSize == 0) {
								slot.putStack(null);
							}
							else{
							slot.onSlotChanged();
							}
							slot.onPickupFromSlot(player, stack);
							
						}
						
					}
					
				}

			}
			if (stack.stackSize == 0) {
				slot.putStack(null);
			} 
			else if (stack.stackSize == result.stackSize){
				return null;
			}
			else {
				slot.onSlotChanged();
			}

			slot.onPickupFromSlot(player, stack);
			return result;
		}

		return null;

	}

}
