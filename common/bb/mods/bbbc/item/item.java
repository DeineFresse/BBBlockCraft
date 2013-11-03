package bb.mods.bbbc.item;

import bb.mods.bbbc.lib.LoadedIDs;
import net.minecraft.item.Item;

public class item {

	// Block Definitions
	public static Item MyFirstItem;
	public static Item NineBrickStairsItem;
	public static Item Bookwallitem;
	public static Item SwordUp;
	public static Item LayoutCard;

	public static void signItemID() {

		MyFirstItem = new MyFirstItem(LoadedIDs.Item_MyFirstItem);
		NineBrickStairsItem = new NineBrickStairsItem(
				LoadedIDs.Item_NineBrickStairItem);
		Bookwallitem = new Bookwallitem(LoadedIDs.Item_BookWallItem);
		SwordUp = new SwordUp(LoadedIDs.Item_SwordUp);
		LayoutCard = new LayoutCard(LoadedIDs.Item_LayoutCard);

	}
}
