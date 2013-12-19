package bb.mods.bbbc.world.gen.structure.basic;

import net.minecraft.world.World;

public class Forms {

	public static boolean isInArray(int[] a, int n) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == n) {
				return true;
			}
		}
		return false;
	}

	public static void wall(World par1, int x, int y, int z, int l�nge,
			int breite, int h�he, int Block) {
		for (int i = 0; i < h�he; i++) {
			rectanglehollow(par1, x, y + i, z, l�nge, breite, Block);
		}
	}

	public static void rectanglehollow(World par1, int x, int y, int z,
			int lang, int breit, int dir, int Block) {

		int[] check = new int[] { 53, 67, 108, 109, 114, 128, 134, 135, 136,
				156 };

		if (isInArray(check, Block)) {
			for (int i = 0; i < lang; i++) {
				switch (dir) {
				case 0: {
					par1.setBlock(x + i, y, z, Block);
					par1.setBlock(x + i, y, z + breit - 1, Block);
				}
				case 1: {
					par1.setBlock(x + i, y, z, Block);
					par1.setBlock(x + i, y, z - breit + 1, Block);
				}
				case 2: {					
					par1.setBlock(x - i, y, z, Block);
					par1.setBlock(x - i, y, z - breit + 1, Block);

				}
				case 3: {
					par1.setBlock(x - i, y, z, Block);
					par1.setBlock(x - i, y, z + breit - 1, Block);
				}
				}
			}
			for (int i = 0; i < breit; i++) {
				par1.setBlock(x, y, z + i, Block);
				par1.setBlock(x + lang - 1, y, z + i, Block);
			}
		} else {
			for (int i = 0; i < lang; i++) {
				par1.setBlock(x + i, y, z, Block, 2, 0x01);
				par1.setBlock(x + i, y, z + breit - 1, Block, 3, 0x01);
			}
			for (int i = 0; i < breit; i++) {
				par1.setBlock(x, y, z + i, Block, 0, 0x01);
				par1.setBlock(x + lang - 1, y, z + i, Block, 1, 0x01);
			}

		}

	}

	//@Deprecated
	public static void rectanglehollow(World par1, int x, int y, int z,
			int lang, int breit, int Block) {

		if (Block != 53 && Block != 67 && Block != 108 && Block != 109
				&& Block != 114 && Block != 128 && Block != 134 && Block != 135
				&& Block != 136 && Block != 156) {
			for (int i = 0; i < lang; i++) {
				par1.setBlock(x + i, y, z, Block);
				par1.setBlock(x + i, y, z + breit - 1, Block);
			}
			for (int i = 0; i < breit; i++) {
				par1.setBlock(x, y, z + i, Block);
				par1.setBlock(x + lang - 1, y, z + i, Block);
			}
		} else {
			for (int i = 0; i < lang; i++) {
				par1.setBlock(x + i, y, z, Block, 2, 3);
				par1.setBlock(x + i, y, z + breit - 1, Block, 3, 3);
			}
			for (int i = 0; i < breit; i++) {
				par1.setBlock(x, y, z + i, Block, 0, 0x01);
				par1.setBlock(x + lang - 1, y, z + i, Block, 1, 3);
			}

		}

	}

	/**
	 * @param par1
	 *            World
	 * @param x
	 *            x-Koordinate
	 * @param y
	 *            y-Koordinate
	 * @param z
	 *            z-Koordinare
	 * @param ID
	 *            BlockId
	 **/
	public static void rectanglefull(World par1, int x, int y, int z, int lang,
			int breit, int ID) {
		for (int i = 0; i < lang; i++) {
			for (int ii = 0; ii < breit; ii++) {
				par1.setBlock(x + i, y, z + ii, ID);
			}
		}

	}
	
	
	/*
			 * switch (f) { case (0): { par1.setBlock(x, y, z, ID, 1, 0x01);
			 * par1.setBlock(x, y + 1, z, ID, 9, 0x01); break; } case (1): {
			 * par1.setBlock(x, y, z, ID, 2, 0x01); par1.setBlock(x, y + 1, z,
			 * ID, 10, 0x01); break; } case (2): { par1.setBlock(x, y, z, ID, 3,
			 * 0x01); par1.setBlock(x, y + 1, z, ID, 11, 0x01); break; } case
			 * (3): { par1.setBlock(x, y, z, ID, 0, 0x01); par1.setBlock(x, y +
			 * 1, z, ID, 8, 0x01); break; } }
			 */

	public static void door(World par1, int x, int y, int z, int f, int ID) {
		if (ID == 64 || ID == 71) {
			int dir = (f + 1) & 3;
			par1.setBlock(x, y, z, ID, dir, 3);
			par1.setBlock(x, y + 1, z, ID, dir ^ 8, 3);

			

		}
	}

}
