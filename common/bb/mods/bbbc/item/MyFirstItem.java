package bb.mods.bbbc.item;

import bb.mods.bbbc.lib.Item_Names;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
public class MyFirstItem extends Item{
	
	public MyFirstItem(int itemID){
		
		super(itemID);
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(Item_Names.MYFIRSTITEM);
		
	
	}
	
	
	
	

}
