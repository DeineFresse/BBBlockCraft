package bb.mods.bbbc.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import bb.mods.bbbc.lib.Item_Names;
import bb.mods.bbbc.lib.LoadedIDs;
import bb.mods.bbbc.lib.Reference;
import bb.mods.bbbc.lib.UnlocalizedNames;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LayoutCard extends Item {

	public LayoutCard(int itemID) {

		super(itemID);
		hasSubtypes = true;
		canRepair = false;
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(UnlocalizedNames
				.getUnlocalizedName(Item_Names.LAYOUTCARD));

	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack,EntityPlayer player,World world,int x,int y,int z,int side,float hitX,float hitY,float hitZ){
		if(!world.isRemote&&world.getBlockId(x, y, z)==LoadedIDs.Block_FirstMachine){
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
			par3List.add(new ItemStack(par1, 1, i));
		}

	}

	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return "item."
				+ UnlocalizedNames.getUnlocalizedName(Item_Names.LAYOUTCARD)
				+ par1ItemStack.getItemDamage();
	}

	@SideOnly(Side.CLIENT)
	private Icon[] brick;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		brick = new Icon[4];
		for (int i = 0; i < brick.length; i++) {
			brick[i] = par1IconRegister.registerIcon(Reference.MOD_ID+":"+Item_Names.LAYOUTCARD+"_"+i);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1) {
		return brick[par1];
	}

}