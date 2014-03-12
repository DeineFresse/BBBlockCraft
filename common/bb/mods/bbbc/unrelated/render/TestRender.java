package bb.mods.bbbc.unrelated.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import bb.mods.bbbc.unrelated.common.ClientProxy;
import bb.mods.bbbc.unrelated.tileentity.TileEntityRenderTest;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class TestRender extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler {
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		
		this.renderTileEntityAt(new TileEntityRenderTest(), 0.0D, 0.0D,0.0D, 0.0F);
		
	}	

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		if (ClientProxy.rederPass == 0) {
						
			//aquarium(world,x,y,z);
			
			//drawSaplinInBlock(world, x, y, z, renderer);
			
		} else {
			renderer.renderStandardBlock(bb.mods.bbbc.unrelated.block.block.ConnectedGlass, x, y, z);
		}
		return true;
	}
	
	public void aquarium(IBlockAccess world,int x,int y,int z){
		IIcon a  = Blocks.water.getIcon(world, x, y, z, 0);
		
		double maU = a.getMaxU();
		double maV = a.getMaxV();
		double miU = a.getMinU();
		double miV = a.getMinV();
		
		Tessellator t = Tessellator.instance;
		
		//func_147439 was getBlockId
		
		if(world.getBlock(x, y, z)!=world.getBlock(x-1, y, z)){			
		t.addVertexWithUV(x+0.01D, y, z+1, maU, maV);
		t.addVertexWithUV(x+0.01D, y, z, maU, miV);
		t.addVertexWithUV(x+0.01D, y+1, z, miU, miV);
		t.addVertexWithUV(x+0.01D, y+1, z+1, miU, maV);
		}
		
		if(world.getBlock(x, y, z)!=world.getBlock(x+1, y, z)){	
		t.addVertexWithUV(x+1-0.01D, y+1, z+1, maU, maV);
		t.addVertexWithUV(x+1-0.01D, y+1, z, maU, miV);
		t.addVertexWithUV(x+1-0.01D, y, z, miU, miV);
		t.addVertexWithUV(x+1-0.01D, y, z+1, miU, maV);
		}
		
		if(world.getBlock(x, y, z)!=world.getBlock(x, y, z+1)){
		t.addVertexWithUV(x  ,y+1, z+1-0.01D, maU, maV);
		t.addVertexWithUV(x+1,y+1, z+1-0.01D, maU, miV);
		t.addVertexWithUV(x+1,y  , z+1-0.01D, miU, miV);
		t.addVertexWithUV(x  ,y  , z+1-0.01D, miU, maV);
		}
		
		if(world.getBlock(x, y, z)!=world.getBlock(x, y, z-1)){
		t.addVertexWithUV(x+1,y+1,z+0.01D, maU, maV);
		t.addVertexWithUV(x  ,y+1,z+0.01D, maU, miV);
		t.addVertexWithUV(x  ,y  ,z+0.01D, miU, miV);
		t.addVertexWithUV(x+1,y  ,z+0.01D, miU, maV);
		}
		
		if(world.getBlock(x, y, z)!=world.getBlock(x, y+1, z)){
		t.addVertexWithUV(x+1,y+1-0.01D, z, maU, maV);
		t.addVertexWithUV(x+1,y+1-0.01D, z+1, maU, miV);
		t.addVertexWithUV(x,  y+1-0.01D, z+1, miU, miV);
		t.addVertexWithUV(x,  y+1-0.01D,z, miU, maV);
		}
		
		a = Blocks.sand.getIcon(world, x, y, z, 0);
		
		maU = a.getMaxU();
		maV = a.getMaxV();
		miU = a.getMinU();
		miV = a.getMinV();
		
		if(world.getBlock(x, y, z)!=world.getBlock(x, y-1, z)){
		t.addVertexWithUV(x , y+0.01D, z, maU, maV);
		t.addVertexWithUV(x , y+0.01D, z+1, maU, miV);
		t.addVertexWithUV(x+1,y+0.01D, z+1, miU, miV);
		t.addVertexWithUV(x+1,y+0.01D,z, miU, maV);
		}
	}
	
	public void drawSaplinInBlock(IBlockAccess world,int x,int y,int z,RenderBlocks renderer){
		//TileEntity te = world.getBlockTileEntity(x, y, z);
		
		double xC=0,yC=0.25,zC=0;
		
		
		renderer.drawCrossedSquares(Blocks.sapling.getIcon(0,2), (double)x+xC, (double)y+yC,(double)z+zC, (float)0.5);
	}
	
	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.testRender;
	}

	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
			
	}

}
