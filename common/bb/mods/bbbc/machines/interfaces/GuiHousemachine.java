package bb.mods.bbbc.machines.interfaces;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import bb.mods.bbbc.machines.tileentity.TileEntityHouseMachine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiHousemachine extends GuiContainer {

	private TileEntityHouseMachine machine;

	public GuiHousemachine(InventoryPlayer invPlayer, TileEntityHouseMachine te) {
		super(new ContainerHouseMachine(invPlayer, te));

		this.machine = te;

		xSize = 176;
		ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation(
			"bbblockcraft", "textures/gui/housemaker.png");

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1, 1, 1, 1);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		float filled = machine.getTimer() / machine.getMacTimer();

		float barHeight = (int) (filled * 75);

		if (barHeight > 0) {
			int srcX = 75 - (int) barHeight;
			int srcY = ySize;

			drawTexturedModalRect(guiLeft + 104 - (int) barHeight, guiTop + 30,
					srcX, srcY, (int) barHeight, 18);
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		fontRendererObj.drawSplitString("Silly Machine", 8, 6, 100, 0x404040);

	}

	@Override
	public void initGui() {
		super.initGui();
	}

	@Override
	protected void actionPerformed(GuiButton button) {
	}

}