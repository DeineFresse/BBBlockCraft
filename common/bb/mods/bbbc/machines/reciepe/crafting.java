package bb.mods.bbbc.machines.reciepe;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import bb.mods.bbbc.machines.block.block;

public class crafting {

	public static void ShapelessRecipe() {

	}

	public static void Recipe() {

		// Add Recipes
		GameRegistry.addRecipe(new ItemStack(block.Housemachine, 1),
				new Object[] { "XYX", "XZX", "XWX", 'X',
						new ItemStack(Block.brick, 1), 'Y',
						new ItemStack(Block.pistonBase, 1), 'Z',
						new ItemStack(Item.gunpowder, 1), 'W',
						new ItemStack(Block.furnaceIdle, 1) });

		GameRegistry.addRecipe(new ItemStack(block.FirstMachine, 1),
				new Object[] { "XZX", "XYX", "XYX", 'X',
						new ItemStack(Item.ingotIron, 1), 'Y',
						new ItemStack(Item.redstone, 1), 'Z',
						new ItemStack(Block.pressurePlateStone, 1) });
	}

}
