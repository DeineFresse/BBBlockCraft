package bb.mods.bbbc.core.common.network;

import net.minecraft.tileentity.TileEntity;
import io.netty.buffer.ByteBuf;
import bb.mods.bbbc.core.IGUITileEntity;

public class ButtonEventPacket extends BBBCPacket {

	int x, y, z;
	byte i;

	@Override
	public int getID() {
		return PacketIDs.BUTTONEVENT;
	}

	@Override
	public void readData(ByteBuf data) {
		x = data.readInt();
		y = data.readInt();
		z = data.readInt();
		i = data.readByte();
	}

	@Override
	public void writeData(ByteBuf data) {
		data.writeInt(x);
		data.writeInt(y);
		data.writeInt(z);
		data.writeByte(i);
	}

	public ButtonEventPacket getButtonEventPacket(TileEntity te, byte i) {
		
		if (te instanceof IGUITileEntity) {
			x = te.xCoord;
			y = te.yCoord;
			z = te.zCoord;
			this.i = i;
		}

		return this;
	}

}
