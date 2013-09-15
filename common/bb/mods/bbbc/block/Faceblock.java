package bb.mods.bbbc.block;

import bb.mods.bbbc.lib.Block_Names;
import bb.mods.bbbc.lib.LoadedIDs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import bb.mods.bbbc.tileentity.TileEntityFace;

public class Faceblock extends BlockContainer {

	public static final int shiftedIndex = 165;

	public Faceblock(int id) {

		super(id, Material.wood);

		setUnlocalizedName(Block_Names.FACEBLOCK);

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

			//world.removeBlockTileEntity(tileEntiy.primary_x,
				//	tileEntiy.primary_y, tileEntiy.primary_z);
			
		}
		
		world.removeBlockTileEntity(x, y, z);

	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int p) {
		TileEntityFace tileEntiy = (TileEntityFace) world.getBlockTileEntity(x,
				y, z);

		if (tileEntiy != null) {
			if (world.getBlockId(tileEntiy.primary_x, tileEntiy.primary_y,
					tileEntiy.primary_z) < 1||world.getBlockId(tileEntiy.primary_x, tileEntiy.primary_y,
							tileEntiy.primary_z)!=LoadedIDs.Block_BigBlock) {

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
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}

}
