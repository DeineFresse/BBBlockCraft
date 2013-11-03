package bb.mods.bbbc.common.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import bb.mods.bbbc.interfaces.ContainerFirstMachine;
import bb.mods.bbbc.lib.Reference;
import bb.mods.bbbc.tileentity.TileEntityFirstMachine;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {
	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {
		ByteArrayDataInput reader = ByteStreams.newDataInput(packet.data);
	
		EntityPlayer entityPlayer = (EntityPlayer)player;
		
		byte packetId = reader.readByte();
		
		switch(packetId){
		case 0:{
			byte buttonId = reader.readByte();
			Container container = entityPlayer.openContainer;
			if(container != null&& container instanceof ContainerFirstMachine){
				TileEntityFirstMachine machine = ((ContainerFirstMachine)container).getMachine();
				machine.receiveButtonEvent(buttonId);
			}
			
			break;
		}
		}
		
			
		
	}
	
	public static void sendButtonPacket(byte id){
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream = new DataOutputStream(byteStream);
		
		try{
			dataStream.write((byte)0);
			dataStream.write(id);
			
			PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket(Reference.MOD_CHANNEL,byteStream.toByteArray()));
		}
		catch(IOException ex){
			System.err.append("Failed to send Button Packet");
		}
	}
	
}
