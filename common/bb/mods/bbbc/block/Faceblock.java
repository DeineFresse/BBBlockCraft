package bb.mods.bbbc.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import bb.mods.bbbc.lib.Block_Names;
import bb.mods.bbbc.lib.LoadedIDs;
import bb.mods.bbbc.lib.Reference;
import bb.mods.bbbc.lib.UnlocalizedNames;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import bb.mods.bbbc.tileentity.TileEntityFace;

public class Faceblock extends BlockContainer {

	Icon[][] blockIcon = new Icon[17][16];

	public static final int shiftedIndex = 165;

	private int[] ids = new int[] { LoadedIDs.Block_BigBlock,
			LoadedIDs.Block_Faceblock, 20 };

	public Faceblock(int id) {

		super(id, Material.wood);

		setUnlocalizedName(UnlocalizedNames.getUnlocalizedName(Block_Names.FACEBLOCK));


	}

	public TileEntity createTileEntity(World world, int metadata) {
		return new TileEntityFace();
	}

	public void breakBlock(World world, int x, int y, int z, int p, int t) {

		TileEntityFace tileEntiy = (TileEntityFace) world.getBlockTileEntity(x,
				y, z);

		if (tileEntiy != null) {
			if (world.getBlockId(tileEntiy.primary_x, tileEntiy.primary_y,
					tileEntiy.primary_z) == LoadedIDs.Block_BigBlock)
				world.destroyBlock(tileEntiy.primary_x, tileEntiy.primary_y,
						tileEntiy.primary_z, false);

			// world.removeBlockTileEntity(tileEntiy.primary_x,
			// tileEntiy.primary_y, tileEntiy.primary_z);

		}

		world.removeBlockTileEntity(x, y, z);

	}

	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2,
			int par3, int par4, int par5) {
		int[] connected = Connected.getConnection(ids, par5, par1IBlockAccess,
				par2, par3, par4);

		return this.blockIcon[connected[0]][connected[1]];
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		return this.blockIcon[0][0];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {

		for (int i = 0; i < blockIcon.length; i++) {
			if (i == 15) {
				for (int ii = 0; ii < blockIcon[i].length; ii++) {
					this.blockIcon[i][ii] = icon.registerIcon(Reference.MOD_ID
							.toLowerCase()
							+ ":"
							+ Block_Names.BIGBLOCK
							+ i
							+ "_" + ii);
				}
			} else if (i == 5 || i == 6 || i == 9 || i == 10) {
				for (int ii = 0; ii < blockIcon[i].length; ii++) {
					int x = ii & 1;
					this.blockIcon[i][ii] = icon.registerIcon(Reference.MOD_ID
							.toLowerCase()
							+ ":"
							+ Block_Names.BIGBLOCK
							+ i
							+ "_" + x);
				}

			} else if (isAdvanced(i)) {
				for (int ii = 0; ii < blockIcon[i].length; ii++) {
					int x = ii & 3;
					this.blockIcon[i][ii] = icon.registerIcon(Reference.MOD_ID
							.toLowerCase()
							+ ":"
							+ Block_Names.BIGBLOCK
							+ i
							+ "_" + x);
				}
			} else {
				for (int ii = 0; ii < blockIcon[i].length; ii++) {
					this.blockIcon[i][ii] = icon.registerIcon(Reference.MOD_ID
							.toLowerCase()
							+ ":"
							+ Block_Names.BIGBLOCK
							+ i
							+ "_" + 0);
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

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int p) {
		TileEntityFace tileEntiy = (TileEntityFace) world.getBlockTileEntity(x,
				y, z);

		if (tileEntiy != null) {
			if (world.getBlockId(tileEntiy.primary_x, tileEntiy.primary_y,
					tileEntiy.primary_z) < 1
					|| world.getBlockId(tileEntiy.primary_x,
							tileEntiy.primary_y, tileEntiy.primary_z) != LoadedIDs.Block_BigBlock) {

				world.destroyBlock(x, y, z, false);
				world.removeBlockTileEntity(x, y, z);

			}
		} else {
			world.destroyBlock(x, y, z, false);
			world.removeBlockTileEntity(x, y, z);

		}

	}

	@Override
	public boolean isOpaqueCube() {
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}

}
