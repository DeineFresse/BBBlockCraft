package bb.mods.bbbc.unrelated.item;

import bb.mods.bbbc.unrelated.lib.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class item {

	// Block Definitions
	public static Item MyFirstItem;
	public static Item NineBrickStairsItem;
	public static Item Bookwallitem;
	public static Item SwordUp;

	public static void signItemID() {

		MyFirstItem = new MyFirstItem();
		NineBrickStairsItem = new NineBrickStairsItem();
		Bookwallitem = new Bookwallitem();
		SwordUp = new SwordUp();
	
	}
	
	public static void registerItems(){
		GameRegistry.registerItem(MyFirstItem,MyFirstItem.getUnlocalizedName(),Reference.MOD_ID);
	}
}
