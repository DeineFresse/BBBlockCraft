package bb.mods.bbbc.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
//import bb.mods.bbbc.BBBlockCraft;
import bb.mods.bbbc.lib.Reference;
import bb.mods.bbbc.world.gen.structure.BrickHouse;
import bb.mods.bbbc.world.gen.structure.Spacetest1;

public class TestBlock extends Block{
	
	int ID;
	public TestBlock(int blockID)
{
		
        super(blockID, Material.rock);
      //  blockIndexInTexture =1;
        setHardness(2.0f);
        setResistance(5.0f);
        setStepSound(soundStoneFootstep);
        setCreativeTab(CreativeTabs.tabBlock);
        ID = blockID;
      //  setBlockName("The Brick Entchantment House");
        
        
}
	
	
	
/*	@Override
	public int getBlockTextureFromSide(int side)
{
        switch(side)
        {
        case 5:
                return 3;
        case 4:
                return 2;
        }
        return blockIndexInTexture;	
        
 } */
	
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		int f = 0;
		f = MathHelper.floor_double((double)(par5EntityPlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		int Ergebnis = Houscheck(par1World,par2,par3,par4,f,par5EntityPlayer);
	//	Integer I = new Integer(Ergebnis);
	//	String s = I.toString();
		Integer II = new Integer(f);
		String ss = II.toString();		
		switch (Ergebnis){
		case 0:{par5EntityPlayer.addChatMessage("Building was not possible,to less space!");break;}
		case 1:{par5EntityPlayer.addChatMessage("Building is Possible!");BrickHouse.BuildBrickHouse(par1World, par2, par3, par4, par5EntityPlayer,f);break;}
		case 2:{par5EntityPlayer.addChatMessage("Build not possible,ERROR,unexpacted Input for Methode Housecheck ("+ss+")");break;}
		case 3:{par5EntityPlayer.addChatMessage("Chek for space and building NIY");break;}
		}
		super.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
		return true;
	}
	
	
/*	@Override
        public String getTextureFile()
{
        return "/bb/Pic/BBBlockCraftBlocks.png";
}*/
	
	public int Houscheck(World par1,int par2,int par3,int par4,int par5,EntityPlayer par6){
		
		switch (par5){
		case 0:{if(Spacetest1.airsouth(par1, par2, par3 , par4, par6,ID)){return 1;}}
		case 1:{if(Spacetest1.airwest(par1, par2, par3 ,par4 ,par6,ID)){return 1;}}
		case 2:{if(Spacetest1.airnorth(par1 ,par2 ,par3 ,par4 ,par6,ID)){return 1;}}
		case 3:{if(Spacetest1.aireast(par1 ,par2 ,par3 ,par4 ,par6,ID)){return 1;}}
		}
		if(Reference.DEBUGMODE)par6.addChatMessage("?");
		if(par5<0||par5>3){return 2;}else if(par5==1||par5==3){return 3;}else{return 0;}		
	}
}	
	