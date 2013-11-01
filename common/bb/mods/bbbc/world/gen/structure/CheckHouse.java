package bb.mods.bbbc.world.gen.structure;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class CheckHouse {

	public static void HouseBuild(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9,int ID){
		
		int f = 0;
		f = MathHelper
				.floor_double((double) (par5EntityPlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		int Ergebnis = Houscheck(par1World, par2, par3, par4, f,
				par5EntityPlayer,ID);

		boolean isRemote = par5EntityPlayer.worldObj.isRemote;
		String ss = null;

		if (!isRemote) {
			Integer I = new Integer(Ergebnis);
			String s = I.toString();
			Integer II = new Integer(f);
			ss = II.toString();
			par5EntityPlayer.addChatMessage(ss);
			par5EntityPlayer.addChatMessage(s);
		}

		switch (Ergebnis) {
		case 0: {
			if (!isRemote)
				par5EntityPlayer
						.addChatMessage("Building was not possible,to less space!");
			break;
		}
		case 1: {
			if (!isRemote)
				par5EntityPlayer.addChatMessage("Building is Possible!");
			BrickHouse.BuildBrickHouse(par1World, par2, par3, par4,
					par5EntityPlayer, f,ID);
			break;
		}
		case 2: {
			if (!isRemote) {
				par5EntityPlayer
						.addChatMessage("Build not possible,ERROR,unexpacted Output from Methode Housecheck ("
								+ ss + ")");
			}
			break;
		}
		}
	} 
	
	private static int Houscheck(World par1, int par2, int par3, int par4, int par5,
			EntityPlayer par6,int ID) {
		
		

		switch (par5) {
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

	}
}
