package bb.mods.bbbc.core.render;

import net.minecraft.world.IBlockAccess;

public class Connected {
	
	/**
	 * 
	 * @param blockList = Blocks to connect with
	 * @param dir = side
	 * @param IBA = IBlockAccess
	 * @param x = X-Coordinate
	 * @param y = Y-Coordinate
	 * @param z = Z-Coordinate;
	 * @return int[],texture,sub-texture
     */

	public static int[] getConnection(int[] blockList, int dir,IBlockAccess IBA, int x, int y, int z) {
		byte Connected = 0;
		byte Corner = 0;

		int[] cCX = new int[4];
		int[] cCY = new int[4];
		int[] cCZ = new int[4];
		int AX = 0, AY = 0, AZ = 0;

		for (int i = 0; i < cCX.length && i < cCY.length && i < cCZ.length; i++) {
			cCX[i] = 0;
			cCY[i] = 0;
			cCZ[i] = 0;
		}

		switch (dir) {
		/** bottom **/
		case 0: {
			cCZ[0] = 1;
			cCZ[1] = -1;
			cCX[2] = 1;
			cCX[3] = -1;
			AY = -1;
			break;
		}
		/** top **/
		case 1: {
			cCZ[0] = 1;
			cCZ[1] = -1;
			cCX[2] = 1;
			cCX[3] = -1;
			AY = 1;
			break;
		}
		/** north **/
		case 2: {
			cCY[0] = -1;
			cCY[1] = 1;
			cCX[2] = -1;
			cCX[3] = 1;
			AZ = -1;
			break;
		}
		/** south **/
		case 3: {
			cCY[0] = -1;
			cCY[1] = 1;
			cCX[2] = 1;
			cCX[3] = -1;
			AZ = +1;
			break;
		}
		/** west **/
		case 4: {
			cCY[0] = -1;
			cCY[1] = 1;
			cCZ[2] = 1;
			cCZ[3] = -1;
			AX = -1;
			break;
		}
		/** east **/
		case 5: {
			cCY[0] = -1;
			cCY[1] = 1;
			cCZ[2] = -1;
			cCZ[3] = 1;
			AX = 1;
			break;
		}
		}

		if (canConnect(IBA.getBlockId(x + cCX[0], y + cCY[0], z + cCZ[0]),
				blockList)) {
			Connected |= 1;
		}
		if (canConnect(IBA.getBlockId(x + cCX[1], y + cCY[1], z + cCZ[1]),
				blockList)) {
			Connected |= 2;
		}
		if (canConnect(IBA.getBlockId(x + cCX[2], y + cCY[2], z + cCZ[2]),
				blockList)) {
			Connected |= 4;
		}
		if (canConnect(IBA.getBlockId(x + cCX[3], y + cCY[3], z + cCZ[3]),
				blockList)) {
			Connected |= 8;
		}
		// --------------------------------------------------------
		/** Rechts Unten **/
		if (canConnect(
				IBA.getBlockId(x + cCX[2] + cCX[0], y + cCY[2] + cCY[0], z
						+ cCZ[2] + cCZ[0]), blockList)) {
			switch (Connected) {
			case 15: {
			}
			case 13: {
			}
			case 7: {
			}
			case 5: {
				Corner |= 1;
				break;
			}
			}

		}
		/** Rechts Oben **/
		if (canConnect(
				IBA.getBlockId(x + cCX[2] + cCX[1], y + cCY[2] + cCY[1], z
						+ cCZ[2] + cCZ[1]), blockList)) {

			switch (Connected) {
			case 14: {
			}
			case 6: {
				Corner |= 1;
				break;
			}
			case 15: {
			}
			case 7: {
				Corner |= 2;
				break;
			}
			}

		}
		/** Links Unten **/
		if (canConnect(
				IBA.getBlockId(x + cCX[3] + cCX[0], y + cCY[3] + cCY[0], z
						+ cCZ[3] + cCZ[0]), blockList)) {
			switch (Connected) {
			case 11: {
			}
			case 9: {
				Corner |= 1;
				break;
			}
			case 13: {
				Corner |= 2;
				break;
			}
			case 15: {
				Corner |= 4;
				break;
			}
			}
		}
		/** Links Oben **/
		if (canConnect(
				IBA.getBlockId(x + cCX[1] + cCX[3], y + cCY[1] + cCY[3], z
						+ cCZ[1] + cCZ[3]), blockList)) {

			switch (Connected) {
			case 10: {
				Corner |= 1;
				break;
			}
			case 14: {
			}
			case 11: {
				Corner |= 2;
				break;
			}
			case 15: {
				Corner |= 8;
				break;
			}

			}

		}
		if (canConnect(IBA.getBlockId(x + AX, y + AY, z + AZ), blockList)&&IBA.getBlockId(x+AX, y+AY, z+AZ)!=0) {
			Connected = 15;
			Corner = 15;
		}
		return new int[] { Connected, Corner };
	}

	private static boolean canConnect(int blockId, int[] ids) {

		for (int i = 0; i < ids.length; i++) {
			if (blockId == ids[i]) {
				return true;
			}
		}

		return false;
	}
}