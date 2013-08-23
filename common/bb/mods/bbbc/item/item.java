package bb.mods.bbbc.item;

import bb.mods.bbbc.lib.Item_Names;
import net.minecraft.src.ModLoader;
import net.minecraft.item.Item;

public class item {
	
	
	  // Block Definitions
    public static Item  MyFirstItem;
    public static Item NineBrickStairsItem;
    public static Item Bookwallitem;
    
	public static void signItemID(){
	  
	    MyFirstItem = new MyFirstItem(2100);
	  	NineBrickStairsItem =new NineBrickStairsItem(2101);
	  	Bookwallitem = new Bookwallitem(2102);
	    }	
	 
	 
	 public static void Itemname(){
	     ModLoader.addName(MyFirstItem, Item_Names.MYFIRSTITEM);
	     ModLoader.addName(NineBrickStairsItem,Item_Names.NBSI);
	     ModLoader.addName(Bookwallitem,Item_Names.BOOKWALLITEM);
	   
	 }
	 
}
