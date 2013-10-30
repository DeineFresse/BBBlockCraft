package bb.mods.bbbc.item;

import bb.mods.bbbc.lib.Item_Names;
import bb.mods.bbbc.lib.UnlocalizedNames;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SwordUp extends Item {

	public SwordUp(int ID) {
		super(ID);
		maxStackSize = 8;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(UnlocalizedNames.getUnlocalizedName(Item_Names.SWORDUP));

	}

	@Override
	public boolean itemInteractionForEntity(ItemStack IS, EntityPlayer player,
			EntityLivingBase target) {
		if (!target.worldObj.isRemote) {
			target.motionY = 2;
		}

		return true;
	}

}
