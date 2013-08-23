package bb.mods.bbbc.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import bb.mods.bbbc.lib.Block_Names;
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
        setUnlocalizedName(Block_Names.TESTBLOCK);
        
        
}
	
	
	

	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		//if(this.isClient()){
		int f = 0;
		f = MathHelper.floor_double((double)(par5EntityPlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		int Ergebnis = Houscheck(par1World,par2,par3,par4,f,par5EntityPlayer);
	//	Integer I = new Integer(Ergebnis);
	//	String s = I.toString();
	//	Integer II = new Integer(f);
	//	String ss = II.toString();
			
		//par5EntityPlayer.addChatMessage(ss);
		
		switch (Ergebnis){
		case 0:{//par5EntityPlayer.addChatMessage("Building was not possible,to less space!");
		        break;}
		case 1:{//par5EntityPlayer.addChatMessage("Building is Possible!");
		        BrickHouse.BuildBrickHouse(par1World, par2, par3, par4, par5EntityPlayer,f);
		        break;}
		case 2:{//par5EntityPlayer.addChatMessage("Build not possible,ERROR,unexpacted Output from Methode Housecheck ("+ss+")");
		        break;}
		}
		super.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
		return true;//}
		
		/*else {		
		int f = 0;
		f = MathHelper.floor_double((double)(par5EntityPlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		int Ergebnis = Houscheck(par1World,par2,par3,par4,f,par5EntityPlayer);
		Integer I = new Integer(Ergebnis);
		String s = I.toString();
		Integer II = new Integer(f);
		String ss = II.toString();
			
		//par5EntityPlayer.addChatMessage(ss);
		
		switch (Ergebnis){
		case 0:{//par5EntityPlayer.addChatMessage("Building was not possible,to less space!");
		        break;}
		case 1:{//par5EntityPlayer.addChatMessage("Building is Possible!");
		        BrickHouse.BuildBrickHouse(par1World, par2, par3, par4, par5EntityPlayer,f);
		        break;}
		case 2:{//par5EntityPlayer.addChatMessage("Build not possible,ERROR,unexpacted Output from Methode Housecheck ("+ss+")");
		        break;}
		}
		super.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
		return true;
	
		}*/
	}
	
	
	
	@SideOnly(Side.CLIENT)
	public static Icon topIcon;
	@SideOnly(Side.CLIENT)
	public static Icon bottomIcon;
	@SideOnly(Side.CLIENT)
	public static Icon sideIcon;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
	topIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.TESTBLOCK.toLowerCase() + "_top");
	bottomIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.TESTBLOCK.toLowerCase() + "_bottom");
	sideIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.TESTBLOCK.toLowerCase() + "_side");
	blockIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.TESTBLOCK.toLowerCase());
	}
	
	
	

	
	public int Houscheck(World par1,int par2,int par3,int par4,int par5,EntityPlayer par6){
		
		switch (par5){
		case 0:{if(Spacetest1.airsouth(par1, par2, par3 , par4, par6,ID)){return 1;}else {return 0;}}
		case 1:{if(Spacetest1.airwest(par1, par2, par3 ,par4 ,par6,ID)){return 1;}else {return 0;}}
		case 2:{if(Spacetest1.airnorth(par1 ,par2 ,par3 ,par4 ,par6,ID)){return 1;}else {return 0;}}
		case 3:{if(Spacetest1.aireast(par1 ,par2 ,par3 ,par4 ,par6,ID)){return 1;}else {return 0;}}
		default: {return 2;}
		}
				
	}
}	
	