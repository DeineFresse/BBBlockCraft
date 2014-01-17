package bb.mods.bbbc.unrelated.item;

import bb.mods.bbbc.unrelated.block.block;
import bb.mods.bbbc.unrelated.lib.Block_Names;
import bb.mods.bbbc.unrelated.lib.LoadedIDs;
import bb.mods.bbbc.core.lib.ReplaceList;
import bb.mods.bbbc.core.lib.UnlocalizedNames;
import bb.mods.bbbc.unrelated.tileentity.TileEntityFace;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BigBlockItem extends ItemBlock {

	public BigBlockItem(Block block) {

		super(block);
		setUnlocalizedName(UnlocalizedNames.getUnlocalizedName(Block_Names.BIGBLOCK));


	}

	@Override
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world,
			int x, int y, int z, int side, float xOffset, float yOffset,
			float zOffset) {

		if (!player.capabilities.isCreativeMode) {
			--item.stackSize;
		}

		if (!world.isRemote) {

			y++;

			int dir = MathHelper
					.floor_double((double) ((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;

			int[][] gagShift = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 },
					{ 0, 1, 1 }, { 0, 1, 0 }, { 1, 0, 0 }, { 0, 0, 1 } };
			int[] shift;

			boolean canPlace = true;
			for (int i = 0; i < gagShift.length; i++) {
				shift = rotXZByDir(gagShift[i][0], gagShift[i][1],
						gagShift[i][2], dir);

				if (!world.isAirBlock(x + shift[0], y + shift[1], z + shift[2])
						&& !isReplaceable(world.func_147439_a(x + shift[0], y
								+ shift[1], z + shift[2]))) {

					canPlace = false;
				}

			}

			if (canPlace) {

				world.setBlock(x, y, z,
						bb.mods.bbbc.unrelated.block.BigBlock.shiftedIndex, dir, 0x02);

				for (int i = 0; i < gagShift.length; i++) {
					shift = rotXZByDir(gagShift[i][0], gagShift[i][1],
							gagShift[i][2], dir);
					world.setBlock(x + shift[0], y + shift[1], z + shift[2],
							block.Faceblock, dir, 0x02);

					TileEntityFace tileFace = (TileEntityFace) world
							.getBlockTileEntity(x + shift[0], y + shift[1], z
									+ shift[2]);

					if (tileFace != null) {
						tileFace.primary_x = x;
						tileFace.primary_y = y;
						tileFace.primary_z = z;
						tileFace.dir = dir;
						tileFace.position = i;
					}

				}

			}

			return true;
		}
		return false;
	}

	private boolean isReplaceable(Block block) {

		for (int i = 0; i < ReplaceList.getReplaceList().length; i++) {
			if (block == ReplaceList.getReplaceList()[i]) {
				return true;
			}
		}

		return false;
	}

	public int[] rotXZByDir(int x, int y, int z, int dir) {
		if (dir == 0) {
			return new int[] { x, y, z };
		} else if (dir == 1) {
			return new int[] { -z, y, x };
		} else if (dir == 2) {
			return new int[] { -x, y, -z };
		} else {
			return new int[] { z, y, -x };
		}
	}

}
