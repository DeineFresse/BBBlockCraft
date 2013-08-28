package bb.mods.bbbc.reciepe;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import bb.mods.bbbc.block.block;
import bb.mods.bbbc.item.item;

public class crafting {

	public static void ShapelessRecipe() {

		// Add Shapeless Recipes

		ModLoader.addShapelessRecipe(new ItemStack(block.CloudWhite, 1, 0),
				new Object[] { new ItemStack(Block.cloth, 1, 0) });

		ModLoader.addShapelessRecipe(new ItemStack(block.CloudWhite, 1, 1),
				new Object[] { new ItemStack(Block.cloth, 1, 1) });

		ModLoader.addShapelessRecipe(new ItemStack(item.MyFirstItem, 3),
				new Object[] { Item.ingotIron, Item.ingotIron });

		ModLoader.addShapelessRecipe(new ItemStack(block.BlockOreOne, 1),
				new Object[] { item.MyFirstItem, item.MyFirstItem,
						item.MyFirstItem, item.MyFirstItem, item.MyFirstItem });

		ModLoader.addShapelessRecipe(new ItemStack(block.TestBlock, 1),
				new Object[] { Block.stone, block.BlockOreOne });

		ModLoader.addShapelessRecipe(new ItemStack(Block.stairsBrick, 9),
				new Object[] { item.NineBrickStairsItem });

		ModLoader.addShapelessRecipe(new ItemStack(block.TestBlock, 1),
				new Object[] { new ItemStack(Block.stairsBrick, 64),
						new ItemStack(Block.stairsBrick, 18),
						new ItemStack(Block.bookShelf, 34),
						new ItemStack(Block.enchantmentTable, 1),
						new ItemStack(Block.brick, 64),
						new ItemStack(Block.brick, 22),
						new ItemStack(Block.stoneSingleSlab, 1, 4) });

		ModLoader.addShapelessRecipe(
				new ItemStack(item.NineBrickStairsItem, 9),
				new Object[] { new ItemStack(item.NineBrickStairsItem, 1, 1) });

		ModLoader.addShapelessRecipe(new ItemStack(Block.bookShelf, 9),
				new Object[] { new ItemStack(item.Bookwallitem, 1) });

	}

	public static void Recipe() {

		// Add Recipes

		ModLoader.addRecipe(new ItemStack(Item.ingotIron, 2), new Object[] {
				"   ", "XXX", "   ", 'X', item.MyFirstItem });

		ModLoader.addRecipe(new ItemStack(item.NineBrickStairsItem, 1),
				new Object[] { "XXX", "XXX", "XXX", 'X', Block.stairsBrick });

		ModLoader.addRecipe(new ItemStack(item.NineBrickStairsItem, 1, 1),
				new Object[] { "XXX", "XXX", "XXX", 'X',
						new ItemStack(item.NineBrickStairsItem, 1, 0) });

		ModLoader.addRecipe(new ItemStack(item.Bookwallitem, 1), new Object[] {
				"XXX", "XXX", "XXX", 'X', new ItemStack(Block.bookShelf, 1) });
	}

}
