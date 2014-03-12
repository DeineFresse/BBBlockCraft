package bb.mods.bbbc.machines.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import bb.mods.bbbc.BBBlockCraftCore;
import bb.mods.bbbc.machines.lib.Block_Names;
import bb.mods.bbbc.core.lib.TexturesName;
import bb.mods.bbbc.core.lib.UnlocalizedNames;
import bb.mods.bbbc.machines.tileentity.TileEntityFirstMachine;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler; //check for better Way
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FirstMachine extends BlockContainer {

	public FirstMachine() {
		super(Material.plants);
		setHardness(0.5f);
		setResistance(5.0f);
		setStepSound(soundTypeStone);
		setCreativeTab(CreativeTabs.tabBlock);
		//setLightValue replaced by setLightLevel
		setLightLevel(1.0F);
		//setUnlocalizedName reblaced by setBlockName
		setBlockName(UnlocalizedNames
				.getUnlocalizedName(Block_Names.FIRSTMACHINE));
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
	if (!world.isRemote) {
		if(!player.isSneaking()){
			FMLNetworkHandler.openGui(player, BBBlockCraftCore.instance, 0, world,
					x, y, z);
		}
		else{
			world.setBlockMetadataWithNotify(x, y, z,world.getBlockMetadata(x, y, z)^1,0x3);
		}
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

	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityFirstMachine) {
			TileEntityFirstMachine machine = (TileEntityFirstMachine) te;
			if (!world.isRemote && !isDisabled(world.getBlockMetadata(x, y, z))) {
				spawnAnvil(world, machine, x, y + 20, z);
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		for (int var4 = 0; var4 < 4; ++var4) {
			par3List.add(new ItemStack(par1, 1, var4 * 2));
		}
	}

	@SideOnly(Side.CLIENT)
	private IIcon bottomIcon;
	@SideOnly(Side.CLIENT)
	private IIcon topIcon;
	@SideOnly(Side.CLIENT)
	private IIcon sideIcon;
	@SideOnly(Side.CLIENT)
	private IIcon[] sideIcons;
	@SideOnly(Side.CLIENT)
	private IIcon disableIcon;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		bottomIcon = par1IconRegister.registerIcon(TexturesName.getTextureName(Block_Names.FIRSTMACHINE , "_bottom"));
		topIcon = par1IconRegister.registerIcon(TexturesName.getTextureName(Block_Names.FIRSTMACHINE , "_top"));
		sideIcon = par1IconRegister.registerIcon(TexturesName.getTextureName(Block_Names.FIRSTMACHINE , "_side"));
		disableIcon = par1IconRegister.registerIcon(TexturesName.getTextureName(Block_Names.FIRSTMACHINE , "_disabled"));
		
		sideIcons  = new IIcon[4];
		sideIcons[0] = sideIcon;
		sideIcons[1] = par1IconRegister.registerIcon(TexturesName.getTextureName(Block_Names.FIRSTMACHINE,"_side_border"));
		sideIcons[2] = par1IconRegister.registerIcon(TexturesName.getTextureName(Block_Names.FIRSTMACHINE , "_side_x"));
		sideIcons[3] = par1IconRegister.registerIcon(TexturesName.getTextureName(Block_Names.FIRSTMACHINE , "_side_arrow"));
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		switch (par1) {
		case 0: {
			return bottomIcon;
		}
		case 1: {
			return isDisabled(par2) ? disableIcon : topIcon;
		}
		default: {

			int texture = (par2 & 14) / 2;

			return sideIcons[texture];
		}
		}
	}

	@Override
	public int damageDropped(int meta) {
		return meta & 14;
	}

	private boolean isDisabled(int meta) {
		return (meta & 1) == 1;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z,Block id) {
		int meta = world.getBlockMetadata(x, y, z);
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)
				&& !isDisabled(meta)) {

			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TileEntityFirstMachine) {

				TileEntityFirstMachine machine = (TileEntityFirstMachine) te;

				switch (meta / 2) {
				case 0: {
					spawnAnvil(world, machine, x, y + 20, z);
					break;
				}
				case 3: {
					for (int i = 0; i < 5; i++) {
						spawnAnvil(world, machine, x, y + 20 + i, z);
					}
					break;
				}
				case 1: {
					for (int i = -1; i <= 1; i++) {
						spawnAnvil(world, machine, x + i, y + 20, z - 2);
						spawnAnvil(world, machine, x + i, y + 20, z + 2);
						spawnAnvil(world, machine, x - 2, y + 20, z + i);
						spawnAnvil(world, machine, x + 2, y + 20, z + i);
					}
					break;
				}
				case 2: {
					for (int i = -2; i <= 2; i++) {
						spawnAnvil(world, machine, x + i, y + 20, z + i);
						spawnAnvil(world, machine, x - i, y + 20, z + i);
						spawnAnvil(world, machine, x + i, y + 20, z - i);
						spawnAnvil(world, machine, x - i, y + 20, z - i);
					}
				}
				}

			}
		}
	}

	private void spawnAnvil(World world, IInventory inv, int x, int y, int z) {
		if (world.isAirBlock(x, y, z)) {
			for (int i = 0; i < inv.getSizeInventory(); i++) {
				ItemStack stack = inv.getStackInSlot(i);
				if (stack != null && Block.getBlockFromItem(stack.getItem())== Blocks.anvil) {
					inv.decrStackSize(i, 1);
					world.setBlock(x, y, z, Blocks.anvil);
					return;
				}
			}
		}
	}
	
	//createNewTileEntity(World world) replaced by public TileEntity createNewTileEntity(World var1, int var2)
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityFirstMachine();
	}
}
