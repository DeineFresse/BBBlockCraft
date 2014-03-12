package bb.mods.bbbc.unrelated.item;

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
}
