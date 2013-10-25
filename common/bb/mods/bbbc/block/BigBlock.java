package bb.mods.bbbc.block;

import bb.mods.bbbc.lib.Block_Names;
import bb.mods.bbbc.lib.LoadedIDs;
import bb.mods.bbbc.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BigBlock extends Block{

	public static int shiftedIndex;
	public BigBlock(int blockID)
{
        super(blockID, Material.rock);
        setHardness(2.0f);
        shiftedIndex = blockID;
        setResistance(5.0f);
        setStepSound(soundStoneFootstep);
        setCreativeTab(CreativeTabs.tabBlock);
        setLightValue(1.5F);
        setUnlocalizedName(Block_Names.BIGBLOCK);
}
	 
	@SideOnly(Side.CLIENT)
	public static Icon topIcon;
	
	public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
       String namesufix  = Reference.getSideSufix(par5);
       byte Connected = 0;
       
       if(isBigBlockPart(par1IBlockAccess.getBlockId(par2, par3, par4+1))){Connected|=1 ;}
       if(isBigBlockPart(par1IBlockAccess.getBlockId(par2, par3, par4+1))){Connected|=2;}
       if(isBigBlockPart(par1IBlockAccess.getBlockId(par2, par3, par4+1))){Connected|=4;}
       if(isBigBlockPart(par1IBlockAccess.getBlockId(par2, par3, par4+1))){Connected|=8;}
       if(isBigBlockPart(par1IBlockAccess.getBlockId(par2, par3, par4+1))){Connected|=16;}
       if(isBigBlockPart(par1IBlockAccess.getBlockId(par2, par3, par4+1))){Connected|=32;}
       
       String icon = namesufix+Connected;
       
       return null;
    }
	
	
	
	private boolean isBigBlockPart(int blockId) {
		int[] ids= new int[]{LoadedIDs.Block_BigBlock,LoadedIDs.Block_Faceblock};
		
		return false;
	}

	public Icon getIcon(int par1,int par2)
	    {
	    
		
		return this.blockIcon;
	       
	    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
	blockIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.DARKSTONE);
	}
	
}
