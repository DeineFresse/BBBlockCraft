package bb.mods.bbbc.unrelated.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import bb.mods.bbbc.core.lib.TexturesName;
import bb.mods.bbbc.core.lib.UnlocalizedNames;
import bb.mods.bbbc.unrelated.lib.Block_Names;
import bb.mods.bbbc.world.gen.structure.CheckHouse;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TestBlock extends Block {

	int ID;

	public TestBlock(int blockID) {

		super(blockID, Material.rock);
		setHardness(2.0f);
		setResistance(5.0f);
		setStepSound(soundStoneFootstep);
		setCreativeTab(CreativeTabs.tabBlock);
		ID = blockID;
		setUnlocalizedName(UnlocalizedNames
				.getUnlocalizedName(Block_Names.TESTBLOCK));

	}

	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		CheckHouse
				.HouseBuild(par1World, par2, par3, par4, par5EntityPlayer, ID);
		super.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
		return true;

	}

	@SideOnly(Side.CLIENT)
	public static Icon topIcon;
	@SideOnly(Side.CLIENT)
	public static Icon bottomIcon;
	@SideOnly(Side.CLIENT)
	public static Icon sideIcon;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		topIcon = icon.registerIcon(TexturesName.getTextureName(
				Block_Names.TESTBLOCK.toLowerCase(), "_top"));
		bottomIcon = icon.registerIcon(TexturesName.getTextureName(
				Block_Names.TESTBLOCK.toLowerCase(), "_bottom"));
		sideIcon = icon.registerIcon(TexturesName.getTextureName(
				Block_Names.TESTBLOCK.toLowerCase(), "_side"));
	}

	@SuppressWarnings("static-access")
	public Icon getIcon(int par1, int par2) {

		switch (par1) {
		case 1:
			return this.topIcon;
		case 0:
			return this.bottomIcon;
		default:
			return this.sideIcon;
		}

	}
}
