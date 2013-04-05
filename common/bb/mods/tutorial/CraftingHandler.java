package bb.mods.tutorial;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftingHandler implements ICraftingHandler{

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item,
			IInventory craftMatrix) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		// TODO Auto-generated method stub
		if(item.itemID == BlockOreOne.shiftedIndex)
		{
			player.addStat(BBBlockCraft.secondAchievement, 1);
		}
	}

	void onItemPickup(EntityPlayer player,ItemStack item)
	{
		if(item.itemID == 160)
		{player.addStat(BBBlockCraft.firstAchievement, 1);}
	}
}
