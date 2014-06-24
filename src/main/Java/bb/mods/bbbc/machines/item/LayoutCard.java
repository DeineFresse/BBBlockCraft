package bb.mods.bbbc.machines.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import bb.mods.bbbc.machines.block.block;
import bb.mods.bbbc.machines.lib.Item_Names;
import bb.mods.bbbc.core.lib.TexturesName;
import bb.mods.bbbc.core.lib.UnlocalizedNames;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LayoutCard extends Item {

	public LayoutCard() {

		super();
		hasSubtypes = true;
		canRepair = false;
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(UnlocalizedNames
				.getUnlocalizedName(Item_Names.LAYOUTCARD));

	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack,EntityPlayer player,World world,int x,int y,int z,int side,float hitX,float hitY,float hitZ){
		if(!world.isRemote&&world.getBlock(x, y, z)==block.FirstMachine){
			int meta = world.getBlockMetadata(x, y, z);
			
			int disabled = (meta&1);
			
			int type = stack.getItemDamage();
			
			int newMeta = type*2+disabled;
			
			world.setBlockMetadataWithNotify(x, y, z, newMeta, 3);
			
			stack.stackSize--;
			
			return true;
		}
		else{
			return false;
		}		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		for (int i = 0; i < 4; i++) {
			par3List.add(new ItemStack(this, 1, i));
		}

	}

	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return "item."
				+ UnlocalizedNames.getUnlocalizedName(Item_Names.LAYOUTCARD)
				+ par1ItemStack.getItemDamage();
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] brick;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		brick = new IIcon[4];
		for (int i = 0; i < brick.length; i++) {
			brick[i] = par1IconRegister.registerIcon(TexturesName.getTextureName(Item_Names.LAYOUTCARD+"_"+i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {
		return brick[par1];
	}

}