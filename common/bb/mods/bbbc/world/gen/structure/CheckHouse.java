package bb.mods.bbbc.world.gen.structure;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class CheckHouse {

	/**
	 * @param par2
	 *            x
	 * @param par3
	 *            y
	 * @param par4
	 *            z
	 * **/
	
	public static void HouseBuild(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, Block ID) {

		int dir = 0;
		dir = MathHelper
				.floor_double((double) (par5EntityPlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		int Ergebnis = Houscheck(par1World, par2, par3, par4, dir,
				par5EntityPlayer, ID);

		boolean isRemote = par5EntityPlayer.worldObj.isRemote;

		String ss = null;

		if (!isRemote) {
			Integer I = new Integer(Ergebnis);
			String s = I.toString();
			Integer II = new Integer(dir);
			ss = II.toString();
			par5EntityPlayer.addChatMessage(ss);
			par5EntityPlayer.addChatMessage(s);

			switch (Ergebnis) {
			case 0: {
				par5EntityPlayer
						.addChatMessage("Building was not possible,to less space!");
				break;
			}
			case 1: {
				par5EntityPlayer.addChatMessage("Building is Possible!");
				BuildStructur.BuildBrickHouse(par1World, par2, par3, par4,
						par5EntityPlayer, dir);
				break;
			}
			case 2: {
				par5EntityPlayer
						.addChatMessage("Build not possible,ERROR,unexpacted Output from Methode Housecheck ("
								+ ss + ")");
				break;
			}
			case 3: {
				// is Client ,do nothing
			}
			}
		}
	}

	private static int Houscheck(World par1, int par2, int par3, int par4,
			int dir, EntityPlayer par6, Block ID) {
		if (!par1.isRemote) {
			switch (dir) {
			case 0: {
				if (Spacetest1.airsouth(par1, par2, par3, par4, par6, ID)) {
					return 1;
				} else {
					return 0;
				}
			}
			case 1: {
				if (Spacetest1.airwest(par1, par2, par3, par4, par6, ID)) {
					return 1;
				} else {
					return 0;
				}
			}
			case 2: {
				if (Spacetest1.airnorth(par1, par2, par3, par4, par6, ID)) {
					return 1;
				} else {
					return 0;
				}
			}
			case 3: {
				if (Spacetest1.aireast(par1, par2, par3, par4, par6, ID)) {
					return 1;
				} else {
					return 0;
				}
			}
			default: {
				return 2;
			}
			}

		} else {
			return 3;
		}
	}
}
