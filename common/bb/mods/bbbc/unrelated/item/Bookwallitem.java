package bb.mods.bbbc.unrelated.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import bb.mods.bbbc.unrelated.lib.Item_Names;
import bb.mods.bbbc.core.lib.TexturesName;
import bb.mods.bbbc.core.lib.UnlocalizedNames;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class Bookwallitem extends Item {

	public Bookwallitem(int par1) {
		super(par1);
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(UnlocalizedNames.getUnlocalizedName(Item_Names.BOOKWALLITEM));

		
	}
	@SideOnly(Side.CLIENT)
	private Icon brick;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {		
			brick = par1IconRegister.registerIcon(TexturesName.getTextureName(Item_Names.BOOKWALLITEM));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1) {
		return brick;
	}
}
