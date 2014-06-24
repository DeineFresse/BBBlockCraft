package bb.mods.bbbc.world.reciepe;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import bb.mods.bbbc.world.block.block;

public class smelting {

	public static void SmeltingRecipe() {

		// Add Furnace Recipe
		GameRegistry.addSmelting(block.cloudore, new ItemStack(block.CloudWhite, 1, 0),5.0F);

	}

}
