package bb.mods.bbbc.unrelated.block;

import bb.mods.bbbc.core.util.TexturesName;
import bb.mods.bbbc.core.util.UnlocalizedNames;
import bb.mods.bbbc.unrelated.references.Block_Names;
import bb.mods.bbbc.unrelated.tileentity.TileEntityAufgabenblock;
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
			return blue;
		} else {
			//System.out.println("Yellow Aufgabenblock");
			return yellow;
		}

	}

	@Override
	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_,
			int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_,
			int p_149727_6_, float p_149727_7_, float p_149727_8_,
			float p_149727_9_) {

		if ((p_149727_1_.getBlockMetadata(p_149727_2_, p_149727_3_, p_149727_4_) & 2) == 0&&!p_149727_1_.isRemote) {
			
			for (int i = -1; i <= 1; i++) {
				
				for (int ii = -1; ii <= 1; ii++) {
					
					if (p_149727_1_.getBlock(p_149727_2_+i,p_149727_3_,p_149727_4_+ii)==this) {
						
						//System.out.println("Changed Aufgabenblock");
						
						int newmeta = p_149727_1_.getBlockMetadata(p_149727_2_+i,p_149727_3_, p_149727_4_+ii) ^ 1;
						
						p_149727_1_.setBlockMetadataWithNotify(p_149727_2_+i,p_149727_3_, p_149727_4_+ii, newmeta,0x03);
					}
					
				}
				
			}
			
			if(checkFinished(p_149727_1_,p_149727_2_,p_149727_3_,p_149727_4_)){
				setFinished();
			}
			
		}

		return false;
	}

	private boolean checkFinished(World world, int x,
			int y, int z) {
		
		TileEntity te = world.getTileEntity(x, y, z);
		
		if(te instanceof TileEntityAufgabenblock){
			TileEntityAufgabenblock tea = (TileEntityAufgabenblock)te;
			if(tea.blockList.size()==0){
				tea.startreCalc();
			}
			//TODO: Fix not correct behavior when adding blocks
			return tea.check();
		}
		
		return false;
	}

	private void setFinished() {
		
	}

	@SideOnly(Side.CLIENT)
	IIcon yellow;
	@SideOnly(Side.CLIENT)
	IIcon blue;

	@Override
	public void onNeighborChange(IBlockAccess world, int x, int y, int z,
			int tileX, int tileY, int tileZ) {
		TileEntity te = world.getTileEntity(x, y, z);
		
		if(te instanceof TileEntityAufgabenblock){
			TileEntityAufgabenblock tea = (TileEntityAufgabenblock)te;
			tea.reset();
		}
		
		super.onNeighborChange(world, x, y, z, tileX, tileY, tileZ);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		blue = p_149651_1_.registerIcon(TexturesName
				.getTextureName(Block_Names.AUFGABENBLOCK ,"_blau"));
		yellow = p_149651_1_.registerIcon(TexturesName.getTextureName(Block_Names.AUFGABENBLOCK ,"_gelb"));
		
		blockIcon = yellow;

	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityAufgabenblock();
	}

}
