package bb.mods.bbbc.world.item;

import bb.mods.bbbc.world.lib.Block_Names;
import bb.mods.bbbc.core.lib.UnlocalizedNames;
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
		
		
		return "tile."+UnlocalizedNames.getUnlocalizedName(Block_Names.CLOUDWHITE)
				+"."+ItemDye.dyeColorNames[BlockColored.getBlockFromDye(itemstack
						.getItemDamage())].toLowerCase();

	}

	public int getMetadata(int par1) {
		return (par1);
	}
}
