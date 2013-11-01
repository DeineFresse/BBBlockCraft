package bb.mods.bbbc.world.gen.structure;

import bb.mods.bbbc.lib.Reference;
import bb.mods.bbbc.world.gen.structure.basic.Forms;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BrickHouse {

	static int[] BrickHouse = new int[]{45,108,0,47,64,71,49,89,116,44,4};
	static int Brick = 45; // 45
	static int BrickStair = 108; // 108
	static int Air = 0;
	static int BookShelf = 47; // 47
	static int doorWood = 64; // 64
	static int doorIron = 71; // 71
	static int obsidian = 49; // 49
	static int glowStone = 89; // 89
	static int entchantTable = 116; // 116
	static int BrickSlab = 44; // 44
	static int SlabMeta = 4; // 4

	static int[] Material;

	public static void BuildBrickHouse(World par1, int par2, int par3,
			int par4, EntityPlayer par5, int f,int ID) {
		Material = BrickHouse;

		if (!Reference.DEBUGMODE) {
			switch (f) {
			case 0: {
				build(par1, par2, par3, par4, par5,f,ID);
				break;
			}
			case 1: {
				build(par1, par2, par3, par4, par5,f,ID);
				break;
			}
			case 2: {
				build(par1, par2, par3, par4, par5,f,ID);
				break;
			}
			case 3: {
				build(par1, par2, par3, par4, par5,f,ID);
				break;
			}
			}

		}

	}

	public static void build(World par1, int par2, int par3, int par4,
			EntityPlayer par5, int o,int ID) {

		int[] xr = new int[4], xp = new int[17];
		int xs = 0, xd = 0;

		int[] stair = new int[]{0,0,0};
		
		int[] zr = new int[4], zp = new int[17];
		int zs = 0, zd = 0;

		for (int i = 0; i < xr.length; i++) {
			xr[i] = 0;
		}
		for (int i = 0; i < xp.length; i++) {
			xp[i] = 0;
		}
		for (int i = 0; i < zr.length; i++) {
			zr[i] = 0;
		}
		for (int i = 0; i < zp.length; i++) {
			zp[i] = 0;
		}

		switch (o) {
		case (0):{
			xr = new int[] { -3, -2, -4, -4 };
			xp = new int[] { 0, 0, 0, 1, 0, -1, -1, -1, 1, 1, 0, 0, 0, 1, -1,0, 0 };
			zr = new int[] { 1, 2, 0, 0 };
			zp = new int[] { 2, 2, 4, -1, -1,- 1, 3, 5, 3, 5, 4, 3, 5,4, 4, 0, 4 };
			zs = 1;
			zd = 1;
			xs = -3;
			xd = 0;
			stair = new int[]{1,2,0};
			break;
		}
		case (1):{
			xr = new int[] { -7, -6, -8, -8 };
			xp = new int[] { -2, -2, -4, 1, 1, 1, -5, -5, -3, -3, -4, -4, -4, -3, -5, 0, -4 };
			zr = new int[] {-3,-2,-4,-4};
			zp = new int[] { 0,0,0,1,0,-1,1,-1,1,-1,0,1,-1,0,0,0,0};
			zs = -3;
			zd = 0;
			xs = -7;
			xd = -1;
			stair = new int[]{3,1,2};
			break;
		}
		case (2): {
			xr = new int[] { -3, -2, -4, -4 };
			xp = new int[] { 0, 0, 0, 1, 0, -1, -1, -1, 1, 1, 0, 0, 0, 1, -1,0, 0 };
			zr = new int[] { -7, -6, -8, -8 };
			zp = new int[] { -2, -2, -4, 1, 1, 1, -3, -5, -3, -5, -4, -3, -5,-4, -4, 0, -4 };
			zs = -7;
			zd = -1;
			xs = -3;
			xd = 0;
			stair = new int[]{1,3,0};
			break;
		}
		case (3):{
			xr = new int[] { 1,2,0,0 };
			xp = new int[] { 2,2,4,-1,-1,-1,3,3,5,5,4,4,4,5,3,0,4,1 };
			zr = new int[] { -3,-2,-4,-4};
			zp = new int[] { 0,0,0,1,0,-1,1,-1,1,-1,0,1,-1,0,0,0,0};
			zs = -3;
			zd = 0;
			xs = 1;
			xd = 1;
			stair = new int[]{3,0,2};
			break;
		}
		}

		for (int i = 1; i < 4; i++) {
			Forms.rectangle(par1, par2 + xr[0], par3 + i, par4 + zr[0], 7, 7,
					Brick);
			Forms.rectangle(par1, par2 + xr[1], par3 + i, par4 + zr[1], 5, 5,
					BookShelf);
		}

		Forms.square(par1, par2 + xs, par3, par4 + zs, 7, 7, Brick);

		for (int i = 0; i < 4; i++) {
			Forms.rectangle(par1, par2 + xr[2] + i, par3 + 3 + i, par4 + zr[2]
					+ i, 9 - 2 * i, 9 - 2 * i, BrickStair);
		}

		Forms.rectangle(par1, par2 + xr[3], par3, par4 + zr[3], 9, 9,BrickStair);
		par1.setBlock(par2 + xp[0],  par3 + 1, par4 + zp[0],  Air);
		par1.setBlock(par2 + xp[1],  par3 + 2, par4 + zp[1],  Air);
		par1.setBlock(par2 + xp[2],  par3 + 1, par4 + zp[2],  entchantTable);
		par1.setBlock(par2 + xp[3],  par3,     par4 + zp[3],  BrickStair, stair[0], 0x01);
		par1.setBlock(par2 + xp[4],  par3,     par4 + zp[4],  BrickStair, stair[1], 0x01);
		par1.setBlock(par2 + xp[5],  par3,     par4 + zp[5],  BrickStair, stair[2], 0x01);
		par1.setBlock(par2 + xp[6],  par3,     par4 + zp[6],  obsidian);
		par1.setBlock(par2 + xp[7],  par3,     par4 + zp[7],  obsidian);
		par1.setBlock(par2 + xp[8],  par3,     par4 + zp[8],  obsidian);
		par1.setBlock(par2 + xp[9],  par3,     par4 + zp[9],  obsidian);
		par1.setBlock(par2 + xp[10], par3,     par4 + zp[10], obsidian);
		par1.setBlock(par2 + xp[11], par3,     par4 + zp[11], glowStone);
		par1.setBlock(par2 + xp[12], par3,     par4 + zp[12], glowStone);
		par1.setBlock(par2 + xp[13], par3,     par4 + zp[13], glowStone);
		par1.setBlock(par2 + xp[14], par3,     par4 + zp[14], glowStone);
		par1.setBlock(par2 + xp[15], par3,     par4 + zp[15], ID);
		par1.setBlock(par2 + xp[16], par3 + 7, par4 + zp[16], BrickSlab,SlabMeta, 0x01);
		Forms.door(par1, par2+xd, par3 + 1, par4 +zd, o, doorWood);
	}
}