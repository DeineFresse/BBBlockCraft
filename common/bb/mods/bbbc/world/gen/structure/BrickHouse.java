package bb.mods.bbbc.world.gen.structure;
import bb.mods.bbbc.lib.Reference;
import bb.mods.bbbc.world.gen.structure.basic.Forms;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BrickHouse {
	
	static int Brick = 45; //45
	static int BrickStair = 108; //108
	static int Air = 0;
	static int BookShelf = 47; //47
	static int doorWood = 64; //64
	static int doorIron = 71; //71
	static int obsidian = 49; //49
	static int glowStone = 89; //89
	static int entchantTable = 116; //116
	static int BrickSlab = 44; //44
	static int SlabMeta = 4; //4

	public static void BuildBrickHouse(World par1,int par2,int par3,int par4,EntityPlayer par5,int f){
	
		
		if (!Reference.DEBUGMODE){
			switch(f){
			case 0:{south(par1,par2,par3,par4,par5);break;}
			case 1:{west(par1,par2,par3,par4,par5);break;}
			case 2:{north(par1,par2,par3,par4,par5);break;}
			case 3:{east(par1,par2,par3,par4,par5);	break;}	
			}
		
		}
		
	}

	
	public static void north(World par1,int par2,int par3,int par4,EntityPlayer par5){
		
		for(int i=1;i<4;i++){
		Forms.rectangle(par1, par2-3, par3+i, par4-7, 7, 7, Brick);
		Forms.rectangle(par1, par2-2, par3+i, par4-6, 5, 5, BookShelf);
		}
		Forms.square(par1, par2-3, par3, par4-7, 7, 7, Brick);
		
		for(int i=0;i<4;i++){
		Forms.rectangle(par1, par2-4+i, par3+3+i, par4-8+i, 9-2*i, 9-2*i, BrickStair);
		}
		Forms.rectangle(par1, par2-4, par3, par4-8, 9, 9, BrickStair);
		
		par1.setBlock(par2, par3+1, par4-2,Air);
		par1.setBlock(par2, par3+2, par4-2,Air);
		
		Forms.door(par1, par2, par3+1, par4-1, 2, doorWood);
				
		par1.setBlock(par2, par3+1, par4-4, entchantTable);
		
		par1.setBlock(par2+1, par3, par4+1, BrickStair,1,0x01);
		par1.setBlock(par2, par3, par4+1, BrickStair,3,0x01);
		par1.setBlock(par2-1, par3, par4+1, BrickStair,0,0x01);
		
		par1.setBlock(par2-1, par3, par4-3,obsidian);
		par1.setBlock(par2-1, par3, par4-5,obsidian);
		par1.setBlock(par2+1, par3, par4-3,obsidian);
		par1.setBlock(par2+1, par3, par4-5,obsidian);
		par1.setBlock(par2, par3, par4-4,obsidian);
		
		par1.setBlock(par2, par3, par4-3,glowStone);
		par1.setBlock(par2, par3, par4-5,glowStone);
		par1.setBlock(par2+1, par3, par4-4,glowStone);
		par1.setBlock(par2-1, par3, par4-4,glowStone);
		
		par1.setBlock(par2,par3,par4,161);
		
		par1.setBlock(par2, par3+7, par4-4,BrickSlab,SlabMeta,0x01);
	}
	
	public static void south(World par1,int par2,int par3,int par4,EntityPlayer par5){


		for(int i=1;i<4;i++){
			Forms.rectangle(par1, par2-3, par3+i, par4+1, 7, 7, Brick);
			Forms.rectangle(par1, par2-2, par3+i, par4+2, 5, 5, BookShelf);
			}
			Forms.square(par1, par2-3, par3, par4+1, 7, 7, Brick);
			
			for(int i=0;i<4;i++){
			Forms.rectangle(par1, par2-4+i, par3+3+i, par4+i, 9-2*i, 9-2*i, BrickStair);
			}
			
			Forms.rectangle(par1, par2-4, par3, par4, 9, 9, BrickStair);
			
		par1.setBlock(par2, par3+1, par4+2,Air);
		par1.setBlock(par2, par3+2, par4+2,Air);
		
		Forms.door(par1, par2, par3+1, par4+1, 0, doorWood);
		
		par1.setBlock(par2, par3+1, par4+4, entchantTable);
		
		par1.setBlock(par2-1, par3, par4+5,obsidian);
		par1.setBlock(par2-1, par3, par4+3,obsidian);
		par1.setBlock(par2+1, par3, par4+5,obsidian);
		par1.setBlock(par2+1, par3, par4+3,obsidian);
		par1.setBlock(par2, par3, par4+4,obsidian);
		
		par1.setBlock(par2, par3, par4+5,glowStone);
		par1.setBlock(par2, par3, par4+3,glowStone);
		par1.setBlock(par2+1, par3, par4+4,glowStone);
		par1.setBlock(par2-1, par3, par4+4,glowStone);

		par1.setBlock(par2+1, par3, par4-1, BrickStair,1,0x01);
		par1.setBlock(par2, par3, par4-1, BrickStair,2,0x01);
		par1.setBlock(par2-1, par3, par4-1, BrickStair,0,0x01);
		
		par1.setBlock(par2, par3+7, par4+4,BrickSlab,SlabMeta,0x01);
		
		par1.setBlock(par2,par3,par4,161,0,0x01);
		
		}
	
	public static void west(World par1,int par2,int par3,int par4,EntityPlayer par5){

		for(int i=1;i<4;i++){
			Forms.rectangle(par1, par2-7, par3+i, par4-3, 7, 7, Brick);
			Forms.rectangle(par1, par2-6, par3+i, par4-2, 5, 5, BookShelf);
			}
			Forms.square(par1, par2-7, par3, par4-3, 7, 7, Brick);
			
			for(int i=0;i<4;i++){
			Forms.rectangle(par1, par2-8+i, par3+3+i, par4-4+i, 9-2*i, 9-2*i, BrickStair);
			}
			
			Forms.rectangle(par1, par2-8, par3, par4-4, 9, 9, BrickStair);
		
		par1.setBlock(par2-2, par3+1, par4,Air);
		par1.setBlock(par2-2, par3+2, par4,Air);
		
		Forms.door(par1, par2-1, par3+1, par4, 1, doorWood);
		
		par1.setBlock(par2-4, par3+1, par4, entchantTable);
		
		par1.setBlock(par2-5, par3, par4+1,obsidian);
		par1.setBlock(par2-5, par3, par4-1,obsidian);
		par1.setBlock(par2-3, par3, par4+1,obsidian);
		par1.setBlock(par2-3, par3, par4-1,obsidian);
		par1.setBlock(par2-4, par3, par4,obsidian);
		
		par1.setBlock(par2-4, par3, par4+1,glowStone);
		par1.setBlock(par2-4, par3, par4-1,glowStone);
		par1.setBlock(par2-3, par3, par4,glowStone);
		par1.setBlock(par2-5, par3, par4,glowStone);
		
	
		par1.setBlock(par2-4, par3+7, par4,BrickSlab,SlabMeta,0x01);
		
		par1.setBlock(par2,par3,par4,161,0,0x01);
		
		par1.setBlock(par2+1,par3,par4+1,BrickStair,3,0x01);
		par1.setBlock(par2+1,par3,par4,BrickStair,1,0x01);
		par1.setBlock(par2+1,par3,par4-1,BrickStair,2,0x01);
		
	}

	public static void east(World par1,int par2,int par3,int par4,EntityPlayer par5){
		
		for(int i=1;i<4;i++){
		Forms.rectangle(par1, par2+1, par3+i, par4-3, 7, 7, Brick);
		Forms.rectangle(par1, par2+2, par3+i, par4-2, 5, 5, BookShelf);
		}
		Forms.square(par1, par2+1, par3, par4-3, 7, 7, Brick);
		
		for(int i=0;i<4;i++){
		Forms.rectangle(par1, par2+i, par3+3+i, par4-4+i, 9-2*i, 9-2*i, BrickStair);
		}
		Forms.rectangle(par1, par2, par3, par4-4, 9, 9, BrickStair);
		
		par1.setBlock(par2+2, par3+1, par4,Air);
		par1.setBlock(par2+2, par3+2, par4,Air);
		
		Forms.door(par1, par2+1, par3+1, par4, 3, doorWood);
				
		par1.setBlock(par2+4, par3+1, par4, entchantTable);
		
		par1.setBlock(par2-1, par3, par4+1, BrickStair,3,0x01);
		par1.setBlock(par2-1, par3, par4, BrickStair,0,0x01);
		par1.setBlock(par2-1, par3, par4-1, BrickStair,2,0x01);
		
		par1.setBlock(par2+3, par3, par4+1,obsidian);
		par1.setBlock(par2+3, par3, par4-1,obsidian);
		par1.setBlock(par2+5, par3, par4+1,obsidian);
		par1.setBlock(par2+5, par3, par4-1,obsidian);
		par1.setBlock(par2+4, par3, par4,obsidian);
		
		par1.setBlock(par2+4, par3, par4+1,glowStone);
		par1.setBlock(par2+4, par3, par4-1,glowStone);
		par1.setBlock(par2+5, par3, par4,glowStone);
		par1.setBlock(par2+3, par3, par4,glowStone);
		
		par1.setBlock(par2,par3,par4,161);
		
		par1.setBlock(par2+4, par3+7, par4,BrickSlab,SlabMeta,0x01);
	}
}
