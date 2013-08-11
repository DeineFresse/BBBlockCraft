package bb.mods.bbbc.world.gen.structure;
import bb.mods.bbbc.lib.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BrickHouse {
	
	public static void BuildBrickHouse(World par1,int par2,int par3,int par4,EntityPlayer par5,int f){
	
		
		if (!Reference.DEBUGMODE){
			switch(f){
			case 0:{south(par1,par2,par3,par4,par5);break;}
			case 1:{west(par1,par2-5,par3,par4-4,par5);break;}
			case 2:{north(par1,par2,par3,par4,par5);break;}
			case 3:{par5.addChatMessage("This feature is NIY");	break;}	
			}
		
		}
		
	}

	public static void north(World par1,int par2,int par3,int par4,EntityPlayer par5){
		
		par1.setBlock(par2-1, par3, par4+1,108);
		par1.setBlock(par2+1,par3,par4,108,1,0x01);
		
		for(int i = 1;i<=4;i++){par1.setBlock(par2-i,par3,par4,108,3,0x01);}
		
		par1.setBlock(par2,  par3,par4+1,108,3,0x01);
		par1.setBlock(par2+1,par3,par4+1,108,3,0x01);
		
		for(int i = 2;i<=4;i++){par1.setBlock(par2+i,par3,par4,108,3,0x01);}
		
		for(int i = 1;i<=8;i++){
		    par1.setBlock(par2+4,par3,par4-i,108,1,0x01);
		    par1.setBlock(par2-4,par3,par4-i,108,0,0x01);}
		
		for(int i =-3;i<=3;i++){
		    par1.setBlock(par2-i,par3  ,par4-8,108,2,0x01);
		    par1.setBlock(par2-i,par3+3,par4-1,108,3,0x01);
			par1.setBlock(par2-i,par3+3,par4-7,108,2,0x01);}
		
	
		for(int i = 1;i<=7;i++){
		    par1.setBlock(par2-3,par3+3,par4-i,108,0,0x01);
			par1.setBlock(par2+3,par3+3,par4-i,108,1,0x01);
			for(int ii = -3;ii<=3;ii++){
			    for(int iii = 0;iii<=2;iii++){ par1.setBlock(par2+ii, par3+iii, par4-i, 45);}
			    }
			}
		
		for(int i = 2;i<=6;i++){
		    par1.setBlock(par2-2,par3+4,par4-i,108,0,0x01);
            par1.setBlock(par2+2,par3+4,par4-i,108,1,0x01); 
			for(int ii = -2;ii<=2;ii++){
			    for(int iii = 1;iii<=3;iii++){par1.setBlock(par2+ii, par3+iii, par4-i, 47);}
			    }			
		}
			

		for(int i = 3;i<=5;i++){
		    par1.setBlock(par2-1,par3+5,par4-i,108,0,0x01);
            par1.setBlock(par2+1,par3+5,par4-i,108,1,0x01); 
		    for(int ii = -1;ii<=1;ii++){
				par1.setBlock(par2+ii, par3+2, par4-i,0);
				par1.setBlock(par2+ii, par3+3, par4-i,0);
				par1.setBlock(par2+ii, par3+1, par4-i,0);
			}			
		}

		
		par1.setBlock(par2, par3+1, par4-2,0);
		par1.setBlock(par2, par3+2, par4-2,0);
		par1.setBlock(par2, par3+1, par4-1,64,3,0x01);
		par1.setBlock(par2, par3+2, par4-1,64,8,0x01);
		par1.setBlock(par2, par3+1, par4-4, 116);
		
		for(int i =-2;i<=2;i++){
			par1.setBlock(par2-i,par3+4,par4-2,108,3,0x01);
			par1.setBlock(par2-i,par3+4,par4-6,108,2,0x01);			
		}
		
		for(int i =-1;i<=1;i++){
			par1.setBlock(par2-i,par3+5,par4-3,108,3,0x01);
			par1.setBlock(par2-i,par3+5,par4-5,108,2,0x01);			
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
		
		par1.setBlock(par2, par3+6, par4-4,44,4,0x01);
	}
	
	
	public static void south(World par1,int par2,int par3,int par4,EntityPlayer par5){
		par4 = par4+8;
		
		for(int i = -4;i<=4;i++){par1.setBlock(par2+i,par3,par4,108,3,0x01);}
		
		for(int i = 1;i<=8;i++){
		    par1.setBlock(par2+4,par3,par4-i,108,1,0x01);
		    par1.setBlock(par2-4,par3,par4-i,108,0,0x01);}
				
		for(int i = -3;i<=3;i++){par1.setBlock(par2-i,par3,par4-8,108,2,0x01);}
		
	

		for(int i = 1;i<=7;i++){
			par1.setBlock(par2-3,par3+3,par4-i,108,0,0x01);			
			par1.setBlock(par2+3,par3+3,par4-i,108,1,0x01);
			for(int ii = -3;ii<=3;ii++){
			    for(int iii = 0;iii<=2;iii++){par1.setBlock(par2+ii, par3+iii, par4-i, 45);}
			    }
			}
		
		for(int i = 2;i<=6;i++){
		    par1.setBlock(par2-2,par3+4,par4-i,108,0,0x01);
			par1.setBlock(par2+2,par3+4,par4-i,108,1,0x01);
			for(int ii = -2;ii<=2;ii++){
			    for(int iii = 1;iii<=3;iii++)
				par1.setBlock(par2+ii, par3+iii, par4-i, 47);
			}			
		}
			
		for(int i = 3;i<=5;i++){
		    par1.setBlock(par2-1,par3+5,par4-i,108,0,0x01);			
			par1.setBlock(par2+1,par3+5,par4-i,108,1,0x01);
			for(int ii = -1;ii<=1;ii++){
			    for(int iii = 1;iii<=3;iii++){par1.setBlock(par2+ii, par3+iii, par4-i,0);}
			}			
		}

		par1.setBlock(par2, par3+1, par4-6,0);
		par1.setBlock(par2, par3+2, par4-6,0);
		par1.setBlock(par2, par3+1, par4-7,64,6,0x01);
		par1.setBlock(par2, par3+2, par4-7,64,9,0x01);
		par1.setBlock(par2, par3+1, par4-4, 116);
		
		par1.setBlock(par2-1, par3, par4-3,49);
		par1.setBlock(par2-1, par3, par4-5,49);
		par1.setBlock(par2+1, par3, par4-3,49);
		par1.setBlock(par2+1, par3, par4-5,49);
		par1.setBlock(par2, par3, par4-4,49);
		par1.setBlock(par2, par3, par4-3,89);
		par1.setBlock(par2, par3, par4-5,89);
		par1.setBlock(par2+1, par3, par4-4,89);
		par1.setBlock(par2-1, par3, par4-4,89);
		
		for(int i =-3;i<=3;i++){
			par1.setBlock(par2-i,par3+3,par4-1,108,3,0x01);
			par1.setBlock(par2-i,par3+3,par4-7,108,2,0x01);				
		}
						
		for(int i =-2;i<=2;i++){
			par1.setBlock(par2-i,par3+4,par4-2,108,3,0x01);		
			par1.setBlock(par2-i,par3+4,par4-6,108,2,0x01);			
		}
		
		
		for(int i =-1;i<=1;i++){
			par1.setBlock(par2-i,par3+5,par4-3,108,3,0x01);			
			par1.setBlock(par2-i,par3+5,par4-5,108,2,0x01);			
		}
		par1.setBlock(par2, par3+6, par4-4,44,4,0x01);
		
		par1.setBlock(par2,par3,par4-8,161,0,0x01);
		par1.setBlock(par2  ,par3,par4-9,108,2,0x01);
		par1.setBlock(par2+1,par3,par4-9,108,1,0x01);
		par1.setBlock(par2-1,par3,par4-9,108,0,0x01);
	}
	
	public static void west(World par1,int par2,int par3,int par4,EntityPlayer par5){
		par4 = par4+8;
		
		for(int i = -4;i<=4;i++){par1.setBlock(par2+i,par3,par4,108,3,0x01);}
		
		for(int i = 1;i<=8;i++){
		    par1.setBlock(par2+4,par3,par4-i,108,1,0x01);
		    par1.setBlock(par2-4,par3,par4-i,108,0,0x01);}
				
		for(int i = -3;i<=3;i++){par1.setBlock(par2-i,par3,par4-8,108,2,0x01);}
		
	

		for(int i = 1;i<=7;i++){
			par1.setBlock(par2-3,par3+3,par4-i,108,0,0x01);			
			par1.setBlock(par2+3,par3+3,par4-i,108,1,0x01);
			for(int ii = -3;ii<=3;ii++){
			    for(int iii = 0;iii<=2;iii++){par1.setBlock(par2+ii, par3+iii, par4-i, 45);}
			    }
			}
		
		for(int i = 2;i<=6;i++){
		    par1.setBlock(par2-2,par3+4,par4-i,108,0,0x01);
			par1.setBlock(par2+2,par3+4,par4-i,108,1,0x01);
			for(int ii = -2;ii<=2;ii++){
			    for(int iii = 1;iii<=3;iii++)
				par1.setBlock(par2+ii, par3+iii, par4-i, 47);
			}			
		}
			
		for(int i = 3;i<=5;i++){
		    par1.setBlock(par2-1,par3+5,par4-i,108,0,0x01);			
			par1.setBlock(par2+1,par3+5,par4-i,108,1,0x01);
			for(int ii = -1;ii<=1;ii++){
			    for(int iii = 1;iii<=3;iii++){par1.setBlock(par2+ii, par3+iii, par4-i,0);}
			}			
		}

		par1.setBlock(par2+2, par3+1, par4-4,0);
		par1.setBlock(par2+2, par3+2, par4-4,0);                  
		par1.setBlock(par2+3, par3+1, par4-4,64,2,0x01);          
		par1.setBlock(par2+3, par3+2, par4-4,64,10,0x01);          
		par1.setBlock(par2, par3+1, par4-4, 116);               
		                                                        
		par1.setBlock(par2-1, par3, par4-3,49);                 
		par1.setBlock(par2-1, par3, par4-5,49);                 
		par1.setBlock(par2+1, par3, par4-3,49);                 
		par1.setBlock(par2+1, par3, par4-5,49);                 
		par1.setBlock(par2, par3, par4-4,49);                   
		par1.setBlock(par2, par3, par4-3,89);                   
		par1.setBlock(par2, par3, par4-5,89);                   
		par1.setBlock(par2+1, par3, par4-4,89);                 
		par1.setBlock(par2-1, par3, par4-4,89);
		
		for(int i =-3;i<=3;i++){
			par1.setBlock(par2-i,par3+3,par4-1,108,3,0x01);
			par1.setBlock(par2-i,par3+3,par4-7,108,2,0x01);				
		}
						
		for(int i =-2;i<=2;i++){
			par1.setBlock(par2-i,par3+4,par4-2,108,3,0x01);		
			par1.setBlock(par2-i,par3+4,par4-6,108,2,0x01);			
		}
		
		
		for(int i =-1;i<=1;i++){
			par1.setBlock(par2-i,par3+5,par4-3,108,3,0x01);			
			par1.setBlock(par2-i,par3+5,par4-5,108,2,0x01);			
		}
		par1.setBlock(par2, par3+6, par4-4,44,4,0x01);
		
		par1.setBlock(par2+4,par3,par4-4,161,0,0x01);
		par1.setBlock(par2+5,par3,par4-3,108,3,0x01);
		par1.setBlock(par2+5,par3,par4-4,108,1,0x01);
		par1.setBlock(par2+5,par3,par4-5,108,2,0x01);
	}
}
