package bb.mods.bbbc.unrelated.block;

import bb.mods.bbbc.core.references.Reference;
import bb.mods.bbbc.unrelated.references.Block_Names;
import bb.mods.bbbc.core.block.ConnectedBlock;
import bb.mods.bbbc.core.util.TexturesName;
import bb.mods.bbbc.core.util.UnlocalizedNames;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BigBlock extends ConnectedBlock {

	public static int shiftedIndex;

	@SideOnly(Side.CLIENT)
	IIcon[][] blockIcon;

	public BigBlock() {
		super(Material.rock,new ResourceLocation( Reference.MOD_RESOURCE_LOC,""));
		setHardness(2.0f);
		setResistance(5.0f);
		setStepSound(soundTypeStone);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName(UnlocalizedNames.getUnlocalizedName(Block_Names.BIGBLOCK));

	}

	@SideOnly(Side.CLIENT)
	public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int par2,
			int par3, int par4, int par5) {
		return this.blockIcon[0][0];
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return this.blockIcon[0][0];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {

		blockIcon = new IIcon[16][16];

		for (int i = 0; i < blockIcon.length; i++) {
			if (i == 15) {
				for (int ii = 0; ii < blockIcon[i].length; ii++) {
					this.blockIcon[i][ii] = icon.registerIcon(TexturesName
							.getTextureName(Block_Names.BIGBLOCK + ".",
									Block_Names.BIGBLOCK + i, "_" + ii));
				}
			} else if (i == 5 || i == 6 || i == 9 || i == 10) {
				for (int ii = 0; ii < blockIcon[i].length; ii++) {
					int x = ii & 1;
					this.blockIcon[i][ii] = icon.registerIcon(TexturesName
							.getTextureName(Block_Names.BIGBLOCK + ".",
									Block_Names.BIGBLOCK + i, "_" + x));
				}

			} else if (isAdvanced(i)) {
				for (int ii = 0; ii < blockIcon[i].length; ii++) {
					int x = ii & 3;
					this.blockIcon[i][ii] = icon.registerIcon(TexturesName
							.getTextureName(Block_Names.BIGBLOCK + ".",
									Block_Names.BIGBLOCK + i, "_" + x));
				}
			} else {
				for (int ii = 0; ii < blockIcon[i].length; ii++) {
					this.blockIcon[i][ii] = icon.registerIcon(TexturesName
							.getTextureName(Block_Names.BIGBLOCK + ".",
									Block_Names.BIGBLOCK + i, "_" + 0));
				}
			}
		}

	}

	private boolean isAdvanced(int is) {
		int[] advanced = new int[] { 5, 6, 7, 9, 10, 11, 13, 14, 15 };
		for (int i = 0; i < advanced.length; i++) {
			if (is == advanced[i]) {
				return true;
			}
		}

		return false;
	}
}
