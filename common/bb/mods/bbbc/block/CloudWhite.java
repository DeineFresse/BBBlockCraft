package bb.mods.bbbc.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class CloudWhite extends Block{

	public CloudWhite(int blockID) {
		
		super(blockID,Material.cloth);
		setHardness(0.0f);
		setResistance(100.0f);
		setStepSound(soundClothFootstep);
		setCreativeTab(CreativeTabs.tabBlock);
	//	setRequiresSelfNotify();
				
	
	}
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.motionY = 10;
        super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
    }
    
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6) {

	    par5Entity.motionY = 10;
        super.onFallenUpon(par1World, par2, par3, par4, par5Entity,par6);
	}

	/*@Override
	public String getTextureFile(){
		return "/bb/Pic/BBBlockCraftBlocks.png";
		
	}*/
	
	
	
	   /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
  /*  public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return 5+par2;
        }*/
    

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return par1;
    }

    /**
     * Takes a dye damage value and returns the block damage value to match
     */
    public static int getBlockFromDye(int par0)
    {
        return ~par0 & 15;
    }

    /**
     * Takes a block damage value and returns the dye damage value to match
     */
    public static int getDyeFromBlock(int par0)
    {
        return ~par0 & 15;
    }

    
    @SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, @SuppressWarnings("rawtypes") List par3List)
    {
        for (int var4 = 0; var4 < 16; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }

	    }

	
  
	

