package bb.mods.bbbc.unrelated.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import bb.mods.bbbc.unrelated.lib.Item_Names;
import bb.mods.bbbc.core.lib.TexturesName;
import bb.mods.bbbc.core.lib.UnlocalizedNames;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class SwordUp extends Item {

	public SwordUp() {
		maxStackSize = 1;
		setMaxDamage(100000);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(UnlocalizedNames.getUnlocalizedName(Item_Names.SWORDUP));

	}
	
	@SideOnly(Side.CLIENT)
	private IIcon brick;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {		
			brick = par1IconRegister.registerIcon(TexturesName.getTextureName(Item_Names.SWORDUP));
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack IS, EntityPlayer player,EntityLivingBase target) {
		if (!target.worldObj.isRemote) {
			target.motionY = 2;
			IS.damageItem(1, player);
		}

		return true;
	}
	
	  public boolean isFull3D()
	    {
	        return true;
	    }
	  
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {
		return brick;
	}
}
