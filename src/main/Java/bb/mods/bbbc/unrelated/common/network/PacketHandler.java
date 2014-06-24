package bb.mods.bbbc.unrelated.common.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import bb.mods.bbbc.core.common.network.BBBCChannelHandler;
import bb.mods.bbbc.core.common.network.BBBCPacket;
import bb.mods.bbbc.core.common.network.ButtonEventPacket;

public class PacketHandler extends BBBCChannelHandler{

	public PacketHandler(){
		addDiscriminator(0, ButtonEventPacket.class);
	}
	
	@Override
	public void decodeInto(ChannelHandlerContext ctx,ByteBuf data,BBBCPacket packet){
		super.decodeInto(ctx, data, packet);
	}
	
}
