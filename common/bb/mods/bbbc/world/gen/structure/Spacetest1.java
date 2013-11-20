package bb.mods.bbbc.world.gen.structure;

import bb.mods.bbbc.lib.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class Spacetest1 {

	public static boolean isReplaceable(int ID, int ID2) {
		boolean is = false;
		for (int i = 0; i < Reference.getReplaceList().length; i++) {
			if (ID == Reference.getReplaceList()[i] || ID == ID2) {
				is = true;
			}
		}

		return is;

	}
		
	public static int airtest(World par1, int par2, int par3, int par4,
			EntityPlayer par5, int ID,int whith,int lenght,int hight) {
		for(int i = 0;i<=whith;i++){
			for(int ii = 0;ii<=lenght;ii++){
				for(int iii = 0;iii<=hight;iii++){
					if(!isReplaceable(par1.getBlockId(par2+i, par3+iii, par4+ii), ID)){
						return 0;
					}
				}
			}
		}
		
		
		return 1;
	}

	@SuppressWarnings("unused")
	public static boolean airnorth(World par1, int par2, int par3, int par4,
			EntityPlayer par5, int ID) {
		int x;
		int y = par3;
		int z;
		String s;
		int i;
		do {
			x = par2 + 4;
			do {
				z = par4 + 1;
				do {
					if (!isReplaceable(par1.getBlockId(x, y, z), ID)) {
						if (!par5.worldObj.isRemote && Reference.DEBUGMODE) {
							i = par1.getBlockId(x, y, z);
							Integer I = new Integer(i);
							s = I.toString();
							par5.addChatMessage(s);
						}
						return false;
					}
					if (x != par2 && y != par3 && z != par4) {
						par1.setBlock(x, y, z, 0);
					}
					if (Reference.DEBUGMODE) {
						if (par1.getBlockId(x, y, z) != 161)
							par1.setBlock(x, y, z, 20);
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
			EntityPlayer par5, int ID) {

		int x;
		int y = par3;
		int z;
		String s;
		int i;
		do {
			x = par2 + 4;
			do {
				z = par4 + 8;
				do {
					if (!isReplaceable(par1.getBlockId(x, y, z), ID)) {
						if (!par5.worldObj.isRemote && Reference.DEBUGMODE) {
							i = par1.getBlockId(x, y, z);
							Integer I = new Integer(i);
							s = I.toString();
							par5.addChatMessage(s);
						}
						par5.addChatMessage("X:" + x + " Y:" + y + " Z:" + z);
						return false;
					}
					if (Reference.DEBUGMODE) {
						if (par1.getBlockId(x, y, z) != 161)
							par1.setBlock(x, y, z, 20);
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
			EntityPlayer par5, int ID) {
		int x;
		int y = par3;
		int z;
		String s;
		int i;
		do {
			x = par2 + 1;
			do {
				z = par4 - 4;
				do {
					if (!isReplaceable(par1.getBlockId(x, y, z), ID)) {
						if (!par5.worldObj.isRemote && Reference.DEBUGMODE) {
							i = par1.getBlockId(x, y, z);
							Integer I = new Integer(i);
							s = I.toString();
							par5.addChatMessage(s);
						}
						par5.addChatMessage("X:" + x + " Y:" + y + " Z:" + z);
						return false;
					}
					if (Reference.DEBUGMODE) {
						if (par1.getBlockId(x, y, z) != 161) {
							par1.setBlock(x, y, z, 20);
						}
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
			EntityPlayer par5, int ID) {
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
					if (!isReplaceable(par1.getBlockId(x, y, z), ID)) {
						if (!par5.worldObj.isRemote && Reference.DEBUGMODE) {
							i = par1.getBlockId(x, y, z);
							Integer I = new Integer(i);
							s = I.toString();
							par5.addChatMessage(s);
						}
						par5.addChatMessage("X:" + x + " Y:" + y + " Z:" + z);
						return false;
					}
					if (Reference.DEBUGMODE) {
						if (par1.getBlockId(x, y, z) != 161) {
							par1.setBlock(x, y, z, 20);
						}
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
