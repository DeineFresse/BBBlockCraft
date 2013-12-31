package bb.mods.bbbc.world.reciepe;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import bb.mods.bbbc.world.block.block;

public class crafting {

	public static void ShapelessRecipe() {

		// Add Shapeless Recipes

		GameRegistry.addShapelessRecipe(new ItemStack(block.CloudWhite, 1, 0),
				new Object[] { new ItemStack(Block.cloth, 1, 0) });

		GameRegistry.addShapelessRecipe(new ItemStack(block.CloudWhite, 1, 1),
				new Object[] { new ItemStack(Block.cloth, 1, 1) });

	}

	public static void Recipe() {

	}

}
