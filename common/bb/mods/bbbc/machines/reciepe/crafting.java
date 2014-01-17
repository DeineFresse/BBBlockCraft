package bb.mods.bbbc.machines.reciepe;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import bb.mods.bbbc.machines.block.block;

public class crafting {

	public static void ShapelessRecipe() {

	}

	public static void Recipe() {

		// Add Recipes
		GameRegistry.addRecipe(new ItemStack(block.Housemachine, 1),
				new Object[] { "XYX", "XZX", "XWX", 'X',
						new ItemStack(Blocks.brick_block, 1), 'Y',
						new ItemStack(Blocks.piston, 1), 'Z',
						new ItemStack(Items.gunpowder, 1), 'W',
						new ItemStack(Blocks.furnace, 1) });

		GameRegistry.addRecipe(new ItemStack(block.FirstMachine, 1),
				new Object[] { "XZX", "XYX", "XYX", 'X',
						new ItemStack(Items.iron_ingot, 1), 'Y',
						new ItemStack(Items.redstone, 1), 'Z',
						new ItemStack(Blocks.stone_pressure_plate, 1) });
	}

}
