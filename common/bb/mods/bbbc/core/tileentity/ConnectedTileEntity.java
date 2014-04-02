package bb.mods.bbbc.core.tileentity;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class ConnectedTileEntity extends TileEntity {

	private ResourceLocation re;

	protected boolean hasChanged = true;

	protected int connection;

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

	public ResourceLocation getResourceLocation() {
		return re;
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		hasChanged = true;
	}

	public int getConnection() {
		if (!hasChanged) {
			return connection;
		} else {
			checkConnection();
			return connection;
		}
	}

	private void checkConnection() {

		int num = 0;
		for (int i = -1; i <= 1; i++) {
			for (int ii = -1; ii <= 1; ii++) {
				for (int iii = -1; iii <= 1; iii++) {
					if (!(i == 0 && ii == 0 && iii == 0)) {
						if (canConnect(
								this.getWorldObj().getBlock(xCoord+i, yCoord+ii,
										zCoord+iii),
								new Block[] { this.getWorldObj().getBlock(
										xCoord, yCoord, zCoord) })) {
							connection = 1 >>> num;
						}
						num++;
					}
				}
			}
		}

	}

	private static boolean canConnect(Block blockId, Block[] ids) {

		for (int i = 0; i < ids.length; i++) {
			if (blockId == ids[i]) {
				return true;
			}
		}

		return false;
	}
}
