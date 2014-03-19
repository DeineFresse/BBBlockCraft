package bb.mods.bbbc.core.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import bb.mods.bbbc.core.tileentity.IConnectetTileEntity;

@SuppressWarnings("unused")
public class ConnectedRenderer extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		renderTileEntityAt(var1, var2, var4, var6);
	}

	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6) {
		IConnectetTileEntity te = (IConnectetTileEntity) var1;
		// World world = var1.getWorldObj();

		GL11.glPushMatrix();

		GL11.glTranslatef((float) var2, (float) var4, (float) var6);

		ResourceLocation re = (te.getResourceLocation());

		for (int i = 0; i <= 6; i++) {
			drawSide(re, i, 3);
		}

		GL11.glPopMatrix();

	}

	private void drawSide(ResourceLocation re, int side, int rot) {

		Tessellator t = Tessellator.instance;

		GL11.glPushMatrix();

		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);

		if (side <= 4) {
			GL11.glRotatef(side * (90F), 0F, 1F, 0F);

		} else {
			if (side == 5) {
				GL11.glRotatef(90F, 1F, 0F, 0F);
			} else {
				GL11.glRotatef(-90F, 1F, 0F, 0F);
			}

		}
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

		t.startDrawingQuads();
		this.bindTexture(re);

		switch (rot) {
		case 0: {
			t.addVertexWithUV(0, 0, 0.999F, 1, 0);
			t.addVertexWithUV(1, 0, 0.999F, 1, 1);
			t.addVertexWithUV(1, 1, 0.999F, 0, 1);
			t.addVertexWithUV(0, 1, 0.999F, 0, 0);
			break;
		}
		case 1: {
			t.addVertexWithUV(0, 1, 0.999F, 1, 0);
			t.addVertexWithUV(0, 0, 0.999F, 1, 1);
			t.addVertexWithUV(1, 0, 0.999F, 0, 1);
			t.addVertexWithUV(1, 1, 0.999F, 0, 0);
			break;
		}
		case 2: {
			t.addVertexWithUV(1, 1, 0.999F, 1, 0);
			t.addVertexWithUV(0, 1, 0.999F, 1, 1);
			t.addVertexWithUV(0, 0, 0.999F, 0, 1);
			t.addVertexWithUV(1, 0, 0.999F, 0, 0);
			break;
		}
		case 3: {
			t.addVertexWithUV(1, 0, 0.999F, 1, 0);
			t.addVertexWithUV(1, 1, 0.999F, 1, 1);
			t.addVertexWithUV(0, 1, 0.999F, 0, 1);
			t.addVertexWithUV(0, 0, 0.999F, 0, 0);
			break;
		}
		}
		t.draw();

		GL11.glPopMatrix();
		GL11.glPopMatrix();

	}

}
