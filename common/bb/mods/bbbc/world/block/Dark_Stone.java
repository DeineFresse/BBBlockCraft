package bb.mods.bbbc.world.block;

import bb.mods.bbbc.world.lib.Block_Names;
import bb.mods.bbbc.core.lib.TexturesName;
import bb.mods.bbbc.core.lib.UnlocalizedNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Dark_Stone extends Block {

	public static int shiftedIndex;

	public Dark_Stone() {
		super(Material.rock);
		setHardness(2.0f);
		setResistance(5.0f);
		setStepSound(soundTypeStone);
		setCreativeTab(CreativeTabs.tabBlock);
		setLightLevel(1.5F);
		setBlockName(UnlocalizedNames.getUnlocalizedName(Block_Names.DARKSTONE));

	}

	@SideOnly(Side.CLIENT)
	public static IIcon topIcon;

	public IIcon getIcon(int par1, int par2) {

		return this.blockIcon;

	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon) {
		blockIcon = icon.registerIcon(TexturesName.getTextureName(Block_Names.DARKSTONE));
	}

}
