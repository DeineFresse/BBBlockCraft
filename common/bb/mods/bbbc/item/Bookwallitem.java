package bb.mods.bbbc.item;

import bb.mods.bbbc.lib.Item_Names;
import bb.mods.bbbc.lib.UnlocalizedNames;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Bookwallitem extends Item {

	public Bookwallitem(int par1) {
		super(par1);
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(UnlocalizedNames.getUnlocalizedName(Item_Names.BOOKWALLITEM));


	}
}
