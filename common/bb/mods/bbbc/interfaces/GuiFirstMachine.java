package bb.mods.bbbc.interfaces;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import bb.mods.bbbc.common.network.PacketHandler;
import bb.mods.bbbc.tileentity.TileEntityFirstMachine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiFirstMachine extends GuiContainer {

	private TileEntityFirstMachine machine;
	
	public GuiFirstMachine(InventoryPlayer invPlayer,
			TileEntityFirstMachine machine) {
		super(new ContainerFirstMachine(invPlayer, machine));
		
		this.machine = machine;
		
		xSize = 176;
		ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation(
			"bbblockcraft", "textures/gui/firstmachine.png");

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1, 1, 1, 1);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		fontRenderer.drawString("Silly Machine", 8, 6, 0x404040);

	}

	private static final String ENABLE_TEXT = "Enable";
	private static final String DISABLE_TEXT = "Disable";
	
	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
		super.initGui();
		buttonList.clear();

		buttonList.add(new GuiButton(0, guiLeft + 100, guiTop + 14, 60, 20,((machine.getBlockMetadata()&1)==1?ENABLE_TEXT:DISABLE_TEXT)));
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		PacketHandler.sendButtonPacket((byte)button.id);
		if(button.id == 0){
			button.displayString = button.displayString.equals(DISABLE_TEXT)?ENABLE_TEXT:DISABLE_TEXT;
		}
	}

}
