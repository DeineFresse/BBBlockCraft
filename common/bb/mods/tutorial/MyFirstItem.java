package bb.mods.tutorial;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
public class MyFirstItem extends Item{
	
	public MyFirstItem(int itemID){
		
		super(itemID);
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMisc);
		//setItemName("My First Item");
		
	
	}
	
	
	/*@Override
        public String getTextureFile()
{
        return "/bb/Pic/BBBlockCraftItems.png";
		
	}*/
	

}
