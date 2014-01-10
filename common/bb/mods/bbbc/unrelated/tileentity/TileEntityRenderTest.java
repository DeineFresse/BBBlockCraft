package bb.mods.bbbc.unrelated.tileentity;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRenderTest extends TileEntity {

	public List<Fishes> fishA = new ArrayList<Fishes>();
	public byte sides = 0;
	
	
	public TileEntityRenderTest() {
		}

	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		
		par1.setByte("sides", sides);
		
		NBTTagList fishes = new NBTTagList();
		for (int i = 0; i < fishA.size(); i++) {

			if (fishA.get(i) != null) {
				NBTTagCompound b = new NBTTagCompound();
				b.setFloat("xCoord", fishA.get(i).xCoord);
				b.setFloat("yCoord", fishA.get(i).yCoord);
				b.setFloat("zCoord", fishA.get(i).zCoord);
				b.setFloat("xMove", fishA.get(i).xMove);
				b.setFloat("yMove", fishA.get(i).yMove);
				b.setFloat("zMove", fishA.get(i).zMove);

				fishes.appendTag(b);
			}

		}

		par1.setTag("fishes", fishes);

	}
	
	public void addfish(){
		fishA.add(new Fishes());
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new Packet132TileEntityData(xCoord, yCoord, zCoord, 1, nbtTag);

	}

	@Override
	public boolean shouldRenderInPass(int pass) {
		return true;
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
		readFromNBT(packet.data);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);
		
		sides = par1.getByte("sides");

		NBTTagList fish = par1.getTagList("fishes");

		for (int i = 0; i < fish.tagCount(); i++) {
			fishA.add(Fishes.fishesFromNBTTagCompound((NBTTagCompound)fish.tagAt(i)));
		}

	}

}
