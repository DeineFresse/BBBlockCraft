package bb.mods.bbbc.block;

import net.minecraft.world.IBlockAccess;

public class Connected {

	public static int[] getConnection(int[] blockList, int dir,
			IBlockAccess IBA, int x, int y, int z) {
		byte Connected = 0;
		byte Corner = 0;

		switch (dir) {
		/** bottom **/
		case 0: {
			if (canConnect(IBA.getBlockId(x, y, z + 1), blockList)) {
				Connected |= 1;
			}
			if (canConnect(IBA.getBlockId(x, y, z - 1), blockList)) {
				Connected |= 2;
			}
			if (canConnect(IBA.getBlockId(x + 1, y, z), blockList)) {
				Connected |= 4;
			}
			if (canConnect(IBA.getBlockId(x - 1, y, z), blockList)) {
				Connected |= 8;
			}
			// --------------------------------------------------------
			/** Rechts Unten **/
			if (canConnect(IBA.getBlockId(x + 1, y, z + 1), blockList)) {
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
			if (canConnect(IBA.getBlockId(x + 1, y, z - 1), blockList)) {

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
			if (canConnect(IBA.getBlockId(x - 1, y, z + 1), blockList)) {
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
			if (canConnect(IBA.getBlockId(x - 1, y, z - 1), blockList)) {

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
			if (!IBA.isAirBlock(x, y - 1, z)) {
				Connected = 15;
			}
			break;
		}
		/** top **/
		case 1: {
			if (canConnect(IBA.getBlockId(x, y, z + 1), blockList)) {
				Connected |= 1;
			}
			if (canConnect(IBA.getBlockId(x, y, z - 1), blockList)) {
				Connected |= 2;
			}
			if (canConnect(IBA.getBlockId(x + 1, y, z), blockList)) {
				Connected |= 4;
			}
			if (canConnect(IBA.getBlockId(x - 1, y, z), blockList)) {
				Connected |= 8;
			}
			// --------------------------------------------------------
			/** Rechts Unten **/
			if (canConnect(IBA.getBlockId(x + 1, y, z + 1), blockList)) {
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
			if (canConnect(IBA.getBlockId(x + 1, y, z - 1), blockList)) {

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
			if (canConnect(IBA.getBlockId(x - 1, y, z + 1), blockList)) {
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
			if (canConnect(IBA.getBlockId(x - 1, y, z - 1), blockList)) {

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
			if (!IBA.isAirBlock(x, y + 1, z)) {
				Connected = 15;
			}
			break;
		}
		/** north **/
		case 2: {
			if (canConnect(IBA.getBlockId(x, y - 1, z), blockList)) {
				Connected |= 1;
			}
			if (canConnect(IBA.getBlockId(x, y + 1, z), blockList)) {
				Connected |= 2;
			}
			if (canConnect(IBA.getBlockId(x - 1, y, z), blockList)) {
				Connected |= 4;
			}
			if (canConnect(IBA.getBlockId(x + 1, y, z), blockList)) {
				Connected |= 8;
			}
			// --------------------------------------------------------
			/** Rechts Unten **/
			/** Rechts Unten **/
			if (canConnect(IBA.getBlockId(x - 1, y - 1, z), blockList)) {
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
			if (canConnect(IBA.getBlockId(x - 1, y + 1, z), blockList)) {

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
			if (canConnect(IBA.getBlockId(x + 1, y - 1, z), blockList)) {
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
			if (canConnect(IBA.getBlockId(x + 1, y + 1, z), blockList)) {

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
			if (!IBA.isAirBlock(x, y, z - 1)) {
				Connected = 15;
			}
			break;
		}
		/** south **/
		case 3: {
			if (canConnect(IBA.getBlockId(x, y - 1, z), blockList)) {
				Connected |= 1;
			}
			if (canConnect(IBA.getBlockId(x, y + 1, z), blockList)) {
				Connected |= 2;
			}
			if (canConnect(IBA.getBlockId(x + 1, y, z), blockList)) {
				Connected |= 4;
			}
			if (canConnect(IBA.getBlockId(x - 1, y, z), blockList)) {
				Connected |= 8;
			}
			// --------------------------------------------------------
			/** Rechts Unten **/
			if (canConnect(IBA.getBlockId(x + 1, y - 1, z), blockList)) {
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
			if (canConnect(IBA.getBlockId(x + 1, y + 1, z), blockList)) {

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
			if (canConnect(IBA.getBlockId(x - 1, y - 1, z), blockList)) {
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
			if (canConnect(IBA.getBlockId(x - 1, y + 1, z), blockList)) {

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
			if (!IBA.isAirBlock(x, y, z + 1)) {
				Connected = 15;
			}
			break;
		}

		/** west **/
		case 4: {
			if (canConnect(IBA.getBlockId(x, y - 1, z), blockList)) {
				Connected |= 1;
			}
			if (canConnect(IBA.getBlockId(x, y + 1, z), blockList)) {
				Connected |= 2;
			}
			if (canConnect(IBA.getBlockId(x, y, z + 1), blockList)) {
				Connected |= 4;
			}
			if (canConnect(IBA.getBlockId(x, y, z - 1), blockList)) {
				Connected |= 8;
			}
			// --------------------------------------------------------
			/** Rechts Unten **/
			if (canConnect(IBA.getBlockId(x, y - 1, z + 1), blockList)) {
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
			if (canConnect(IBA.getBlockId(x, y + 1, z + 1), blockList)) {

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
			if (canConnect(IBA.getBlockId(x, y - 1, z - 1), blockList)) {
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
			if (canConnect(IBA.getBlockId(x, y + 1, z - 1), blockList)) {

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
			if (!IBA.isAirBlock(x - 1, y, z)) {
				Connected = 15;
			}
			break;
		}

		/** east **/
		case 5: {
			if (canConnect(IBA.getBlockId(x, y - 1, z), blockList)) {
				Connected |= 1;
			}
			if (canConnect(IBA.getBlockId(x, y + 1, z), blockList)) {
				Connected |= 2;
			}
			if (canConnect(IBA.getBlockId(x, y, z - 1), blockList)) {
				Connected |= 4;
			}
			if (canConnect(IBA.getBlockId(x, y, z + 1), blockList)) {
				Connected |= 8;
			}
			// --------------------------------------------------------
			/** Rechts Unten **/
			if (canConnect(IBA.getBlockId(x, y - 1, z - 1), blockList)) {
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
			if (canConnect(IBA.getBlockId(x, y+1, z - 1), blockList)) {

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
			if (canConnect(IBA.getBlockId(x , y-1, z+ 1), blockList)) {
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
			if (canConnect(IBA.getBlockId(x, y+1, z + 1), blockList)) {

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
			if (!IBA.isAirBlock(x + 1, y, z)) {
				Connected = 15;
			}
			break;
		}
		}
		System.out.println("[BBBlockCraft:]Connected at the end:" + Connected);
		return new int[] { Connected, Corner };
	}

	private static boolean canConnect(int blockId, int[] ids) {

		for (int i = 0; i < ids.length; i++) {
			if (blockId == ids[i]) {
				System.out.println("[BBBlockCraft:]true");
				return true;
			}
		}

		return false;
	}
}
