package bb.mods.bbbc.unrelated.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import bb.mods.bbbc.core.tileentity.ConnectedTileEntity;
import bb.mods.bbbc.unrelated.lib.Block_Names;
import bb.mods.bbbc.core.lib.TexturesName;
import bb.mods.bbbc.core.lib.UnlocalizedNames;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ConnectedGlass extends BlockContainer {
	
	Block[] ids = new Block[] {block.ConnectedGlass};

	public ConnectedGlass() {
		super(Material.glass);
		setHardness(1.0f);
		setResistance(200000.0f);
		setStepSound(soundTypeGlass);
		setCreativeTab(CreativeTabs.tabBlock);
		setLightLevel(1.0F);
		setBlockName(UnlocalizedNames.getUnlocalizedName(Block_Names.CONNECTEDGLASS));

	}

	@SideOnly(Side.CLIENT)
	public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int par2,
			int par3, int par4, int par5) {
		
		 
		return this.blockIcon [0][0];
	}
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {		
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return this.blockIcon[0][0];
	}
	
	@SideOnly(Side.CLIENT)
	protected IIcon[][] blockIcon;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
			
		blockIcon = new IIcon[16][16];
			
		for (int i = 0; i < blockIcon.length; i++) {
			if (i == 15) {
				for (int ii = 0; ii < blockIcon[i].length; ii++) {
					this.blockIcon[i][ii] = icon.registerIcon(TexturesName.getTextureName(Block_Names.CONNECTEDGLASS
							+ ":"
							, Block_Names.CONNECTEDGLASS
							+ i
							, "_" + ii));
				}
			} else if (i == 5 || i == 6 || i == 9 || i == 10) {
				for (int ii = 0; ii < blockIcon[i].length; ii++) {
					int x = ii & 1;
					this.blockIcon[i][ii] = icon.registerIcon(TexturesName.getTextureName(Block_Names.CONNECTEDGLASS
							+ ":"
							, Block_Names.CONNECTEDGLASS
							+ i
							, "_" + x));
				}

			} else if (isAdvanced(i)) {
				for (int ii = 0; ii < blockIcon[i].length; ii++) {
					int x = ii & 3;
					this.blockIcon[i][ii] = icon.registerIcon(TexturesName.getTextureName(Block_Names.CONNECTEDGLASS
							+ ":"
							, Block_Names.CONNECTEDGLASS
							+ i
							, "_" + x));
				}
			} else {
				for (int ii = 0; ii < blockIcon[i].length; ii++) {
					this.blockIcon[i][ii] = icon.registerIcon(TexturesName.getTextureName(Block_Names.CONNECTEDGLASS
							+ ":"
							, Block_Names.CONNECTEDGLASS
							+ i
							, "_" + 0));
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
		return 1;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return bb.mods.bbbc.core.common.ClientProxy.connectedRender;
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new ConnectedTileEntity(new ResourceLocation(bb.mods.bbbc.core.lib.Reference.MOD_RESOURCE_LOC.toLowerCase(),"textures/blocks/connectedglass/connectedglass0_0.png"));
	}
}
