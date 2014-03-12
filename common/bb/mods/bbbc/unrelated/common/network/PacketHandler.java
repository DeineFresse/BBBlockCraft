package bb.mods.bbbc.unrelated.common.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import bb.mods.bbbc.core.common.network.BBBCChannelHandler;
import bb.mods.bbbc.core.common.network.BBBCPacket;

public class PacketHandler extends BBBCChannelHandler{

	@Override
	public void decodeInto(ChannelHandlerContext ctx,ByteBuf data,BBBCPacket packet){
		super.decodeInto(ctx, data, packet);
	}
	
}
