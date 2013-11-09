package bb.mods.bbbc.interfaces;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import bb.mods.bbbc.common.network.PacketHandler;
import bb.mods.bbbc.tileentity.TileEntityHouseMachine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiHousemachine extends GuiContainer {

	@SuppressWarnings("unused")
	private TileEntityHouseMachine machine;

	public GuiHousemachine(InventoryPlayer invPlayer,
			TileEntityHouseMachine te) {
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
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		fontRenderer.drawSplitString("Silly Machine", 8, 6, 100, 0x404040);

	}
	
	@Override
	public void initGui() {
		super.initGui();
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		PacketHandler.sendButtonPacket((byte) button.id);
	}

}
