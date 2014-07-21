package bb.mods.bbbc.unrelated.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import bb.mods.bbbc.unrelated.lib.Item_Names;
import bb.mods.bbbc.core.lib.TexturesName;
import bb.mods.bbbc.core.lib.UnlocalizedNames;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class MyFirstItem extends Item {

	public MyFirstItem() {

		super();
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(UnlocalizedNames.getUnlocalizedName(Item_Names.MYFIRSTITEM));

	}
	
	@SideOnly(Side.CLIENT)
	IIcon brick;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {		
			//System.out.println(TexturesName.getTextureName(Item_Names.MYFIRSTITEM));
			brick = par1IconRegister.registerIcon(TexturesName.getTextureName(Item_Names.MYFIRSTITEM));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {
		return brick;
	}
}