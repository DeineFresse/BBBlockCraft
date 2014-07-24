package bb.mods.bbbc.unrelated.block;

import java.io.File;

import bb.mods.bbbc.core.references.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import bb.mods.bbbc.core.block.ConnectedBlock;
import bb.mods.bbbc.core.util.TexturesName;
import bb.mods.bbbc.core.util.UnlocalizedNames;
import bb.mods.bbbc.unrelated.references.Block_Names;
import bb.mods.bbbc.unrelated.tileentity.TileEntityFace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Faceblock extends ConnectedBlock {

	@SideOnly(Side.CLIENT)
	IIcon[][] blockIIcon = new IIcon[16][16];

	public static final int shiftedIndex = 165;

	public Faceblock() {

		super(Material.wood,new ResourceLocation( Reference.MOD_RESOURCE_LOC,""));

		setBlockName(UnlocalizedNames
				.getUnlocalizedName(Block_Names.FACEBLOCK));

	}

	public TileEntity createTileEntity(World world, int metadata) {
		return new TileEntityFace();
	}

	public void breakBlock(World world, int x, int y, int z, int p, int t) {

		TileEntityFace tileEntiy = (TileEntityFace) world.getTileEntity(x,
				y, z);

		if (tileEntiy != null) {
			if (world.getBlock(tileEntiy.primary_x, tileEntiy.primary_y,
					tileEntiy.primary_z) == block.BigBlock)
				world.setBlockToAir(tileEntiy.primary_x, tileEntiy.primary_y,
						tileEntiy.primary_z);

			// world.removeBlockTileEntity(tileEntiy.primary_x,
			// tileEntiy.primary_y, tileEntiy.primary_z);

		}

		world.removeTileEntity(x, y, z);

	}

	@SideOnly(Side.CLIENT)
	public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int par2,
			int par3, int par4, int par5) {
		return this.blockIIcon[0][0];
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIIcon(int par1, int par2) {
		return this.blockIIcon[0][0];
	}

	@SideOnly(Side.CLIENT)
	public void registerIIcons(IIconRegister IIcon) {
		
		for (int i = 0; i < blockIIcon.length; i++) {
			if (i == 15) {
				for (int ii = 0; ii < blockIIcon[i].length; ii++) {
					this.blockIIcon[i][ii] = IIcon.registerIcon(TexturesName.getTextureName(Block_Names.BIGBLOCK,File.separator,Block_Names.BIGBLOCK+ i,"_"+ ii));
				}
			} else if (i == 5 || i == 6 || i == 9 || i == 10) {
				for (int ii = 0; ii < blockIIcon[i].length; ii++) {
					int x = ii & 1;
					this.blockIIcon[i][ii] = IIcon.registerIcon(TexturesName.getTextureName(Block_Names.BIGBLOCK, File.separator,Block_Names.BIGBLOCK
							+ i
							, "_"
							+ x));
				}

			} else if (isAdvanced(i)) {
				for (int ii = 0; ii < blockIIcon[i].length; ii++) {
					int x = ii & 3;
					this.blockIIcon[i][ii] = IIcon.registerIcon(TexturesName.getTextureName(Block_Names.BIGBLOCK, File.separator
							, Block_Names.BIGBLOCK
							+ i
							, "_"
							+ x));
				}
			} else {
				for (int ii = 0; ii < blockIIcon[i].length; ii++) {
					this.blockIIcon[i][ii] = IIcon.registerIcon(TexturesName.getTextureName(Block_Names.BIGBLOCK
							, File.separator
							, Block_Names.BIGBLOCK
							+ i
							, "_"
							+ 0));
				}
			}
		}
		
		blockIcon = blockIIcon[0][0];

	}

	private boolean isAdvanced(int is) {
		int[] advanced = new int[] { 5, 6, 7, 9, 10, 11, 13, 14, 15 };
        for (int anAdvanced : advanced) {
            if (is == anAdvanced) {
                return true;
            }
        }

		return false;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block p) {
		TileEntityFace tileEntiy = (TileEntityFace) world.getTileEntity(x,
				y, z);

		if (tileEntiy != null) {
			if (world.getBlock(tileEntiy.primary_x, tileEntiy.primary_y,
					tileEntiy.primary_z) != Blocks.air
					|| world.getBlock(tileEntiy.primary_x,
							tileEntiy.primary_y, tileEntiy.primary_z) != block.BigBlock) {

				world.setBlockToAir(x, y, z);
				world.removeTileEntity(x, y, z);

			}
		} else {
			world.setBlockToAir(x, y, z);
			world.removeTileEntity(x, y, z);

		}

	}

	@Override
	public boolean isOpaqueCube() {
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return null;
	}

}
