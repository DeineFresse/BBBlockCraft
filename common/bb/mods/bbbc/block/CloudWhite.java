package bb.mods.bbbc.block;

import java.util.List;

import bb.mods.bbbc.lib.Block_Names;
import bb.mods.bbbc.lib.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
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
		setUnlocalizedName(Block_Names.CLOUDWHITE);
	
	}
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.motionY = 2;
        super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
    }
    
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6) {

	    par5Entity.motionY = 10;
        super.onFallenUpon(par1World, par2, par3, par4, par5Entity,par6);
	}

	@SideOnly(Side.CLIENT)
	public static Icon Icon0;
	@SideOnly(Side.CLIENT)
	public static Icon Icon1;
	@SideOnly(Side.CLIENT)
	public static Icon Icon2;
	@SideOnly(Side.CLIENT)
	public static Icon Icon3;
	@SideOnly(Side.CLIENT)
	public static Icon Icon4;
	@SideOnly(Side.CLIENT)
	public static Icon Icon5;
	@SideOnly(Side.CLIENT)
	public static Icon Icon6;
	@SideOnly(Side.CLIENT)
	public static Icon Icon7;
	@SideOnly(Side.CLIENT)
	public static Icon Icon8;
	@SideOnly(Side.CLIENT)
	public static Icon Icon9;
	@SideOnly(Side.CLIENT)
	public static Icon Icon10;
	@SideOnly(Side.CLIENT)
	public static Icon Icon11;
	@SideOnly(Side.CLIENT)
	public static Icon Icon12;
	@SideOnly(Side.CLIENT)
	public static Icon Icon13;
	@SideOnly(Side.CLIENT)
	public static Icon Icon14;
	@SideOnly(Side.CLIENT)
	public static Icon Icon15;
	
	
	
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
	Icon0 = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.CLOUDWHITE +"0");
	Icon1 = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.CLOUDWHITE +"1");
	Icon2 = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.CLOUDWHITE +"2");
	Icon3 = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.CLOUDWHITE +"3");
	Icon4 = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.CLOUDWHITE +"4");
	Icon5 = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.CLOUDWHITE +"5");
	Icon6 = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.CLOUDWHITE +"6");
	Icon7 = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.CLOUDWHITE +"7");
	Icon8 = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.CLOUDWHITE +"8");
	Icon9 = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.CLOUDWHITE +"9");
	Icon10 = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.CLOUDWHITE +"10");
	Icon11 = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.CLOUDWHITE +"11");
	Icon12 = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.CLOUDWHITE +"12");
	Icon13 = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.CLOUDWHITE +"13");
	Icon14 = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.CLOUDWHITE +"14");
	Icon15 = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.CLOUDWHITE +"15");
	
	}
	
	public boolean renderAsNormalBlock(){
		return false;
		
	}
	public int getRenderBlockPass(){
		return 0;
	}
	 public boolean isOpaqueCube()
	    {
	        return false;
	    }
	
	   /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
      

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

	
  
	
