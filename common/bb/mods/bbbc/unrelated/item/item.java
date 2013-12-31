package bb.mods.bbbc.unrelated.item;

import bb.mods.bbbc.unrelated.lib.LoadedIDs;
import net.minecraft.item.Item;

public class item {

	// Block Definitions
	public static Item MyFirstItem;
	public static Item NineBrickStairsItem;
	public static Item Bookwallitem;
	public static Item SwordUp;

	public static void signItemID() {

		MyFirstItem = new MyFirstItem(LoadedIDs.Item_MyFirstItem);
		NineBrickStairsItem = new NineBrickStairsItem(
				LoadedIDs.Item_NineBrickStairItem);
		Bookwallitem = new Bookwallitem(LoadedIDs.Item_BookWallItem);
		SwordUp = new SwordUp(LoadedIDs.Item_SwordUp);
	
	}
}
