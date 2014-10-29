package bb.mods.bbbc.core.common.network;


import io.netty.buffer.ByteBuf;

public abstract class BBBCPacket {
	
	protected boolean isChunkDataPacket = false;
	
	public abstract int getID();
	
	public abstract void readData(ByteBuf data);
	
	public abstract void writeData(ByteBuf data);

}
