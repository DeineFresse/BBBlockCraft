package bb.mods.bbbc.world.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import bb.mods.bbbc.world.lib.Block_Names;
import bb.mods.bbbc.core.lib.TexturesName;
import bb.mods.bbbc.core.lib.UnlocalizedNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class cloudore extends Block {

	public cloudore() {

		super(Material.plants);
		setHardness(0.5f);
		setResistance(5.0f);
		setStepSound(soundTypeStone);
		setCreativeTab(CreativeTabs.tabBlock);
		setLightLevel(0.5F);
		setBlockName(UnlocalizedNames.getUnlocalizedName(Block_Names.CLOUDORE));


	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon) {
		blockIcon = icon.registerIcon(TexturesName.getTextureName(Block_Names.CLOUDORE));
	}
}
