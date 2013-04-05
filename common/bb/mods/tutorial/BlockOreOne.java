package bb.mods.tutorial;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOreOne extends Block{

	public static int shiftedIndex;
	public BlockOreOne(int blockID)
{
        super(blockID, Material.rock);
        blockIndexInTexture =0;
        setHardness(2.0f);
        setResistance(5.0f);
        setStepSound(soundStoneFootstep);
        setCreativeTab(CreativeTabs.tabBlock);
        shiftedIndex = blockID;
        setLightValue(1.5F);
        setBlockName("BlockOreOne");
}
	@Override
	public int getBlockTextureFromSide(int side)
{
        switch(side)
        {
        case 0:
                return 0;
        case 1:
                return 0;
        }
        return blockIndexInTexture;
}
        @Override
        public String getTextureFile()
{
        return "/bb/Pic/BBBlockCraftBlocks.png";
}

	
}
