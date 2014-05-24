package bb.mods.bbbc.core.tileentity;

import bb.mods.bbbc.core.block.ConnectedBlock;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

public class ConnectedTileEntity extends TileEntity {

	private ResourceLocation re;

	protected boolean hasChanged = true;

	private int connection;

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbttagcompound);
	
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());		
		super.onDataPacket(net, pkt);
	}
	
	public ConnectedTileEntity(ResourceLocation res) {
		re = res;
	}
	
	public ConnectedTileEntity(){
	}

	public ResourceLocation getResourceLocation() {
		return re;
	}
	
	public TileEntity setRecourceLocation(ResourceLocation res){
		re= res;
		return this;
	}

	@Override
	public void updateEntity() {
	}
	
	public void neighborChanged(){
		System.out.println("Changed");
		checkConnection();
		hasChanged = true;
	}

	public int getConnection() {
		if (!hasChanged) {
			return connection;
		} else {
			checkConnection();
			hasChanged = false;
			return connection;
		}
	}

	private void checkConnection() {

		System.out.println("Checking Connection! : " +connection);
		
		if(canConnectTo(getWorldObj().getBlock(xCoord, yCoord+1, zCoord))){
			connection |= 1<<ForgeDirection.UP.ordinal();
		}
		else{
			connection &= ~(1<<ForgeDirection.UP.ordinal());
		}
		
		if(canConnectTo(getWorldObj().getBlock(xCoord, yCoord-1, zCoord))){
			connection |= 1<<ForgeDirection.DOWN.ordinal();
		}
		else{
			connection &= ~(1<<ForgeDirection.DOWN.ordinal());
		}
		
		if(canConnectTo(getWorldObj().getBlock(xCoord, yCoord, zCoord-1))){
			connection |= 1<<ForgeDirection.NORTH.ordinal();
		}
		else{
			connection &= ~(1<<ForgeDirection.NORTH.ordinal());
		}
		
		if(canConnectTo(getWorldObj().getBlock(xCoord, yCoord, zCoord+1))){
			connection |= 1<<ForgeDirection.SOUTH.ordinal();
			System.out.println("South Connection astablished");
		}
		else{
			connection &= ~(1<<ForgeDirection.SOUTH.ordinal());
		}
		
		if(canConnectTo(getWorldObj().getBlock(xCoord+1, yCoord, zCoord))){
			connection |= 1<<ForgeDirection.EAST.ordinal();
		}
		
		else{
			connection &= ~(1<<ForgeDirection.EAST.ordinal());
		}
		
		if(canConnectTo(getWorldObj().getBlock(xCoord-1, yCoord, zCoord))){
			connection |= 1<<ForgeDirection.WEST.ordinal();
		}
		
		else{
			connection &= (~(1<<ForgeDirection.WEST.ordinal()));
		}
		
		System.out.println("New Connection : "+connection);
		//hasChanged = false;
		
	}
	
	private boolean canConnectTo(Block conTo){
		boolean r = false;
		if(conTo == this.blockType){
			r = true;
		}
		if(this.blockType instanceof ConnectedBlock){
			ConnectedBlock con = (ConnectedBlock) this.blockType;
			for(Block b:con.canConnectToBlock()){
				if(b == conTo){
					r= true;
					break;
				}
			}
		}
		//System.out.println("cannConnectTo : "+r);
		return r;
	}


	public boolean shouldSideBeRendered(ForgeDirection forgeDirection) {
		int ord = forgeDirection.ordinal();
		//System.out.println("Ordinal:"+ord);
		return (getConnection() & (1<<ord))==0;
	}
}
