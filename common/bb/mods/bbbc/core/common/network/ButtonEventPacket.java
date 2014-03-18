package bb.mods.bbbc.core.common.network;

import net.minecraft.tileentity.TileEntity;
import io.netty.buffer.ByteBuf;
import bb.mods.bbbc.core.IGUITileEntity;

public class ButtonEventPacket extends BBBCPacket {

	private int x;
	private int y;
	private int z;
	private byte i;

	@Override
	public int getID() {
		return PacketIDs.BUTTONEVENT;
	}

	@Override
	public void readData(ByteBuf data) {
		x = (data.readInt());
		y = (data.readInt());
		z = (data.readInt());
		i = (data.readByte());
	}

	@Override
	public void writeData(ByteBuf data) {
		data.writeInt(getX());
		data.writeInt(getY());
		data.writeInt(getZ());
		data.writeByte(getI());
	}

	public ButtonEventPacket getButtonEventPacket(TileEntity te, byte i) {

		if (te instanceof IGUITileEntity) {
			x = (te.xCoord);
			y = (te.yCoord);
			z = (te.zCoord);
			this.i = (i);
		}

		return this;
	}

	public int getX() {
		return x;
	}

	public int getZ() {
		return z;
	}

	public int getY() {
		return y;
	}

	public byte getI() {
		return i;
	}

}
