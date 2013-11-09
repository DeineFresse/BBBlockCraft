package bb.mods.bbbc.block;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import bb.mods.bbbc.BBBlockCraft;
import bb.mods.bbbc.lib.Block_Names;
import bb.mods.bbbc.lib.UnlocalizedNames;
import bb.mods.bbbc.tileentity.TileEntityHouseMachine;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Housemachine extends BlockContainer {

	public Housemachine(int par1) {
		super(par1, Material.clay);
		setHardness(1.0f);
		setResistance(0.5f);
		setStepSound(soundAnvilFootstep);
		setCreativeTab(CreativeTabs.tabDecorations);
		setLightValue(15.0f);
		setUnlocalizedName(UnlocalizedNames.getUnlocalizedName(Block_Names.HOUSEMACHINE));
	}
	

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
	if (!world.isRemote) {
			FMLNetworkHandler.openGui(player, BBBlockCraft.instance, 1, world,
					x, y, z);

		}

		return true;
	}
	
	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4,
			int par5, int par6) {
		TileEntity te = par1World.getBlockTileEntity(par2, par3, par4);
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


	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityHouseMachine();
	}

}
