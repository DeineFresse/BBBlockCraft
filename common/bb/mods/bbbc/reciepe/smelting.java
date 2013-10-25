package bb.mods.bbbc.reciepe;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import bb.mods.bbbc.block.block;
import bb.mods.bbbc.item.item;

public class smelting {

	public static void SmeltingRecipe() {

		// Add Furnace Recipe

		GameRegistry.addSmelting(160, new ItemStack(item.MyFirstItem, 5), 5.0F);
		GameRegistry.addSmelting(162, new ItemStack(block.CloudWhite, 1, 0), 5.0F);

	}
	
}
