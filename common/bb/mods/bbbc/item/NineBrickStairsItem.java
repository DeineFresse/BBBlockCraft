package bb.mods.bbbc.item;

import java.util.List;

import bb.mods.bbbc.lib.Item_Names;
import bb.mods.bbbc.lib.UnlocalizedNames;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NineBrickStairsItem extends Item {

	public NineBrickStairsItem(int itemID) {

		super(itemID);
		setMaxDamage(0);
		hasSubtypes = true;
		canRepair = false;
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(UnlocalizedNames.getUnlocalizedName("item",Item_Names.NBSI));


	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		for (int i = 0; i < 4; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}

	}

	public int getIconfromDamage(int par1) {

		int i = par1 + 1;

		return i;

	}

	public String getItemNameIS(ItemStack par1) {
		String[] StairName;
		StairName = new String[4];
		StairName[0] = "x9  Stairs";
		StairName[1] = "x81 Stairs";
		StairName[2] = "NYI";
		StairName[3] = "NYI";
		return StairName[par1.getItemDamage()];

		// return null;

	}

	/*
	 * @Override public String getTextureFile() { return
	 * "/bb/Pic/BBBlockCraftItems.png";
	 * 
	 * }
	 */

}
