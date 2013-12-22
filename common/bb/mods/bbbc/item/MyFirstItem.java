package bb.mods.bbbc.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import bb.mods.bbbc.lib.Item_Names;
import bb.mods.bbbc.lib.Reference;
import bb.mods.bbbc.lib.UnlocalizedNames;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class MyFirstItem extends Item {

	public MyFirstItem(int itemID) {

		super(itemID);
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(UnlocalizedNames.getUnlocalizedName(Item_Names.MYFIRSTITEM));

	}
	
	@SideOnly(Side.CLIENT)
	Icon brick;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {		
			brick = par1IconRegister.registerIcon(Reference.MOD_ID+":"+Item_Names.MYFIRSTITEM);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1) {
		return brick;
	}
}
