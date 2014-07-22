package bb.mods.bbbc.unrelated.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import bb.mods.bbbc.core.util.TexturesName;
import bb.mods.bbbc.core.util.UnlocalizedNames;
import bb.mods.bbbc.unrelated.common.proxy.ClientProxy;
import bb.mods.bbbc.unrelated.item.item;
import bb.mods.bbbc.unrelated.references.Block_Names;
import bb.mods.bbbc.unrelated.tileentity.TileEntityRenderTest;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderTestBlock extends BlockContainer {

	public RenderTestBlock() {
		super(Material.clay);
		setCreativeTab(CreativeTabs.tabBlock);
		setResistance(1);
		setHardness(1);
		setLightLevel(0.5F);
		setBlockName(UnlocalizedNames.getUnlocalizedName(Block_Names.RTB));
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4,
			Block par5, int par6) {
		TileEntity te = par1World.getTileEntity(par2, par3, par4);
		if (te != null&&te instanceof TileEntityRenderTest) {
			TileEntityRenderTest fish = (TileEntityRenderTest) te;

			for (int i = 0; i < fish.fishA.size(); i++) {
				
				

				if (fish.fishA.get(i) != null) {
					float spawnX = par2 + par1World.rand.nextFloat();
					float spawnY = par3 + par1World.rand.nextFloat();
					float spawnZ = par4 + par1World.rand.nextFloat();

					EntityItem droppedItem = new EntityItem(par1World, spawnX,
							spawnY, spawnZ, new ItemStack(Items.fish,1,0));

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
	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		ItemStack a = par5EntityPlayer.getHeldItem();
		TileEntityRenderTest te = null;
		try {
			te = (TileEntityRenderTest) par1World
					.getTileEntity(par2, par3, par4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (a != null) {
			if (a.getItem() == Items.fish) {

				if (!par5EntityPlayer.capabilities.isCreativeMode) {
					int slot = par5EntityPlayer.inventory.currentItem;
					a.stackSize--;
					par5EntityPlayer.inventory
							.setInventorySlotContents(slot, a);
					System.out.println("Tada");
				}
				
				if(te!=null){
					te.addfish();
				}
			
				return true;
			}
			if(a.getItem() == item.MyFirstItem){
				int dir = MathHelper.floor_double((double) ((par5EntityPlayer.rotationYaw * 4F) / 360F) + 0.5D) & 3;
				System.out.println(dir);
				switch(dir){
				case 0:{
					if(te!=null){
						te.sides^=4;
					}
					break;
				}
				case 1:{
					if(te!=null){
						te.sides^=2;
					}
					break;
				}
				case 2:{
					if(te!=null){
						te.sides^=1;
					}
					break;
				}
				case 3:{
					if(te!=null){
						te.sides^=8;
					}
					break;
				}
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random) {
		super.updateTick(par1World, par2, par3, par4, par5Random);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getRenderType() {
		return ClientProxy.testRender;
	}

	@Override
	public boolean canRenderInPass(int pass) {

		ClientProxy.rederPass = pass;

		return true;
	}

	@SideOnly(Side.CLIENT)
	IIcon blockIcon;

	@Override
	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_,
			int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
		return false;
	}
	
	@Override
	public IIcon getIcon(IBlockAccess par1iBlockAccess, int par2,
			int par3, int par4, int par5) {
		return blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		blockIcon = icon.registerIcon(TexturesName.getTextureName(
				Block_Names.TESTBLOCK.toLowerCase(), "_top"));
	}

	@Override
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public TileEntity createNewTileEntity(World world,int kp) {
		return new TileEntityRenderTest();
	}

}
