package bb.mods.bbbc.world.gen.structure.basic;

import net.minecraft.world.World;

public class Forms {
	
	
	public static void wall(World par1,int x,int y,int z,int länge,int breite,int höhe,int Block){
		for(int i=0;i<höhe;i++){
			rectangle(par1,x,y+i,z,länge,breite,Block);
		}
	}

	public static void rectangle(World par1, int x, int y, int z, int lang,
			int breit, int Block) {

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
				par1.setBlock(x + i, y, z, Block, 2, 0x01);
				par1.setBlock(x + i, y, z + breit - 1, Block, 3, 0x01);
			}
			for (int i = 0; i < breit; i++) {
				par1.setBlock(x, y, z + i, Block, 0, 0x01);
				par1.setBlock(x + lang - 1, y, z + i, Block, 1, 0x01);
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
	public static void square(World par1, int x, int y, int z, int lang,
			int breit, int ID) {
		for (int i = 0; i < lang; i++) {
			for (int ii = 0; ii < breit; ii++) {
				par1.setBlock(x + i, y, z + ii, ID);
			}
		}

	}

	public static void door(World par1, int x, int y, int z, int f, int ID) {
		if (ID == 64 || ID == 71) {
			switch (f) {
			case (0): {
				par1.setBlock(x, y, z, ID, 1, 0x01);
				par1.setBlock(x, y + 1, z, ID, 9, 0x01);
				break;
			}
			case (1): {
				par1.setBlock(x, y, z, ID, 2, 0x01);
				par1.setBlock(x, y + 1, z, ID, 10, 0x01);
				break;
			}
			case (2): {
				par1.setBlock(x, y, z, ID, 3, 0x01);
				par1.setBlock(x, y + 1, z, ID, 11, 0x01);
				break;
			}
			case (3): {
				par1.setBlock(x, y, z, ID, 0, 0x01);
				par1.setBlock(x, y + 1, z, ID, 8, 0x01);
				break;
			}
			}

		}
	}

}
