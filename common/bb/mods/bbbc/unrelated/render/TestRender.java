package bb.mods.bbbc.unrelated.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import bb.mods.bbbc.unrelated.common.ClientProxy;
import bb.mods.bbbc.unrelated.tileentity.TileEntityRenderTest;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class TestRender implements ISimpleBlockRenderingHandler {
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		
		TileEntityRenderer.instance.renderTileEntityAt(new TileEntityRenderTest(), 0.0D, 0.0D,0.0D, 0.0F);
		
	}	

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		if (ClientProxy.rederPass == 0) {
			TileEntity te = world.getBlockTileEntity(x, y, z);
		
			double xC=0,yC=0.25,zC=0;
			
			if(te instanceof TileEntityRenderTest){
				xC = ((double)((TileEntityRenderTest) te).x)/1000;
				yC = ((double)((TileEntityRenderTest) te).y)/1000;
				zC = ((double)((TileEntityRenderTest) te).z)/1000;

				((TileEntityRenderTest) te).move();
			}
			
			renderer.drawCrossedSquares(Block.sapling, 2, (double)x+xC, (double)y+yC,(double)z+zC, (float)0.5);
		
		
		} else {
			renderer.renderStandardBlock(bb.mods.bbbc.unrelated.block.block.ConnectedGlass, x, y, z);
		}
		return true;
	}
	
	@Override
	public boolean shouldRender3DInInventory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.testRender;
	}

}
