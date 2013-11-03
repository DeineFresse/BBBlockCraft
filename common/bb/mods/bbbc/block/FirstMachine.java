package bb.mods.bbbc.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import bb.mods.bbbc.lib.Block_Names;
import bb.mods.bbbc.lib.Reference;
import bb.mods.bbbc.lib.UnlocalizedNames;
import bb.mods.bbbc.tileentity.TileEntityFirstMachine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FirstMachine extends BlockContainer {

	public FirstMachine(int par1) {
		super(par1, Material.plants);
		setHardness(0.5f);
		setResistance(5.0f);
		setStepSound(soundStoneFootstep);
		setCreativeTab(CreativeTabs.tabBlock);
		setLightValue(1.0F);
		setUnlocalizedName(UnlocalizedNames
				.getUnlocalizedName(Block_Names.FIRSTMACHINE));
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitX, float hitY, float hitZ) {

		if (!world.isRemote) {
			int newMeta = world.getBlockMetadata(x, y, z) ^ 1;

			world.setBlockMetadataWithNotify(x, y, z, newMeta, 3);
		}

		/*
		 * if (!world.isRemote) { FMLNetworkHandler.openGui(player,
		 * BBBlockCraft.instance, 0, world, x, y, z);
		 * 
		 * }
		 */
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

	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		if (!world.isRemote && !isDisabled(world.getBlockMetadata(x, y, z))) {
			spawnAnvil(world, x, y + 20, z);
		}

	}

	@SideOnly(Side.CLIENT)
	private Icon bottomIcon;
	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	@SideOnly(Side.CLIENT)
	private Icon sideIcon;
	@SideOnly(Side.CLIENT)
	private Icon[] sideIcons = new Icon[4];
	@SideOnly(Side.CLIENT)
	private Icon disableIcon;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		bottomIcon = par1IconRegister.registerIcon(Reference.MOD_ID
				.toLowerCase() + ":" + Block_Names.FIRSTMACHINE + "_bottom");
		topIcon = par1IconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
				+ ":" + Block_Names.FIRSTMACHINE + "_top");
		sideIcon = par1IconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
				+ ":" + Block_Names.FIRSTMACHINE + "_side");
		disableIcon = par1IconRegister.registerIcon(Reference.MOD_ID
				.toLowerCase() + ":" + Block_Names.FIRSTMACHINE + "_disabled");
		sideIcons[0] = sideIcon;
		sideIcons[1] = par1IconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
				+ ":" + Block_Names.FIRSTMACHINE + "_side_border");
		sideIcons[2] = par1IconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
				+ ":" + Block_Names.FIRSTMACHINE + "_side_x");
		sideIcons[3] = par1IconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
				+ ":" + Block_Names.FIRSTMACHINE + "_side_arrow");	
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		switch (par1) {
		case 0: {
			return bottomIcon;
		}
		case 1: {
			return isDisabled(par2) ? disableIcon : topIcon;
		}
		default: {
			
			int texture = (par2&14)/2;
			
			return sideIcons[texture];
		}
		}
	}

	private boolean isDisabled(int meta) {
		return (meta & 1) == 1;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int id) {
		int meta = world.getBlockMetadata(x, y, z);
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)
				&& !isDisabled(meta)) {
			switch(meta/2){
			case 0:{
				spawnAnvil(world, x, y + 20, z);
				break;
			}
			case 1:
				
			case 2:
				
			case 3:
			}
			}
	}

	private void spawnAnvil(World world, int x, int y, int z) {
		if (world.isAirBlock(x, y, z)) {
			world.setBlock(x, y, z, Block.anvil.blockID);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityFirstMachine();
	}
}
