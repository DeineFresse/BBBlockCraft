package bb.mods.bbbc.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import bb.mods.bbbc.lib.Block_Names;
import bb.mods.bbbc.lib.Reference;
import bb.mods.bbbc.lib.UnlocalizedNames;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CloudWhite extends Block {

	@SideOnly(Side.CLIENT)
	Icon[] iconArray;

	public CloudWhite(int blockID) {

		super(blockID, Material.cloth);
		setHardness(0.0f);
		setResistance(100.0f);
		setStepSound(soundClothFootstep);
		setCreativeTab(CreativeTabs.tabDecorations);
		setUnlocalizedName(UnlocalizedNames.getUnlocalizedName(Block_Names.CLOUDWHITE));
		setTextureName("wool_colored");

	}

	public void onEntityWalking(World par1World, int par2, int par3, int par4,
			Entity par5Entity) {
		if (par5Entity.worldObj.isRemote) {
			par5Entity.motionY = 2;
		}
		super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
	}

	public void onFallenUpon(World par1World, int par2, int par3, int par4,
			Entity par5Entity, float par6) {
		if (par5Entity.worldObj.isRemote) {
			par5Entity.motionY = 2;
		}
		super.onFallenUpon(par1World, par2, par3, par4, par5Entity, par6);
	}

	public void onEntityCollidedWithBlock(World par1World, int par2, int par3,
			int par4, Entity par5Entity) {

		par5Entity.fallDistance = 0;

		if (par5Entity.isCollidedVertically && !par5Entity.worldObj.isRemote) {
			par5Entity.motionY = 2;
		}
		super.onEntityCollidedWithBlock(par1World, par2, par3, par4, par5Entity);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconArray = new Icon[16];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon(Reference.MOD_ID
					.toLowerCase()
					+ ":"
					+ Block_Names.CLOUDWHITE.toLowerCase()
					+ i);
		}
	}

	public Icon getIcon(int par1, int par2) {

		return iconArray[par2];

	}

	public int getRenderBlockPass() {
		return 1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	/**
	 * From the specified side and block metadata retrieves the blocks texture.
	 * Args: side, metadata
	 */

	/**
	 * Determines the damage on the item the block drops. Used in cloth and
	 * wood.
	 */
	public int damageDropped(int par1) {
		return par1;
	}

	/**
	 * Takes a dye damage value and returns the block damage value to match
	 */
	public static int getBlockFromDye(int par0) {
		return ~par0 & 15;
	}

	/**
	 * Takes a block damage value and returns the dye damage value to match
	 */
	public static int getDyeFromBlock(int par0) {
		return ~par0 & 15;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		for (int var4 = 0; var4 < 16; ++var4) {
			par3List.add(new ItemStack(par1, 1, var4));
		}
	}

}
