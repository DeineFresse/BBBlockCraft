package bb.mods.bbbc.unrelated.tileentity;

import java.util.ArrayList;
import java.util.List;

import bb.mods.bbbc.core.util.LogHelper;
import bb.mods.bbbc.unrelated.block.block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAufgabenblock extends TileEntity {

	public List<Coord> blockList = new ArrayList<Coord>();

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord,
				this.zCoord, 1, nbttagcompound);

	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
		super.onDataPacket(net, pkt);
	}

	@Override
	public void readFromNBT(NBTTagCompound p_145839_1_) {
		super.readFromNBT(p_145839_1_);
	}

	@Override
	public void writeToNBT(NBTTagCompound p_145841_1_) {
		super.writeToNBT(p_145841_1_);
	}

	public void startreCalc() {
		blockList.clear();
		if (getWorldObj().getBlock(xCoord, yCoord, zCoord) == block.Aufgabenblock) {
			blockList.add(new Coord(xCoord, yCoord, zCoord));
		}
		reCalc(xCoord, yCoord, zCoord);
	}

	private void reCalc(int x, int y, int z) {
		if (!(blockList.size() >= 200000)) {
			if (worldObj.getBlock(x + 1, y, z) == block.Aufgabenblock) {
				if (!containsBlock(x + 1, y, z)) {
					blockList.add(new Coord(x + 1, y, z));
					reCalc(x + 1, y, z);
				}
			}
			if (worldObj.getBlock(x - 1, y, z) == block.Aufgabenblock) {
				if (!containsBlock(x - 1, y, z)) {
					blockList.add(new Coord(x - 1, y, z));
					reCalc(x - 1, y, z);
				}
			}
			if (worldObj.getBlock(x, y, z + 1) == block.Aufgabenblock) {
				if (!containsBlock(x, y, z + 1)) {
					blockList.add(new Coord(x, y, z + 1));
					reCalc(x, y, z + 1);
				}
			}
			if (worldObj.getBlock(x, y, z - 1) == block.Aufgabenblock) {
				if (!containsBlock(x, y, z - 1)) {
					blockList.add(new Coord(x, y, z - 1));
					reCalc(x, y, z - 1);
				}
			}
		}

	}

	private boolean containsBlock(int x, int y, int z) {
		for (Coord c : blockList) {
			if (c.equals(x, y, z)) {
				return true;
			}
		}
		return false;
	}

	private class Coord {

		public int x, y, z;

		public Coord(int xCor, int yCor, int zCor) {
			x = xCor;
			y = yCor;
			z = zCor;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Coord) {
				Coord c = (Coord) obj;
				if (c.x == x && c.y == y && c.z == z) {
					return true;
				}
			}
			return false;
		}

		public boolean equals(int xCor, int yCor, int zCor) {

            return xCor == x && yCor == y && zCor == z;
        }
	}

	public boolean check() {
		for (Coord c : blockList) {

			if (!(worldObj.getBlock(c.x, c.y, c.z) == block.Aufgabenblock)) {
				reset();
				//TODO make this work
				startreCalc();
				return check();
			}

			if (!((worldObj.getBlockMetadata(c.x, c.y, c.z) & 1) == 1)) {
                LogHelper.info("Aufgabenblock check was a Fail!");
				return false;
			}
		}
		LogHelper.info("Aufgabenblock check was a Success!");
		return true;
	}

	public void reset() {
		for (Coord c : blockList) {
			if (!c.equals(xCoord, yCoord, zCoord)) {
				TileEntity te = worldObj.getTileEntity(c.x, c.y, c.z);
				if (te instanceof TileEntityAufgabenblock) {
					TileEntityAufgabenblock tea = (TileEntityAufgabenblock) te;
					tea.blockList = new ArrayList<Coord>();
				}
			}
		}
		blockList = new ArrayList<Coord>();
	}

}
