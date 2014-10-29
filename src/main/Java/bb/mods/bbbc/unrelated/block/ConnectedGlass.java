package bb.mods.bbbc.unrelated.block;

import bb.mods.bbbc.core.block.ConnectedBlock;
import bb.mods.bbbc.core.references.RenderIDS;
import bb.mods.bbbc.core.util.UnlocalizedNames;
import bb.mods.bbbc.unrelated.references.Block_Names;
import bb.mods.bbbc.unrelated.references.Resources;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ConnectedGlass extends ConnectedBlock {
	
	Block[] ids = new Block[] {this};

	public ConnectedGlass() {
        super(Material.glass);
        RLocation = Resources.CONNECTED_GLASS_RL;
        RLocationCorner = Resources.BIGBLOCK_CORNER_RL;
        RLocationSide = Resources.CONNECTED_GLASS_SIDE_RL;
        setHardness(1.0f);
        setResistance(200000.0f);
        setStepSound(soundTypeGlass);
        setCreativeTab(CreativeTabs.tabBlock);
        //setLightLevel(1.0F);
        setBlockName(UnlocalizedNames.getUnlocalizedName(Block_Names.CONNECTEDGLASS));

    }

	@Override
	public int getRenderType() {
		return RenderIDS.connectedRender;
	}

}
