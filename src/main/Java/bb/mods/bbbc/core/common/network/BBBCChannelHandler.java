package bb.mods.bbbc.core.common.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;

public class BBBCChannelHandler extends
		FMLIndexedMessageToMessageCodec<BBBCPacket> {

	public BBBCChannelHandler() {
		addDiscriminator(0,ButtonEventPacket.class);
	}
	
	

	@Override
	public void encodeInto(ChannelHandlerContext ctx, BBBCPacket packet,
			ByteBuf data) throws Exception {
		packet.writeData(data);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf data,BBBCPacket packet) {
		packet.readData(data);
	}
}
