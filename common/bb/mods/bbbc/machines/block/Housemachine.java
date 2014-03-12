package bb.mods.bbbc.machines.block;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;//check for better way
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import bb.mods.bbbc.BBBlockCraftCore;
import bb.mods.bbbc.machines.lib.Block_Names;
import bb.mods.bbbc.core.lib.TexturesName;
import bb.mods.bbbc.core.lib.UnlocalizedNames;
import bb.mods.bbbc.machines.tileentity.TileEntityHouseMachine;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class Housemachine extends BlockContainer {

	public Housemachine() {
		super(Material.clay);
		setHardness(1.0f);
		setResistance(0.5f);
		setStepSound(soundTypeStone);
		setCreativeTab(CreativeTabs.tabDecorations);
		//setlightValue replaced by setLightLevel
		setLightLevel(1.0f);
		//setUnlocalizedName replaced by setBlockName
		setBlockName(UnlocalizedNames.getUnlocalizedName(Block_Names.HOUSEMACHINE));
	}
	

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
	if (!world.isRemote) {
			FMLNetworkHandler.openGui(player, BBBlockCraftCore.instance, 1, world,
					x, y, z);

		}

		return true;
	}
	
	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4,
			Block par5, int par6) {
		//getBlockTileEntity replaced by getTileEntity
		TileEntity te = par1World.getTileEntity(par2, par3, par4);
		if (te != null && te instanceof IInventory) {
			IInventory inventory = (IInventory) te;

			for (int i = 0; i < inventory.getSizeInventory(); i++) {
				ItemStack stack = inventory.getStackInSlotOnClosing(i);

				if (stack != null) {
					float spawnX = par2 + par1World.rand.nextFloat();
					float spawnY = par3 + par1World.rand.nextFloat();
					float spawnZ = par4 + par1World.rand.nextFloat();

					EntityItem droppedItem = new EntityItem(par1World, spawnX,
							spawnY, spawnZ, stack);

					float mult = 0.05F;

					droppedItem.motionX = (-0.5 + par1World.rand.nextFloat())
							* mult;
					droppedItem.motionY = (4 + par1World.rand.nextFloat())
							* mult;
					droppedItem.motionZ = (-0.5 + par1World.rand.nextFloat())
							* mult;

					par1World.spawnEntityInWorld(droppedItem);
				}
			}
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	@SideOnly(Side.CLIENT)
	public static IIcon topIcon;
	@SideOnly(Side.CLIENT)
	public static IIcon bottomIcon;
	@SideOnly(Side.CLIENT)
	public static IIcon[] sideIcon;
	@Override
	@SideOnly(Side.CLIENT)
	//registerIcons replaced by registerBlockIcons
	public void registerBlockIcons(IIconRegister icon) {
		
		sideIcon   = new IIcon[4];
		
		topIcon = icon.registerIcon(TexturesName.getTextureName(Block_Names.HOUSEMACHINE.toLowerCase() , "_top"));
		bottomIcon = icon.registerIcon(TexturesName.getTextureName(Block_Names.HOUSEMACHINE.toLowerCase() , "_bottom"));
		for(int i = 0;i<sideIcon.length;i++){
			sideIcon[i] = icon.registerIcon(TexturesName.getTextureName(Block_Names.HOUSEMACHINE.toLowerCase() , "_side_"+i));
		}
	}

	public IIcon getIcon(int par1, int par2) {

		switch (par1) {
		case 1:
			return topIcon;
		case 0:
			return bottomIcon;
		default:
			return sideIcon[par1-2];
		}

	}

	//createNewTileEntity(World world) replaced by public TileEntity createNewTileEntity(World var1, int var2)
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityHouseMachine();
	}

}
