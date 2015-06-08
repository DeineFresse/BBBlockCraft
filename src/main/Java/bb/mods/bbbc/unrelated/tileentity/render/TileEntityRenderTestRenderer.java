package bb.mods.bbbc.unrelated.tileentity.render;

import bb.mods.bbbc.unrelated.references.Resources;
import bb.mods.bbbc.unrelated.tileentity.Fishes;
import bb.mods.bbbc.unrelated.tileentity.TileEntityRenderTest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class TileEntityRenderTestRenderer extends TileEntitySpecialRenderer {

	Tessellator t;
	Vec3 xAches = Vec3.createVectorHelper(1, 0, 0);
	Vec3 yAches = Vec3.createVectorHelper(0, 1, 0);
	Vec3 zAches = Vec3.createVectorHelper(0, 0, 1);

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,
								   double d2, float f) {
		t = Tessellator.instance;
		TileEntityRenderTest te = (TileEntityRenderTest) tileentity;

		GL11.glPushMatrix();

		GL11.glTranslatef((float) d0, (float) d1, (float) d2);

		if(te.pass == 0) {
			renderTEPass0(te, tileentity.getWorldObj(), d0, d1, d2, f);
		} else if(te.pass == 1) {
			renderTEPass1(te, tileentity.getWorldObj(), d0, d1, d2, f);
		}
		GL11.glPopMatrix();
	}

	private void renderTEPass0(TileEntityRenderTest te, World worldObj,
							   double d0, double d1, double d2, float f) {
		for(int i = 0; i < te.fishA.size(); i++) {

			te.fishA.get(i).moveFish();
			Fishes fishe = te.fishA.get(i);

			drawFish(fishe);
		}

	}

	public void renderTEPass1(TileEntityRenderTest te, World world, double d0,
							  double d1, double d2, float f) {

		for(int i = 0; i < 4; i++) {
			int q = 1;
			q = q << i;
			if((te.sides & q) != 0) {
				drawSide(Resources.AQUARIUM_BACKGROUND, i);
			} else {
				t.setColorRGBA(128, 128, 128, 255);
				t.setBrightness(te.getBlockType().getMixedBrightnessForBlock(world, te.xCoord, te.yCoord, te.zCoord));
				//drawSide(Blocks.flowing_water.getIcon(0, 0), i);
			}
		}

	}

	private void drawSide(ResourceLocation re, int side) {

		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0, 0.5F);
		GL11.glRotatef(side * (90F), 0F, 1F, 0F);
		GL11.glTranslatef(-0.5F, 0, -0.5F);

		t.startDrawingQuads();
		this.bindTexture(re);

		t.addVertexWithUV(0, 0, 0.999F, 1, 0);
		t.addVertexWithUV(1, 0, 0.999F, 1, 1);
		t.addVertexWithUV(1, 1, 0.999F, 0, 1);
		t.addVertexWithUV(0, 1, 0.999F, 0, 0);

		t.draw();

		GL11.glPopMatrix();

	}

	private void drawSide(IIcon iic, int side) {

		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0, 0.5F);
		GL11.glRotatef(side * (90F), 0F, 1F, 0F);
		GL11.glTranslatef(-0.5F, 0, -0.5F);

		t.startDrawingQuads();
		bindTexture(Minecraft.getMinecraft().getTextureManager().getResourceLocation(0));

		t.addVertexWithUV(0, 0, 0.999F, iic.getMaxU(), iic.getMinV());
		t.addVertexWithUV(1, 0, 0.999F, iic.getMaxU(), iic.getMaxV());
		t.addVertexWithUV(1, 1, 0.999F, iic.getMinU(), iic.getMaxV());
		t.addVertexWithUV(0, 1, 0.999F, iic.getMinU(), iic.getMinV());

		t.draw();

		GL11.glPopMatrix();

	}

	private void drawFish(Fishes fish) {

		//The rendered fish
		ItemStack stack = new ItemStack(Items.fish, 1, 0);
		EntityItem entItem = new EntityItem(Minecraft.getMinecraft().theWorld, 0D, 0D, 0D, stack);
		//Without the below line, the item will spazz out
		entItem.hoverStart = 0.0F;

		//Rotate to default position
		GL11.glPushMatrix();

		GL11.glTranslatef(0.5F, 0, 0.5F);
		GL11.glScalef(fish.size, fish.size, fish.size);
		GL11.glTranslatef(-0.5F, 0, -0.5F);

		GL11.glPushMatrix();

		GL11.glTranslated(fish.xCoord, fish.yCoord, fish.zCoord);

		GL11.glPushMatrix();
		RenderItem.renderInFrame = true;

		//calculate rotation
		Vec3 move = Vec3.createVectorHelper(fish.xMove, fish.yMove, fish.zMove);
		double dot = move.dotProduct(xAches);
		double rot = Math.acos(dot / (move.lengthVector() * xAches.lengthVector())) * -Math.signum(fish.zMove);
		rot = rot * (180 / Math.PI);
		System.out.println(rot);
		GL11.glRotated(180, 0, 1, 0);
		GL11.glRotated(rot, 0, 1, 0);
		GL11.glRotated(-45, 0, 0, 1);

		RenderManager.instance.renderEntityWithPosYaw(entItem, 0, 0, 0, 0.0F, 0.0F);
		RenderItem.renderInFrame = false;
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
