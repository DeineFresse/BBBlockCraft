package bb.mods.bbbc.itemblock;

import bb.mods.bbbc.lib.Block_Names;
import bb.mods.bbbc.lib.UnlocalizedNames;
import net.minecraft.block.BlockColored;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;

public class CloudWhiteItem extends ItemBlock {

	public CloudWhiteItem(int par1) {
		super(par1);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack) {
		
		return setUnlocalizedName(UnlocalizedNames.getUnlocalizedName("tile",Block_Names.CLOUDWHITE))
				+ ItemDye.dyeColorNames[BlockColored.getBlockFromDye(itemstack
						.getItemDamage())];

	}

	public int getMetadata(int par1) {
		return (par1);
	}
}
