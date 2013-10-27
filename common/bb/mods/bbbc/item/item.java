package bb.mods.bbbc.item;

import cpw.mods.fml.common.registry.LanguageRegistry;
import bb.mods.bbbc.lib.Item_Names;
import bb.mods.bbbc.lib.LoadedIDs;
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

	public static void Itemname() {
		LanguageRegistry.instance().addNameForObject(MyFirstItem, "en_US",
				Item_Names.MYFIRSTITEM);
		LanguageRegistry.instance().addNameForObject(NineBrickStairsItem,
				"en_US", Item_Names.NBSI);
		LanguageRegistry.instance().addNameForObject(Bookwallitem, "en_US",
				Item_Names.BOOKWALLITEM);
	}

}
