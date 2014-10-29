package bb.mods.bbbc.core.render;

import bb.mods.bbbc.core.block.ConnectedBlock;
import bb.mods.bbbc.core.tileentity.ConnectedTileEntity;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class ConnectedRenderer extends TileEntitySpecialRenderer {

    @Override
    public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
        if (var1 instanceof ConnectedTileEntity) {

            ConnectedTileEntity te = (ConnectedTileEntity) var1;

            GL11.glPushMatrix();

            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_LIGHTING);

            GL11.glTranslatef((float) var2, (float) var4, (float) var6);

            ResourceLocation re;
            ResourceLocation reSide = null;
            ResourceLocation reCorner = null;
            Block b = te.getBlockType();

            if (b instanceof ConnectedBlock) {
                ConnectedBlock cb = (ConnectedBlock) b;
                re = cb.RLocation;
                reSide = cb.RLocationSide;
                reCorner = cb.RLocationCorner;
            } else {
                re = te.getResourceLocation();
            }

            if (re == null) {
                re = Minecraft.getMinecraft().getTextureManager().getDynamicTextureLocation("missing Texture", TextureUtil.missingTexture);
            }

            for (int i = 0; i < 6; i++) {
                if (te.shouldSideBeRendered(ForgeDirection.getOrientation(i))) {
                    if (reSide == null && reCorner == null) {
                        drawSideSimple(re, i, te);
                    } else {
                        drawSideComplex(reSide, reCorner, i, te);
                    }
                } else {
                    //System.out.println(ForgeDirection.getOrientation(i));
                    //drawSide(re, ForgeDirection.SOUTH.ordinal());
                }
            }

            GL11.glEnable(GL11.GL_LIGHTING);

            GL11.glPopMatrix();


        }

    }

    private void drawSideSimple(ResourceLocation re, int side, ConnectedTileEntity te) {

        Tessellator t = Tessellator.instance;

        this.bindTexture(re);

        t.setColorRGBA(1, 1, 1, 1);

        t.setBrightness(te.getBlockType().getLightValue());

        GL11.glPushMatrix();

        GL11.glTranslatef(0.5F, 0.5F, 0.5F);

        switch (ForgeDirection.getOrientation(side)) {
            case SOUTH: {
                GL11.glRotated(-180, 0, 1, 0);
                break;
            }
            case EAST: {
                GL11.glRotated(-90, 0, 1, 0);
                break;
            }
            case WEST: {
                GL11.glRotated(90, 0, 1, 0);
                break;
            }
            case UP: {
                GL11.glRotated(90, 1, 0, 0);
                break;
            }
            case DOWN: {
                GL11.glRotated(-90, 1, 0, 0);
                break;
            }
        }

        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

        t.startDrawingQuads();

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

    private void drawSideComplex(ResourceLocation reSide, ResourceLocation reCorner, int side, ConnectedTileEntity te) {

      //  Minecraft.getMinecraft().getTextureManager().loadTexture(reCorner,new SimpleTexture(reCorner));
      //  Minecraft.getMinecraft().getTextureManager().loadTexture(reSide,new SimpleTexture(reSide));

        int conected = te.getConnection();

        Tessellator t = Tessellator.instance;

        t.setColorRGBA(1, 1, 1, 1);

        t.setBrightness(te.getBlockType().getLightValue());

        GL11.glPushMatrix();

        GL11.glTranslatef(0.5F, 0.5F, 0.5F);

        switch (ForgeDirection.getOrientation(side)) {
            case SOUTH: {
                GL11.glRotated(-180, 0, 1, 0);
                break;
            }
            case EAST: {
                GL11.glRotated(-90, 0, 1, 0);
                break;
            }
            case WEST: {
                GL11.glRotated(90, 0, 1, 0);
                break;
            }
            case UP: {
                GL11.glRotated(90, 1, 0, 0);
                break;
            }
            case DOWN: {
                GL11.glRotated(-90, 1, 0, 0);
                break;
            }
        }

        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

        bindTexture(reSide);

        t.startDrawingQuads();

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
