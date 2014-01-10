package bb.mods.bbbc.unrelated.tileentity.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
//import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import bb.mods.bbbc.unrelated.tileentity.Fishes;
import bb.mods.bbbc.unrelated.tileentity.TileEntityRenderTest;

public class TileEntityRenderTestRenderer extends TileEntitySpecialRenderer {

	public static ResourceLocation fish = new ResourceLocation("minecraft",
			"textures/items/fish_raw.png");
	public static ResourceLocation background = new ResourceLocation(
			"bbblockcraft", "textures/tileentitys/aquarium/background.png");

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,
			double d2, float f) {
		TileEntityRenderTest te = (TileEntityRenderTest) tileentity;
		renderTE(te, tileentity.worldObj, d0, d1, d2, f);
	}

	public void renderTE(TileEntityRenderTest te, World world, double d0,
			double d1, double d2, float f) {

		//Tessellator t = Tessellator.instance;

		//int dir = world.getBlockMetadata(te.xCoord, te.yCoord, te.zCoord);

		GL11.glPushMatrix();
		GL11.glTranslatef((float) d0, (float) d1, (float) d2);
		
		for (int i = 0; i < te.fishA.size(); i++) {

			te.fishA.get(i).moveFish();
			Fishes fishe = te.fishA.get(i);

			drawFish(0.5F, fishe.xCoord, fishe.yCoord, fishe.zCoord, 0F, 0F, 0F);
		}
		//int x = te.xCoord, y = te.yCoord, z = te.zCoord;

		
		for (int i = 0; i <=3; i++) {
			
			int q = 1;
			q=q<<i;
			
			if ((te.sides & q) != 0) {
				GL11.glPushMatrix();
				GL11.glTranslatef(0.5F, 0, 0.5F);
				GL11.glRotatef(i * (90F), 0F, 1F, 0F);
				GL11.glTranslatef(-0.5F, 0, -0.5F);
				drawSide();
				GL11.glPopMatrix();
			}
		}
		GL11.glPopMatrix();
	}

	private void drawSide() {

		Tessellator t = Tessellator.instance;

		t.startDrawingQuads();
		this.bindTexture(background);

		t.addVertexWithUV(0, 0, 0.999F, 1, 0);
		t.addVertexWithUV(1, 0, 0.999F, 1, 1);
		t.addVertexWithUV(1, 1, 0.999F, 0, 1);
		t.addVertexWithUV(0, 1, 0.999F, 0, 0);

		t.draw();

	}

	private void drawFish(float size, float xCoord, float yCoord, float zCoord,
			float rotX, float rotY, float rotZ) {
		Tessellator t = Tessellator.instance;

		t.startDrawingQuads();

		t.setColorRGBA(255, 255, 255, 255);
		t.setNormal(0,0,0);

		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0, 0.5F);
		GL11.glRotatef(rotX * (-90F), 1F, 0F, 0F);
		GL11.glRotatef(rotY * (-90F), 0F, 1F, 0F);
		GL11.glRotatef(rotZ * (-90F), 0F, 0F, 1F);
		GL11.glScalef(size, size, size);
		GL11.glTranslatef(-0.5F, 0, -0.5F);
		GL11.glTranslatef(xCoord, yCoord, zCoord);
		this.bindTexture(fish);
		t.addVertexWithUV(0, 0.5, 0.5, 1, 0);
		t.addVertexWithUV(0.5, 0, 0.5, 1, 1);
		t.addVertexWithUV(1, 0.5, 0.5, 0, 1);
		t.addVertexWithUV(0.5, 1, 0.5, 0, 0);
		t.draw();

		GL11.glPopMatrix();
	}

}
