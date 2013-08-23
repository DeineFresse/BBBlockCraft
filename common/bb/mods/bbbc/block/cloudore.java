package bb.mods.bbbc.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import bb.mods.bbbc.lib.Block_Names;
import bb.mods.bbbc.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;


public class cloudore extends Block{

	public cloudore(int blockID) {
		
		super(blockID, Material.plants);
		setHardness(0.5f);
		setResistance(5.0f);
		setStepSound(soundStoneFootstep);
		setCreativeTab(CreativeTabs.tabBlock);
		setLightValue(1.0F);
		setUnlocalizedName(Block_Names.CLOUDORE);
		
		
		
		
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
	blockIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Block_Names.CLOUDORE);
	}
}
