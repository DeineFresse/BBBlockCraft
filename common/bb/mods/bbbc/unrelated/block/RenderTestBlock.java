package bb.mods.bbbc.unrelated.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import bb.mods.bbbc.core.lib.TexturesName;
import bb.mods.bbbc.core.lib.UnlocalizedNames;
import bb.mods.bbbc.unrelated.common.ClientProxy;
import bb.mods.bbbc.unrelated.lib.Block_Names;
import bb.mods.bbbc.unrelated.tileentity.TileEntityRenderTest;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderTestBlock extends BlockContainer {

	public RenderTestBlock(int id) {
		super(id, Material.clay);
		setCreativeTab(CreativeTabs.tabBlock);
		setLightValue(0.5F);
		setUnlocalizedName(UnlocalizedNames.getUnlocalizedName(Block_Names.RTB));
	}
	
	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random) {
		super.updateTick(par1World, par2, par3, par4, par5Random);
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;		
	}
	
	@Override
	public int getRenderType(){
		return ClientProxy.testRender;
	}
	
	@Override
	public boolean canRenderInPass(int pass){
		
		ClientProxy.rederPass = pass;
		
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	Icon blockIcon; 
	
	@Override
	public Icon getBlockTexture(IBlockAccess par1iBlockAccess, int par2,
			int par3, int par4, int par5) {
		return blockIcon;
		}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon){
		blockIcon = icon.registerIcon(TexturesName.getTextureName(Block_Names.TESTBLOCK.toLowerCase(),"_top"));
	}
	
	@Override
	public int getRenderBlockPass(){
	return 1;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityRenderTest();
	}

}
