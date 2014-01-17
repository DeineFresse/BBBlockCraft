package bb.mods.bbbc.world.gen.structure;

import bb.mods.bbbc.core.lib.ReplaceList;
import bb.mods.bbbc.world.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class Spacetest1 {

	public static boolean isReplaceable(Block ID,Block ID2) {
		boolean is = false;
		for (int i = 0; i < ReplaceList.getReplaceList().length; i++) {
			if (ID == ReplaceList.getReplaceList()[i] || ID == ID2) {
				is = true;
			}
		}

		return is;

	}
		
	public static int airtest(World par1, int par2, int par3, int par4,
			EntityPlayer par5,Block ID,int whith,int lenght,int hight) {
		for(int i = 0;i<=whith;i++){
			for(int ii = 0;ii<=lenght;ii++){
				for(int iii = 0;iii<=hight;iii++){
					if(!isReplaceable(par1.func_147439_a(par2+i, par3+iii, par4+ii), ID)){
						return 0;
					}
				}
			}
		}
		
		
		return 1;
	}

	@SuppressWarnings("unused")
	public static boolean airnorth(World par1, int par2, int par3, int par4,
			EntityPlayer par5,Block ID) {
		int x;
		int y = par3;
		int z;
		String s;
		do {
			x = par2 + 4;
			do {
				z = par4 + 1;
				do {
					if (!isReplaceable(par1.func_147439_a(x, y, z), ID)) {
						if (!par5.worldObj.isRemote && Reference.DEBUGMODE) {
						}
						return false;
					}
					z--;
				} while (z > par4 - 9);
				x--;
			} while (x > (par2 - 5));
			y++;
		} while (y < (par3 + 7));
		return true;
	}

	@SuppressWarnings("unused")
	public static boolean airsouth(World par1, int par2, int par3, int par4,
			EntityPlayer par5, Block ID) {

		int x;
		int y = par3;
		int z;
		String s;
		Block i;
		do {
			x = par2 + 4;
			do {
				z = par4 + 8;
				do {
					if (!isReplaceable(par1.func_147439_a(x, y, z), ID)) {
						if (!par5.worldObj.isRemote && Reference.DEBUGMODE) {
							i = par1.func_147439_a(x, y, z);
						}
						return false;
					}
					z--;
				} while (z > par4 - 2);
				x--;
			} while (x > (par2 - 5));
			y++;
		} while (y < (par3 + 7));
		return true;
	}

	@SuppressWarnings("unused")
	public static boolean airwest(World par1, int par2, int par3, int par4,
			EntityPlayer par5, Block ID) {
		int x;
		int y = par3;
		int z;
		String s;
		do {
			x = par2 + 1;
			do {
				z = par4 - 4;
				do {
					if (!isReplaceable(par1.func_147439_a(x, y, z), ID)) {
						if (!par5.worldObj.isRemote && Reference.DEBUGMODE) {
						}
						return false;
					}
					z++;
				} while (z <= par4 + 4);
				x--;
			} while (x > (par2 - 9));
			y++;
		} while (y < (par3 + 7));
		return true;
	}

	@SuppressWarnings("unused")
	public static boolean aireast(World par1, int par2, int par3, int par4,
			EntityPlayer par5,Block ID) {
		int x;
		int y = par3;
		int z;
		String s;
		int i;
		do {
			x = par2 + 8;
			do {
				z = par4 - 4;
				do {
					if (!isReplaceable(par1.func_147439_a(x, y, z), ID)) {
						if (!par5.worldObj.isRemote && Reference.DEBUGMODE) {
						}
						return false;
					}
					z++;
				} while (z <= par4 + 4);
				x--;
			} while (x > (par2 - 2));
			y++;
		} while (y < (par3 + 7));
		return true;
	}

}
