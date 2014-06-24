package bb.mods.bbbc.world.reciepe;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import bb.mods.bbbc.world.block.block;
import cpw.mods.fml.common.registry.GameRegistry;

public class crafting {

	public static void ShapelessRecipe() {

		// Add Shapeless Recipes

		GameRegistry.addShapelessRecipe(new ItemStack(block.CloudWhite, 1, 0),
				new Object[] { new ItemStack(Blocks.wool, 1, 0) });

		GameRegistry.addShapelessRecipe(new ItemStack(block.CloudWhite, 1, 1),
				new Object[] { new ItemStack(Blocks.wool, 1, 1) });

	}

	public static void Recipe() {

	}

}
