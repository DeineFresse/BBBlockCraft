package bb.mods.bbbc.interfaces;

import org.lwjgl.opengl.GL11;

import bb.mods.bbbc.tileentity.TileEntityFirstMachine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiFirstMachine extends GuiContainer {

	public GuiFirstMachine(InventoryPlayer invPlayer,TileEntityFirstMachine machine) {
		super(new ContainerFirstMachine(invPlayer,machine));
		xSize = 176;
		ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("bbblockcraft","textures/gui/firstmachine.png");
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1,1,1,1);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft,guiTop,0,0,xSize,ySize);
	}

}
