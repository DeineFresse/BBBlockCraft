package bb.mods.bbbc.item;

import bb.mods.bbbc.lib.Item_Names;
import bb.mods.bbbc.lib.LoadedIDs;
import net.minecraft.src.ModLoader;
import net.minecraft.item.Item;

public class item {
	
	
	  // Block Definitions
    public static Item  MyFirstItem;
    public static Item NineBrickStairsItem;
    public static Item Bookwallitem;
    public static Item SwordUp;
    
	public static void signItemID(){
	  
	    MyFirstItem = new MyFirstItem(LoadedIDs.Item_MyFirstItem);
	  	NineBrickStairsItem =new NineBrickStairsItem(LoadedIDs.Item_NineBrickStairItem);
	  	Bookwallitem = new Bookwallitem(LoadedIDs.Item_BookWallItem);
	  	SwordUp = new SwordUp(LoadedIDs.Item_SwordUp);
	  	
	    }	
	 
	 
	 public static void Itemname(){
	     ModLoader.addName(MyFirstItem, Item_Names.MYFIRSTITEM);
	     ModLoader.addName(NineBrickStairsItem,Item_Names.NBSI);
	     ModLoader.addName(Bookwallitem,Item_Names.BOOKWALLITEM);
	   
	 }
	 
}
