package bb.mods.bbbc.unrelated.reciepe;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import bb.mods.bbbc.unrelated.block.block;
import bb.mods.bbbc.unrelated.item.item;
import cpw.mods.fml.common.registry.GameRegistry;

public class crafting {

	public static void ShapelessRecipe() {

		// Add Shapeless Recipes

		GameRegistry.addShapelessRecipe(new ItemStack(item.MyFirstItem, 3),
				new Object[] { Items.iron_ingot, Items.iron_ingot });

		GameRegistry.addShapelessRecipe(new ItemStack(
				bb.mods.bbbc.world.block.block.BlockOreOne, 1), new Object[] {
				item.MyFirstItem, item.MyFirstItem, item.MyFirstItem,
				item.MyFirstItem, item.MyFirstItem });

		GameRegistry.addShapelessRecipe(new ItemStack(block.TestBlock, 1),
				new Object[] { Blocks.stone,
						bb.mods.bbbc.world.block.block.BlockOreOne });

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.brick_stairs, 9),
				new Object[] { item.NineBrickStairsItem });

		GameRegistry.addShapelessRecipe(new ItemStack(block.TestBlock, 1),
				new Object[] { new ItemStack(Blocks.brick_stairs, 64),
						new ItemStack(Blocks.brick_stairs, 18),
						new ItemStack(Blocks.bookshelf, 34),
						new ItemStack(Blocks.enchanting_table, 1),
						new ItemStack(Blocks.brick_block, 64),
						new ItemStack(Blocks.brick_block, 22),
						new ItemStack(Blocks.stone_slab, 1, 4) });

		GameRegistry.addShapelessRecipe(new ItemStack(item.NineBrickStairsItem,
				9),
				new Object[] { new ItemStack(item.NineBrickStairsItem, 1, 1) });

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.bookshelf, 9),
				new Object[] { new ItemStack(item.Bookwallitem, 1) });

	}

	public static void Recipe() {

		// Add Recipes
		GameRegistry.addRecipe(new ItemStack(block.ConnectedGlass, 16),
				new Object[] { "XYX", "XZX", "XYX", 'X', Blocks.glass, 'Y',
						Items.iron_ingot, 'Z', Blocks.glowstone });
		GameRegistry.addRecipe(new ItemStack(item.SwordUp, 1), new Object[] {
				"Y", "X", "X", 'X', new ItemStack(Items.dye, 1, 4), 'Y',
				Items.stick });
		GameRegistry.addRecipe(new ItemStack(Items.iron_ingot, 2), new Object[] {
				"   ", "XXX", "   ", 'X', item.MyFirstItem });

		GameRegistry.addRecipe(new ItemStack(item.NineBrickStairsItem, 1),
				new Object[] { "XXX", "XXX", "XXX", 'X', Blocks.brick_stairs });

		GameRegistry.addRecipe(new ItemStack(item.NineBrickStairsItem, 1, 1),
				new Object[] { "XXX", "XXX", "XXX", 'X',
						new ItemStack(item.NineBrickStairsItem, 1, 0) });

		GameRegistry.addRecipe(new ItemStack(item.Bookwallitem, 1),
				new Object[] { "XXX", "XXX", "XXX", 'X',
						new ItemStack(Blocks.bookshelf, 1) });

	}
}
