package bb.mods.bbbc.unrelated.tileentity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileEntityRenderTest extends TileEntity {

	public List<Fishes> fishA = new ArrayList<Fishes>();
	public byte sides = 0;
	public int pass =-1;

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
	
	public void addfish(){
		fishA.add(new Fishes());
	}

	@Override
	public boolean shouldRenderInPass(int pass) {
		this.pass = pass;
		return true;
	}

	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);
		
		sides = par1.getByte("sides");

		NBTTagList fish = par1.getTagList("fishes",Constants.NBT.TAG_COMPOUND);

		for (int i = 0; i < fish.tagCount(); i++) {
			fishA.add(Fishes.fishesFromNBTTagCompound(fish.getCompoundTagAt(i)));
		}

	}

	
}
