package bb.mods.bbbc.unrelated.block;

import bb.mods.bbbc.core.block.ConnectedBlock;
import bb.mods.bbbc.core.references.RenderIDS;
import bb.mods.bbbc.core.util.UnlocalizedNames;
import bb.mods.bbbc.unrelated.references.Block_Names;
import bb.mods.bbbc.unrelated.references.Resources;
import bb.mods.bbbc.unrelated.tileentity.TileEntityFace;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Faceblock extends ConnectedBlock {

	public Faceblock() {

		super(Material.wood);
        RLocation = Resources.BIGBLOCK_RL;
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
    public int getRenderType() {
        return RenderIDS.connectedRender;
    }

}
