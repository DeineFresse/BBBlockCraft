package bb.mods.bbbc.reciepe;

import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import bb.mods.bbbc.block.block;
import bb.mods.bbbc.item.item;

public class smelting {

	public static void SmeltingRecipe() {

		// Add Furnace Recipe

		ModLoader.addSmelting(160, new ItemStack(item.MyFirstItem, 5), 5.0F);
		ModLoader.addSmelting(162, new ItemStack(block.CloudWhite, 1, 0), 5.0F);

	}
	
}
