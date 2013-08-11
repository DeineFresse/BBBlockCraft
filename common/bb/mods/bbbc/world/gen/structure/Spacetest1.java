package bb.mods.bbbc.world.gen.structure;

//import bb.mods.bbbc.BBBlockCraft;
import bb.mods.bbbc.lib.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;


public class Spacetest1 {

	public static boolean airnorth(World par1,int par2,int par3,int par4,EntityPlayer par5,int ID){
		int x;
		int y = par3;
		int z;
//		String s;
//		int i;
		do{
			x = par2+4;
			do{
				z=par4+1;
				do{
					if(par1.getBlockId(x,y,z)!= 0 &&par1.getBlockId(x, y, z)!=ID){
//						i = par1.getBlockId(x, y, z);
//						Integer I = new Integer(i);
//						s = I.toString();
//						par5.addChatMessage(s);						
						return false;
						}
					if(x!=par2&&y!=par3&&z!=par4){par1.setBlock(x, y, z, 0);}
					if(Reference.DEBUGMODE){par1.setBlock(x, y, z, 0);}
					z--;
//					System.out.print(x);System.out.print(y);System.out.println(z);
					
				}while(z>par4-9);
				x--;
			}while(x>(par2-5));
			y++;
		}while(y<(par3+7));
		return true;
	}
	
	

	public static boolean airsouth(World par1,int par2,int par3,int par4,EntityPlayer par5,int ID){
		
		int x;
		int y = par3;
		int z;
//		String s;
//		int i;
		do{
			x = par2+4;
			do{
				z=par4+8;
				do{
					if(par1.getBlockId(x,y,z)!= 0 &&par1.getBlockId(x, y, z)!=ID&&par1.getBlockId(x,y,z)!=20){
//						i = par1.getBlockId(x, y, z);
//						Integer I = new Integer(i);
//						s = I.toString();
//						par5.addChatMessage(s);
						par5.addChatMessage("X:"+x+" Y:"+y+" Z:"+z);
						return false;
						}
					if(Reference.DEBUGMODE){par1.setBlock(x, y, z, 20);}
					z--;
//					System.out.print(x);System.out.print(y);System.out.println(z);
				}while(z>par4-2);
				x--;
			}while(x>(par2-5));
			y++;
		}while(y<(par3+7));
		return true;
	}

	
}
	

	

