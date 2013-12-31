package bb.mods.bbbc.machines.item;

import bb.mods.bbbc.machines.lib.Block_Names;
import bb.mods.bbbc.core.lib.UnlocalizedNames;
import net.minecraft.item.ItemBlock;

public class FirstMachineItem extends ItemBlock {

	public FirstMachineItem(int par1) {

		super(par1);
		setHasSubtypes(true);
		setUnlocalizedName(UnlocalizedNames.getUnlocalizedName(Block_Names.FIRSTMACHINE));


	}
	
	public int getMetadata(int dmg){
		return dmg;
	}
}
