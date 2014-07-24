package bb.mods.bbbc.core.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import bb.mods.bbbc.core.tileentity.ConnectedTileEntity;

public class ConnectedRenderer extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		renderTileEntityAt(var1, var2, var4, var6);
	}
	

	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6) {

		if (var1 instanceof ConnectedTileEntity) {

			ConnectedTileEntity te = (ConnectedTileEntity) var1;
			// World world = var1.getWorldObj();

			GL11.glPushMatrix();

			GL11.glTranslatef((float) var2, (float) var4, (float) var6);

			ResourceLocation re = (te.getResourceLocation());

			for (int i = 0; i < 6; i++) {
				if (te.shouldSideBeRendered(ForgeDirection.getOrientation(i))) {
					 drawSide(re, i);				 
				} else {
					//System.out.println(ForgeDirection.getOrientation(i));
					//drawSide(re, ForgeDirection.SOUTH.ordinal());
				}
			}

			GL11.glPopMatrix();
		}
	}

	private void drawSide(ResourceLocation re, int side) {

		Tessellator t = Tessellator.instance;

		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);

        switch(ForgeDirection.getOrientation(side)){
            case SOUTH : {
                GL11.glRotated(-180,0,1,0);
                break;
            }
            case EAST:{
                GL11.glRotated(-90,0,1,0);
                break;
            }
            case WEST:{
                GL11.glRotated(90,0,1,0);
                break;
            }
            case UP:{
                GL11.glRotated(90,1,0,0);
                break;
            }
            case DOWN:{
                GL11.glRotated(-90,1,0,0);
                break;
            }
        }



		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

		t.startDrawingQuads();
		this.bindTexture(re);

		t.addVertexWithUV(0, 0, 0.999F, 1, 0);
		t.addVertexWithUV(1, 0, 0.999F, 1, 1);
		t.addVertexWithUV(1, 1, 0.999F, 0, 1);
		t.addVertexWithUV(0, 1, 0.999F, 0, 0);
		
		t.addVertexWithUV(1, 1, 0.999F, 0, 1);
		t.addVertexWithUV(1, 0, 0.999F, 1, 1);
		t.addVertexWithUV(0, 0, 0.999F, 1, 0);
		t.addVertexWithUV(0, 1, 0.999F, 0, 0);

		t.draw();

		GL11.glPopMatrix();

	}

}
