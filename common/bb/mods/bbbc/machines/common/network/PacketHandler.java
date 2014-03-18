package bb.mods.bbbc.machines.common.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.tileentity.TileEntity;
import bb.mods.bbbc.core.IGUITileEntity;
import bb.mods.bbbc.machines.common.CommonProxy;
import bb.mods.bbbc.core.common.network.BBBCChannelHandler;
import bb.mods.bbbc.core.common.network.BBBCPacket;
import bb.mods.bbbc.core.common.network.ButtonEventPacket;
import bb.mods.bbbc.core.common.network.PacketIDs;
import cpw.mods.fml.common.network.NetworkRegistry;

public class PacketHandler extends BBBCChannelHandler {
	
	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf data,
			BBBCPacket packet) {
		super.decodeInto(ctx, data, packet);

		INetHandler netHandler = ctx.attr(NetworkRegistry.NET_HANDLER).get();

		EntityPlayer player = CommonProxy.proxy
				.getPlayerFromNetHandler(netHandler);
		
		System.out.println("Event recieved");

		int packetID = packet.getID();
		switch (packetID) {
		case PacketIDs.BUTTONEVENT: {
			if (packet instanceof ButtonEventPacket && player != null) {

				System.out.println(player.isClientWorld());
				
				System.out.println("ButtonEventPacket recieved");
				
				ButtonEventPacket packetBE = (ButtonEventPacket) packet;
				
				
				TileEntity te = player.getEntityWorld().getTileEntity(
						packetBE.getX(), packetBE.getY(), packetBE.getZ());

				
				System.out.println("Hey" + packetBE.getX() + ":"
						+ packetBE.getY() + ":" + packetBE.getZ());

				if (te != null && (te instanceof IGUITileEntity)) {
					IGUITileEntity Ite = (IGUITileEntity) te;
					Ite.onReceiveButtonEvent(packetBE.getI());
				}
			}
			break;
		}
		}
	}
}