package bb.mods.bbbc.core;

import java.util.EnumMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.world.World;
import bb.mods.bbbc.core.common.network.BBBCPacket;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.relauncher.Side;

public class BBBCMod {
	
	/*
	 * The following code is not my own it is from :
	 *https://github.com/BuildCraft/BuildCraft/blob/BuildCraft-5.0.x/common/buildcraft/BuildCraftMod.java
	 *commit : 360d782ea9
	 *
	 * */
	
	
	public EnumMap<Side,FMLEmbeddedChannel> channels;
	
	public void sendToPlayers(Packet packet,World world,int x,int y,int z,int maxDist){
		this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
		this.channels.get(Side.SERVER).writeOutbound(packet);
	}
	
	public void sendToPlayers(BBBCPacket packet,World world,int x,int y,int z,int maxDist){
		this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
		this.channels.get(Side.SERVER).writeOutbound(packet);
	}
	
	public void sendToPlayer(EntityPlayer entityplayer,BBBCPacket packet){
		this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
		this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(entityplayer);
		this.channels.get(Side.SERVER).writeOutbound(packet);
	}
	
	public final void sendToServer(BBBCPacket packet){
		
		this.channels.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
		this.channels.get(Side.CLIENT).writeOutbound(packet);
	}

}
