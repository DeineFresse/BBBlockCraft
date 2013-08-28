package bb.mods.bbbc.block;

import bb.mods.bbbc.lib.Block_Names;
import bb.mods.bbbc.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Dark_Stone extends Block{

	public static int shiftedIndex;
	public Dark_Stone(int blockID)
{
        super(blockID, Material.rock);
        setHardness(2.0f);
        setResistance(5.0f);
        setStepSound(soundStoneFootstep);
        setCreativeTab(CreativeTabs.tabBlock);
        setLightValue(1.5F);
        setUnlocalizedName(Block_Names.DARKSTONE);
}
	 
	@SideOnly(Side.CLIENT)
	public static Icon topIcon;
	
	
	
	public Icon getIcon(int par1,int par2)
	    {
	       
		
		return this.blockIcon;
	       
	    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
	blockIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.DARKSTONE);
	}
	
}
