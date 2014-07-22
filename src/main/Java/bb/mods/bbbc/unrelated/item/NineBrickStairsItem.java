package bb.mods.bbbc.unrelated.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import bb.mods.bbbc.unrelated.references.Item_Names;
import bb.mods.bbbc.core.util.TexturesName;
import bb.mods.bbbc.core.util.UnlocalizedNames;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NineBrickStairsItem extends Item {

	public NineBrickStairsItem() {

		super();
		hasSubtypes = true;
		canRepair = false;
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(UnlocalizedNames.getUnlocalizedName(Item_Names.NBSI));


	}
	
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs,
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
	IIcon[] brick;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		brick = new IIcon[2];	
		brick[0] = par1IconRegister.registerIcon(TexturesName.getTextureName( Item_Names.NBSI+"_9"));
		brick[1] = par1IconRegister.registerIcon(TexturesName.getTextureName( Item_Names.NBSI+"_81"));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {
		return brick[par1];
	}
	
}
