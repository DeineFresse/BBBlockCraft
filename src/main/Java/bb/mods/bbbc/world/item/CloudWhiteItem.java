package bb.mods.bbbc.world.item;

import bb.mods.bbbc.world.references.Block_Names;
import bb.mods.bbbc.core.util.UnlocalizedNames;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;

public class CloudWhiteItem extends ItemBlock {

	public CloudWhiteItem(Block par1) {
		super(par1);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack) {
		
		//dyeColorNames replaced by field_150923_a
		//getBlockFromDye replaced by func_150031_c
		return "tile."+UnlocalizedNames.getUnlocalizedName(Block_Names.CLOUDWHITE)
				+"."+ItemDye.field_150923_a[BlockColored.func_150031_c(itemstack
						.getItemDamage())].toLowerCase();

	}

	public int getMetadata(int par1) {
		return (par1);
	}
}
