package bb.mods.tutorial.structures;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BrickHouse {
	
	public static void BuildBrickHouse(World par1,int par2,int par3,int par4,EntityPlayer par5,int f){
	
		
		//if (getdebugmode() == false){
			switch(f){
			case 0:{south(par1,par2,par3,par4,par5);break;}
			case 1:{par5.addChatMessage("This feature is NIY");	break;}
			case 2:{north(par1,par2,par3,par4,par5);break;}
			case 3:{par5.addChatMessage("This feature is NIY");	break;}	
			//}
		
		}
		
	}

	public static void north(World par1,int par2,int par3,int par4,EntityPlayer par5){
	//TODO: Clean this up make for loops if possible definetly is.
		par1.setBlock(par2, par3, par4+1,108,3,0x01);
		par1.setBlock(par2-1, par3, par4+1,108);
		par1.setBlock(par2+1, par3, par4+1,108,3,0x01);
		par1.setBlock(par2+1,par3,par4,108,1,0x01);
		par1.setBlock(par2-1,par3,par4,108,3,0x01);
		par1.setBlock(par2-2,par3,par4,108,3,0x01);
		par1.setBlock(par2-3,par3,par4,108,3,0x01);
		par1.setBlock(par2-4,par3,par4,108,3,0x01);
		par1.setBlock(par2+2,par3,par4,108,3,0x01);
		par1.setBlock(par2+3,par3,par4,108,3,0x01);
		par1.setBlock(par2+4,par3,par4,108,3,0x01);
		par1.setBlock(par2+4,par3,par4-1,108,1,0x01);
		par1.setBlock(par2+4,par3,par4-2,108,1,0x01);
		par1.setBlock(par2+4,par3,par4-3,108,1,0x01);
		par1.setBlock(par2+4,par3,par4-4,108,1,0x01);
		par1.setBlock(par2+4,par3,par4-5,108,1,0x01);
		par1.setBlock(par2+4,par3,par4-6,108,1,0x01);
		par1.setBlock(par2+4,par3,par4-7,108,1,0x01);
		par1.setBlock(par2+4,par3,par4-8,108,1,0x01);
		par1.setBlock(par2-4,par3,par4-1,108,0,0x01);
		par1.setBlock(par2-4,par3,par4-2,108,0,0x01);
		par1.setBlock(par2-4,par3,par4-3,108,0,0x01);
		par1.setBlock(par2-4,par3,par4-4,108,0,0x01);
		par1.setBlock(par2-4,par3,par4-5,108,0,0x01);
		par1.setBlock(par2-4,par3,par4-6,108,0,0x01);
		par1.setBlock(par2-4,par3,par4-7,108,0,0x01);
		par1.setBlock(par2-4,par3,par4-8,108,0,0x01);
		par1.setBlock(par2-3,par3,par4-8,108,2,0x01);
		par1.setBlock(par2-2,par3,par4-8,108,2,0x01);
		par1.setBlock(par2-1,par3,par4-8,108,2,0x01);
		par1.setBlock(par2, par3, par4-8,108,2,0x01);
		par1.setBlock(par2+1,par3,par4-8,108,2,0x01);
		par1.setBlock(par2+2,par3,par4-8,108,2,0x01);
		par1.setBlock(par2+3,par3,par4-8,108,2,0x01);
		for(int i = 1;i<=7;i++){
			for(int ii = -3;ii<=3;ii++){
				par1.setBlock(par2+ii, par3, par4-i, 45);
			}
			
		}
		par1.setBlock(par2-1, par3, par4-3,49);
		par1.setBlock(par2-1, par3, par4-5,49);
		par1.setBlock(par2+1, par3, par4-3,49);
		par1.setBlock(par2+1, par3, par4-5,49);
		par1.setBlock(par2, par3, par4-4,49);
		par1.setBlock(par2, par3, par4-3,89);
		par1.setBlock(par2, par3, par4-5,89);
		par1.setBlock(par2+1, par3, par4-4,89);
		par1.setBlock(par2-1, par3, par4-4,89);
		for(int i = 1;i<=7;i++){
			for(int ii = -3;ii<=3;ii++){
				par1.setBlock(par2+ii, par3+1, par4-i, 45);
			}
			
		}
		for(int i = 1;i<=7;i++){
			for(int ii = -3;ii<=3;ii++){
				par1.setBlock(par2+ii, par3+2, par4-i, 45);
			}
			
		}
		for(int i = 2;i<=6;i++){
			for(int ii = -2;ii<=2;ii++){
				par1.setBlock(par2+ii, par3+1, par4-i, 47);
			}
			
		}
		for(int i = 2;i<=6;i++){
			for(int ii = -2;ii<=2;ii++){
				par1.setBlock(par2+ii, par3+2, par4-i, 47);
			}
			
		}
		for(int i = 2;i<=6;i++){
			for(int ii = -2;ii<=2;ii++){
				par1.setBlock(par2+ii, par3+3, par4-i, 47);
			}
			
		}
		for(int i = 3;i<=5;i++){
			for(int ii = -1;ii<=1;ii++){
				par1.setBlock(par2+ii, par3+2, par4-i,0);
			}
			
		}
		for(int i = 3;i<=5;i++){
			for(int ii = -1;ii<=1;ii++){
				par1.setBlock(par2+ii, par3+3, par4-i,0);
			}
			
		}
		for(int i = 3;i<=5;i++){
			for(int ii = -1;ii<=1;ii++){
				par1.setBlock(par2+ii, par3+1, par4-i,0);
			}
			
		}
		
		par1.setBlock(par2, par3+1, par4-2,0);
		par1.setBlock(par2, par3+2, par4-2,0);
		par1.setBlock(par2, par3+1, par4-1,64,3,0x01);
		par1.setBlock(par2, par3+2, par4-1,64,8,0x01);
		par1.setBlock(par2, par3+1, par4-4, 116);
		
		for(int i =-3;i<=3;i++){
			par1.setBlock(par2-i,par3+3,par4-1,108,3,0x01);			
		}
		for(int i =-3;i<=3;i++){
			par1.setBlock(par2-i,par3+3,par4-7,108,2,0x01);			
		}
		for(int i =1;i<=7;i++){
			par1.setBlock(par2-3,par3+3,par4-i,108,0,0x01);			
		}
		for(int i =1;i<=7;i++){
			par1.setBlock(par2+3,par3+3,par4-i,108,1,0x01);			
		}
		
		
		for(int i =-2;i<=2;i++){
			par1.setBlock(par2-i,par3+4,par4-2,108,3,0x01);			
		}
		for(int i =-2;i<=2;i++){
			par1.setBlock(par2-i,par3+4,par4-6,108,2,0x01);			
		}
		for(int i =2;i<=6;i++){
			par1.setBlock(par2-2,par3+4,par4-i,108,0,0x01);			
		}
		for(int i =2;i<=6;i++){
			par1.setBlock(par2+2,par3+4,par4-i,108,1,0x01);			
		}
		
		
		for(int i =-1;i<=1;i++){
			par1.setBlock(par2-i,par3+5,par4-3,108,3,0x01);			
		}
		for(int i =-1;i<=1;i++){
			par1.setBlock(par2-i,par3+5,par4-5,108,2,0x01);			
		}
		for(int i =3;i<=5;i++){
			par1.setBlock(par2-1,par3+5,par4-i,108,0,0x01);			
		}
		for(int i =3;i<=5;i++){
			par1.setBlock(par2+1,par3+5,par4-i,108,1,0x01);			
		}
		
		par1.setBlock(par2, par3+6, par4-4,44,4,0x01);
	}
	
	
	public static void south(World par1,int par2,int par3,int par4,EntityPlayer par5){
		par4 = par4+8;
		
		   //TODO: Clean this up make for loops if possible definetly is.	
		//TODO: Check if the next three lines can be deleted have been out commentated?
		par1.setBlock(par2, par3, par4+1,108,3,0x01);
		par1.setBlock(par2-1, par3, par4+1,108);
		par1.setBlock(par2+1, par3, par4+1,108,3,0x01);
		
		par1.setBlock(par2+1,par3,par4,108,3,0x01);
		par1.setBlock(par2,par3,par4,108,3,0x01);
		par1.setBlock(par2-1,par3,par4,108,3,0x01);
		par1.setBlock(par2-2,par3,par4,108,3,0x01);
		par1.setBlock(par2-3,par3,par4,108,3,0x01);
		par1.setBlock(par2-4,par3,par4,108,3,0x01);
		par1.setBlock(par2+2,par3,par4,108,3,0x01);
		par1.setBlock(par2+3,par3,par4,108,3,0x01);
		par1.setBlock(par2+4,par3,par4,108,3,0x01);
		par1.setBlock(par2+4,par3,par4-1,108,1,0x01);
		par1.setBlock(par2+4,par3,par4-2,108,1,0x01);
		par1.setBlock(par2+4,par3,par4-3,108,1,0x01);
		par1.setBlock(par2+4,par3,par4-4,108,1,0x01);
		par1.setBlock(par2+4,par3,par4-5,108,1,0x01);
		par1.setBlock(par2+4,par3,par4-6,108,1,0x01);
		par1.setBlock(par2+4,par3,par4-7,108,1,0x01);
		par1.setBlock(par2+4,par3,par4-8,108,1,0x01);
		par1.setBlock(par2-4,par3,par4-1,108,0,0x01);
		par1.setBlock(par2-4,par3,par4-2,108,0,0x01);
		par1.setBlock(par2-4,par3,par4-3,108,0,0x01);
		par1.setBlock(par2-4,par3,par4-4,108,0,0x01);
		par1.setBlock(par2-4,par3,par4-5,108,0,0x01);
		par1.setBlock(par2-4,par3,par4-6,108,0,0x01);
		par1.setBlock(par2-4,par3,par4-7,108,0,0x01);
		par1.setBlock(par2-4,par3,par4-8,108,0,0x01);
		par1.setBlock(par2-3,par3,par4-8,108,2,0x01);
		par1.setBlock(par2-2,par3,par4-8,108,2,0x01);
		par1.setBlock(par2-1,par3,par4-8,108,2,0x01);
		par1.setBlock(par2, par3, par4-8,108,2,0x01);
		par1.setBlock(par2+1,par3,par4-8,108,2,0x01);
		par1.setBlock(par2+2,par3,par4-8,108,2,0x01);
		par1.setBlock(par2+3,par3,par4-8,108,2,0x01);
		for(int i = 1;i<=7;i++){
			for(int ii = -3;ii<=3;ii++){
				par1.setBlock(par2+ii, par3, par4-i, 45);
			}
			
		}
		par1.setBlock(par2-1, par3, par4-3,49);
		par1.setBlock(par2-1, par3, par4-5,49);
		par1.setBlock(par2+1, par3, par4-3,49);
		par1.setBlock(par2+1, par3, par4-5,49);
		par1.setBlock(par2, par3, par4-4,49);
		par1.setBlock(par2, par3, par4-3,89);
		par1.setBlock(par2, par3, par4-5,89);
		par1.setBlock(par2+1, par3, par4-4,89);
		par1.setBlock(par2-1, par3, par4-4,89);
		for(int i = 1;i<=7;i++){
			for(int ii = -3;ii<=3;ii++){
				par1.setBlock(par2+ii, par3+1, par4-i, 45);
			}
			
		}
		for(int i = 1;i<=7;i++){
			for(int ii = -3;ii<=3;ii++){
				par1.setBlock(par2+ii, par3+2, par4-i, 45);
			}
			
		}
		for(int i = 2;i<=6;i++){
			for(int ii = -2;ii<=2;ii++){
				par1.setBlock(par2+ii, par3+1, par4-i, 47);
			}
			
		}
		for(int i = 2;i<=6;i++){
			for(int ii = -2;ii<=2;ii++){
				par1.setBlock(par2+ii, par3+2, par4-i, 47);
			}
			
		}
		for(int i = 2;i<=6;i++){
			for(int ii = -2;ii<=2;ii++){
				par1.setBlock(par2+ii, par3+3, par4-i, 47);
			}
			
		}
		for(int i = 3;i<=5;i++){
			for(int ii = -1;ii<=1;ii++){
				par1.setBlock(par2+ii, par3+2, par4-i,0);
			}
			
		}
		for(int i = 3;i<=5;i++){
			for(int ii = -1;ii<=1;ii++){
				par1.setBlock(par2+ii, par3+3, par4-i,0);
			}
			
		}
		for(int i = 3;i<=5;i++){
			for(int ii = -1;ii<=1;ii++){
				par1.setBlock(par2+ii, par3+1, par4-i,0);
			}
			
		}
		
		par1.setBlock(par2, par3+1, par4-6,0);
		par1.setBlock(par2, par3+2, par4-6,0);
		par1.setBlock(par2, par3+1, par4-7,64,6,0x01);
		par1.setBlock(par2, par3+2, par4-7,64,9,0x01);
		par1.setBlock(par2, par3+1, par4-4, 116);
		
		for(int i =-3;i<=3;i++){
			par1.setBlock(par2-i,par3+3,par4-1,108,3,0x01);
			par1.setBlock(par2-i,par3+3,par4-7,108,2,0x01);				
		}
		
		for(int i =1;i<=7;i++){
			par1.setBlock(par2-3,par3+3,par4-i,108,0,0x01);			
			par1.setBlock(par2+3,par3+3,par4-i,108,1,0x01);}
				
		for(int i =-2;i<=2;i++){
			par1.setBlock(par2-i,par3+4,par4-2,108,3,0x01);		
			par1.setBlock(par2-i,par3+4,par4-6,108,2,0x01);			
		}
		
		for(int i =2;i<=6;i++){
			par1.setBlock(par2-2,par3+4,par4-i,108,0,0x01);
			par1.setBlock(par2+2,par3+4,par4-i,108,1,0x01);			
					
		}
		
		for(int i =-1;i<=1;i++){
			par1.setBlock(par2-i,par3+5,par4-3,108,3,0x01);			
			par1.setBlock(par2-i,par3+5,par4-5,108,2,0x01);			
		}
		for(int i =3;i<=5;i++){
			par1.setBlock(par2-1,par3+5,par4-i,108,0,0x01);			
			par1.setBlock(par2+1,par3+5,par4-i,108,1,0x01);			
		}
		par1.setBlock(par2, par3+6, par4-4,44,4,0x01);
		
		par1.setBlock(par2,par3,par4-8,161,0,0x01);
		par1.setBlock(par2,par3,par4-9,108,2,0x01);
		par1.setBlock(par2+1,par3,par4-9,108,1,0x01);
		par1.setBlock(par2-1,par3,par4-9,108,0,0x01);
	}
}
