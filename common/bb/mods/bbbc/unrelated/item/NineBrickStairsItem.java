package bb.mods.bbbc.unrelated.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import bb.mods.bbbc.unrelated.lib.Item_Names;
import bb.mods.bbbc.core.lib.TexturesName;
import bb.mods.bbbc.core.lib.UnlocalizedNames;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NineBrickStairsItem extends Item {

	public NineBrickStairsItem(int itemID) {

		super(itemID);
		hasSubtypes = true;
		canRepair = false;
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(UnlocalizedNames.getUnlocalizedName(Item_Names.NBSI));


	}
	
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		for (int i = 0; i < 2; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}

	}
	
	 public String getUnlocalizedName(ItemStack par1ItemStack)
	    {
	        return "item." + UnlocalizedNames.getUnlocalizedName(Item_Names.NBSI)+par1ItemStack.getItemDamage();
	    }
	
	@SideOnly(Side.CLIENT)
	Icon[] brick;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		brick = new Icon[2];	
		brick[0] = par1IconRegister.registerIcon(TexturesName.getTextureName( Item_Names.NBSI+"_9"));
		brick[1] = par1IconRegister.registerIcon(TexturesName.getTextureName( Item_Names.NBSI+"_81"));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1) {
		return brick[par1];
	}
	
}
