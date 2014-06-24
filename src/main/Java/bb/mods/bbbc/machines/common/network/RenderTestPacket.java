package bb.mods.bbbc.machines.common.network;

import io.netty.buffer.ByteBuf;
import bb.mods.bbbc.core.common.network.BBBCPacket;
import bb.mods.bbbc.unrelated.tileentity.TileEntityRenderTest;

public class RenderTestPacket extends BBBCPacket {
	
	private int x,y,z;
	
	@Override
	public int getID() {
		return 0;
	}

	@Override
	public void readData(ByteBuf data) {
		x = data.readInt();
		y = data.readInt();
		z = data.readInt();
	}

	@Override
	public void writeData(ByteBuf data) {
		data.writeInt(x);
		data.writeInt(y);
		data.writeInt(z);
	}

	public RenderTestPacket getPacket(TileEntityRenderTest tileEntityRenderTest) {
		x = tileEntityRenderTest.xCoord;
		y = tileEntityRenderTest.yCoord;
		z = tileEntityRenderTest.zCoord;
		return this;
	}

}
