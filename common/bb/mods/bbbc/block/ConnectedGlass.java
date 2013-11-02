package bb.mods.bbbc.block;

import java.io.File;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import bb.mods.bbbc.lib.Block_Names;
import bb.mods.bbbc.lib.LoadedIDs;
import bb.mods.bbbc.lib.Reference;
import bb.mods.bbbc.lib.UnlocalizedNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ConnectedGlass extends Block {

	Icon[][] blockIcon = new Icon[16][16];
	
	int[] ids = new int[] { LoadedIDs.Block_ConnectedGlass};

	public ConnectedGlass(int blockID) {
		super(blockID, Material.glass);
		setHardness(2.0f);
		setResistance(5.0f);
		setStepSound(soundGlassFootstep);
		setCreativeTab(CreativeTabs.tabBlock);
		setLightValue(1.5F);
		setUnlocalizedName(UnlocalizedNames.getUnlocalizedName(Block_Names.CONNECTEDGLASS));

	}

	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2,
			int par3, int par4, int par5) {
		
		int[] con= Connected.getConnection(ids, par5, par1IBlockAccess,par2, par3, par4);
		 
		return this.blockIcon [con[0]][con[1]];
	}
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {		
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		return this.blockIcon[0][0];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {

		for (int i = 0; i < blockIcon.length; i++) {
			if (i == 15) {
				for (int ii = 0; ii < blockIcon[i].length; ii++) {
					this.blockIcon[i][ii] = icon.registerIcon(Reference.MOD_ID
							.toLowerCase()
							+ ":"
							+ Block_Names.CONNECTEDGLASS
							+ File.separatorChar
							+ Block_Names.CONNECTEDGLASS
							+ i
							+ "_" + ii);
				}
			} else if (i == 5 || i == 6 || i == 9 || i == 10) {
				for (int ii = 0; ii < blockIcon[i].length; ii++) {
					int x = ii & 1;
					this.blockIcon[i][ii] = icon.registerIcon(Reference.MOD_ID
							.toLowerCase()
							+ ":"
							+ Block_Names.CONNECTEDGLASS
							+ File.separatorChar
							+ Block_Names.CONNECTEDGLASS
							+ i
							+ "_" + x);
				}

			} else if (isAdvanced(i)) {
				for (int ii = 0; ii < blockIcon[i].length; ii++) {
					int x = ii & 3;
					this.blockIcon[i][ii] = icon.registerIcon(Reference.MOD_ID
							.toLowerCase()
							+ ":"
							+ Block_Names.CONNECTEDGLASS
							+ File.separatorChar
							+ Block_Names.CONNECTEDGLASS
							+ i
							+ "_" + x);
				}
			} else {
				for (int ii = 0; ii < blockIcon[i].length; ii++) {
					this.blockIcon[i][ii] = icon.registerIcon(Reference.MOD_ID
							.toLowerCase()
							+ ":"
							+ Block_Names.CONNECTEDGLASS
							+ File.separatorChar
							+ Block_Names.CONNECTEDGLASS
							+ i
							+ "_" + 0);
				}
			}
		}

	}

	private boolean isAdvanced(int is) {
		int[] advanced = new int[] { 5, 6, 7, 9, 10, 11, 13, 14,15};
		for (int i = 0; i < advanced.length; i++) {
			if (is == advanced[i]) {
				return true;
			}
		}
		return false;
	}

	
	public int getRenderBlockPass() {
		return 0;
	}

	public static boolean isNormalCube(int par0)
    {
        return true;
    }
	
	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}
}
