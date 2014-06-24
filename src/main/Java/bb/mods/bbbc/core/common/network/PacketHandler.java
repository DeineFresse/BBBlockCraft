package bb.mods.bbbc.core.common.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class PacketHandler extends BBBCChannelHandler {
	
	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf data,
			BBBCPacket packet) {
		super.decodeInto(ctx, data, packet);
		System.out.println("Event recieved : CORE");
	}

}
