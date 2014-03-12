package bb.mods.bbbc.core.common.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.tileentity.TileEntity;
import bb.mods.bbbc.core.IGUITileEntity;
import bb.mods.bbbc.core.common.ClientProxy;
import cpw.mods.fml.common.network.NetworkRegistry;

public class PacketHandler extends BBBCChannelHandler {

	public PacketHandler() {
		addDiscriminator(0, ButtonEventPacket.class);
	}

	
	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf data,
			BBBCPacket packet) {
		super.decodeInto(ctx, data, packet);
		INetHandler netHandler = ctx.attr(NetworkRegistry.NET_HANDLER).get();

		EntityPlayer player = ClientProxy.proxy.getPlayerFromNetHandler(netHandler);
		
		
		if(netHandler!=null&&netHandler instanceof NetHandlerPlayServer){
			System.out.println("Server");
			NetHandlerPlayServer a = (NetHandlerPlayServer) netHandler;
			player = a.playerEntity;
		}
		else if(netHandler != null){
			
			System.out.println(netHandler.getClass().toString());
			
		}
		else{
			System.out.println("Null");
			player = Minecraft.getMinecraft().thePlayer;
		}
		
		int packetID = packet.getID();
		System.out.println("Test" + packetID);
		switch (packetID) {

		case PacketIDs.BUTTONEVENT: {
			if (packet instanceof ButtonEventPacket && player != null) {
				ButtonEventPacket packetBE = (ButtonEventPacket) packet;

				TileEntity te = player.getEntityWorld().getTileEntity(
						packetBE.x, packetBE.z, packetBE.y);

				System.out.println("Hey" + packetBE.x + ":" + packetBE.y + ":"
						+ packetBE.z);
				System.out.print(te != null);
				if (te != null && (te instanceof IGUITileEntity)) {
					System.out.println("Test");
					IGUITileEntity Ite = (IGUITileEntity) te;
					Ite.onReceiveButtonEvent(packetBE.i);
				}
			}
			break;
		}

		}
	}

}
