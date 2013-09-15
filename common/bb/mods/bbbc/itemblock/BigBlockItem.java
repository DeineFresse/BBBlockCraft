package bb.mods.bbbc.itemblock;

import bb.mods.bbbc.lib.LoadedIDs;
import bb.mods.bbbc.tileentity.TileEntityFace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BigBlockItem extends ItemBlock {

	public BigBlockItem(int par1) {

		super(par1);

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

			int[][] gagShift = { { 1, 1, 1 }, { 1, 0, 1 } };
			int[] shift;

			boolean canPlace = true;
			for (int i = 0; i < gagShift.length; i++) {
				shift = rotXZByDir(gagShift[i][0],gagShift[i][1], gagShift[i][2], dir);

				if (!world.isAirBlock(x + shift[0], y + shift[1], z + shift[2])) {

					canPlace = false;
				}

			}

			if (canPlace) {
				
				world.setBlock(x,y,z,bb.mods.bbbc.block.BigBlock.shiftedIndex,dir,0x02);

				for(int i = 0;i< gagShift.length;i++){
					shift = rotXZByDir(gagShift[i][0],gagShift[i][1],gagShift[i][2],dir);
					world.setBlock(x +shift[0], y+shift[1], z+shift[2],LoadedIDs.Block_Faceblock,dir,0x02);
					
					TileEntityFace tileFace = (TileEntityFace)world.getBlockTileEntity(x+shift[0],y+shift[1],z+shift[2]);
					
					if(tileFace != null){
						tileFace.primary_x = x;
						tileFace.primary_y = y;
						tileFace.primary_z = z;
					}
					
				}
				
			}

			return true;
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
