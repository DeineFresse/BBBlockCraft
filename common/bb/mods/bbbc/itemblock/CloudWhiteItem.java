package bb.mods.bbbc.itemblock;

import net.minecraft.block.BlockColored;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;

public class CloudWhiteItem extends ItemBlock {

	public CloudWhiteItem(int par1) {
		
		super(par1);
		setHasSubtypes(true);
		
	}
	
	public String getUnlocalizedName(ItemStack itemstack){
		
				
		
		return getUnlocalizedName().substring(5)+ " " + ItemDye.dyeColorNames[BlockColored.getBlockFromDye(itemstack.getItemDamage())];
		
	}
	
	public int getMetadata(int par1){
		return(par1);
	}

//	@Override
/*    public String getTextureFile()
{
    return "/bb/Pic/BBBlockCraftItems.png";
	
}*/

	
	
	
}
