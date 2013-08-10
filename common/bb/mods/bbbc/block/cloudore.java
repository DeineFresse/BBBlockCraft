package bb.mods.bbbc.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class cloudore extends Block{

	public cloudore(int blockID) {
		
		super(blockID, Material.plants);
	//	blockIndexInTexture = 4;
		setHardness(0.5f);
		setResistance(5.0f);
		setStepSound(soundStoneFootstep);
		setCreativeTab(CreativeTabs.tabBlock);
		setLightValue(1.0F);
		
		//setBlockName("CloudOre");
		
		
	}

	/*@Override
	public String getTextureFile(){
		return "/bb/Pic/BBBlockCraftBlocks.png";
		
	}*/
}
