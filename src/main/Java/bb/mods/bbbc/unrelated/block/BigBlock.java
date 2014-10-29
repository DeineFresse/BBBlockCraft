package bb.mods.bbbc.unrelated.block;

import bb.mods.bbbc.core.block.ConnectedBlock;
import bb.mods.bbbc.core.references.RenderIDS;
import bb.mods.bbbc.core.util.UnlocalizedNames;
import bb.mods.bbbc.unrelated.references.Block_Names;
import bb.mods.bbbc.unrelated.references.Resources;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BigBlock extends ConnectedBlock {

	public BigBlock() {
		super(Material.rock);
        RLocation = Resources.BIGBLOCK_RL;
        RLocationSide = Resources.BIGBLOCK_SIDE_RL;
        RLocationCorner = Resources.BIGBLOCK_CORNER_RL;
		setHardness(2.0f);
		setResistance(5.0f);
		setStepSound(soundTypeStone);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName(UnlocalizedNames.getUnlocalizedName(Block_Names.BIGBLOCK));

	}

    @Override
    public int getRenderType() {
        return RenderIDS.connectedRender;
    }
}
