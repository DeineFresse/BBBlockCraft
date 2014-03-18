package bb.mods.bbbc.unrelated.block;

import bb.mods.bbbc.core.lib.TexturesName;
import bb.mods.bbbc.core.lib.UnlocalizedNames;
import bb.mods.bbbc.unrelated.lib.Block_Names;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Aufgabenlblock extends BlockContainer {

	protected Aufgabenlblock() {
		super(Material.sponge);
		setLightLevel(1.0f);
		setBlockName(UnlocalizedNames.getUnlocalizedName(Block_Names.AUFGABENBLOCK));
		
	}

	@Override
	public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_,
			int p_149673_3_, int p_149673_4_, int p_149673_5_) {

		int i = p_149673_1_.getBlockMetadata(p_149673_2_, p_149673_3_,
				p_149673_4_);

		if ((i & 1) == 1) {
			return green;
		} else {
			System.out.println("Yellow Aufgabenblock");
			return red;
		}

	}

	@Override
	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_,
			int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_,
			int p_149727_6_, float p_149727_7_, float p_149727_8_,
			float p_149727_9_) {

		if ((p_149727_1_
				.getBlockMetadata(p_149727_2_, p_149727_3_, p_149727_4_) & 2) == 0&&!p_149727_1_.isRemote) {
			for (int i = -1; i <= 1; i++) {
				for (int ii = -1; ii <= 1; ii++) {
					if (p_149727_1_.getBlock(p_149727_2_+i,p_149727_3_,p_149727_4_+ii)==this) {
						System.out.println("Changed Aufgabenblock");
						p_149727_1_.setBlockMetadataWithNotify(p_149727_2_+i,
								p_149727_3_, p_149727_4_+ii, p_149727_1_
										.getBlockMetadata(p_149727_2_+i,
												p_149727_3_, p_149727_4_+ii) ^ 1,
								0x03);
					}
				}
			}
		}
		
		if(checkFinished(p_149727_1_,p_149727_2_,p_149727_3_,p_149727_4_)){
			setFinished();
		}

		return false;
	}

	private boolean checkFinished(World world, int x,
			int y, int z) {
		
		boolean notfinished = true;
		for(int i = -1;notfinished;i--){
			notfinished = false;
		}
		
		return false;
	}

	private void setFinished() {
		// TODO Auto-generated method stub
		
	}

	@SideOnly(Side.CLIENT)
	IIcon red;
	@SideOnly(Side.CLIENT)
	IIcon green;

	@Override
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		green = p_149651_1_.registerIcon(TexturesName
				.getTextureName(Block_Names.AUFGABENBLOCK ,"_gruen"));
		red = p_149651_1_.registerIcon(TexturesName.getTextureName(Block_Names.AUFGABENBLOCK ,"_gelb"));

	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return null;
	}

}
