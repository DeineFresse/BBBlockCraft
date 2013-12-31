package bb.mods.bbbc.machines.item;

import bb.mods.bbbc.machines.lib.LoadedIDs;
import bb.mods.bbbc.machines.item.LayoutCard;
import net.minecraft.item.Item;

public class item {

	// Block Definitions
	public static Item LayoutCard;

	public static void signItemID() {

		LayoutCard = new LayoutCard(LoadedIDs.Item_LayoutCard);

	}
}
