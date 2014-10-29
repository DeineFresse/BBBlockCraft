package bb.mods.bbbc.machines.interfaces;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import bb.mods.bbbc.BBBlockCraftMachines;
import bb.mods.bbbc.core.common.network.ButtonEventPacket;
import bb.mods.bbbc.machines.block.block;
import bb.mods.bbbc.machines.tileentity.TileEntityFirstMachine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiFirstMachine extends GuiContainer {

	private final TileEntityFirstMachine machine;

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

		int meta = machine.getWorldObj().getBlockMetadata(machine.xCoord,
				machine.yCoord, machine.zCoord);
		int type = meta / 2;

		switch (type) {
		case 1: {
			drawTexturedModalRect(guiLeft + 6, guiTop + 52, 40, ySize, 20, 20);
			break;
		}
		case 2: {
			drawTexturedModalRect(guiLeft + 6, guiTop + 52, 20, ySize, 20, 20);
			break;
		}
		case 3: {
			drawTexturedModalRect(guiLeft + 6, guiTop + 52, 0, ySize, 20, 20);
			break;
		}
		}

		float filled = (float) machine.getAnvils()
				/ (float) (machine.getSizeInventory() * machine
						.getInventoryStackLimit());
		int barHeight = (int) (filled * 41);

		if (barHeight > 0) {
			int srcX = xSize;
			int srcY = 41 - barHeight;

			drawTexturedModalRect(guiLeft + 155, guiTop + 77 - barHeight, srcX,
					srcY, 10, barHeight);
		}

		Minecraft.getMinecraft().getTextureManager()
				.bindTexture(TextureMap.locationBlocksTexture);
		drawTexturedModelRectFromIcon(guiLeft + 8, guiTop + 35,
				block.FirstMachine.getIcon(1, meta), 16, 16);

	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		fontRendererObj.drawSplitString("Silly Machine", 8, 6, 100, 0x404040);

		int type = machine.getWorldObj().getBlockMetadata(machine.xCoord,
				machine.yCoord, machine.zCoord) / 2;

		String str;
		boolean invalid = true;
		int count = 0;
		if (type == 0) {
			str = "No type selected";
		} else {
			if (type == 3) {
				count = 5;
			} else if (type == 1) {
				count = 12;
			} else {
				count = 9;
			}
			str = count + " Anvil�s needed per drop!";
		}

		if (machine.getAnvils() >= count) {
			invalid = false;
		}

		int color = invalid ? 0xD30000 : 0x404040;
		fontRendererObj.drawSplitString(str, 45, 48, 100, color);

	}

	private static final String ENABLE_TEXT = "Enable";
	private static final String DISABLE_TEXT = "Disable";

	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
		super.initGui();
		buttonList.clear();

		buttonList.add(new GuiButton(0, guiLeft + 80, guiTop + 14, 48, 20,
				((machine.getBlockMetadata() & 1) == 1 ? ENABLE_TEXT
						: DISABLE_TEXT)));

		GuiButton clearButton = new GuiButton(1, guiLeft + 130, guiTop + 14,
				40, 20, "Clear");
		clearButton.enabled = machine.getBlockMetadata() / 2 != 0;
		buttonList.add(clearButton);

	}

	@Override
	protected void actionPerformed(GuiButton button) {
		
		ButtonEventPacket BEP = new ButtonEventPacket().getButtonEventPacket(machine.xCoord,machine.yCoord,machine.zCoord,(byte)button.id);
		
		BBBlockCraftMachines.instance.sendToServer(BEP);
		
		if (button.id == 0) {
			button.displayString = button.displayString.equals(DISABLE_TEXT) ? ENABLE_TEXT
					: DISABLE_TEXT;
		} else if (button.id == 1) {
			button.enabled = false;
		}
	}

}
