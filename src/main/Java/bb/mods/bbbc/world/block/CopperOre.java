package bb.mods.bbbc.world.block;

import bb.mods.bbbc.world.references.Block_Names;
import bb.mods.bbbc.core.util.TexturesName;
import bb.mods.bbbc.core.util.UnlocalizedNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CopperOre extends Block {

	public static int shiftedIndex;

	public CopperOre() {
		super(Material.rock);
		setHardness(2.0f);
		setResistance(5.0f);
		setStepSound(soundTypeStone);
		setCreativeTab(CreativeTabs.tabBlock);
		setLightLevel(1.5F);
		setBlockName(UnlocalizedNames.getUnlocalizedName(Block_Names.BLOCKOREONE));

	}
	
	public IIcon getIcon(int par1, int par2) {

		return this.blockIcon;

	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon) {
		blockIcon = icon.registerIcon(TexturesName.getTextureName(Block_Names.BLOCKOREONE));
	}

}
