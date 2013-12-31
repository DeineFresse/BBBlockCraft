package bb.mods.bbbc.unrelated.reciepe;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import bb.mods.bbbc.world.block.block;
import bb.mods.bbbc.unrelated.item.item;

public class smelting {

	public static void SmeltingRecipe() {

		// Add Furnace Recipe
		GameRegistry.addSmelting(block.BlockOreOne.blockID, new ItemStack(item.MyFirstItem, 5), 5.0F);
	}

}
