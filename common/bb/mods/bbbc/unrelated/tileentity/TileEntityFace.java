package bb.mods.bbbc.unrelated.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFace extends TileEntity {

	public int primary_x;
	public int primary_y;
	public int primary_z;
	public int dir;
	public int position;
	
	public void writeToNBT(NBTTagCompound par1) {

		super.writeToNBT(par1);
		par1.setInteger("px", primary_x);
		par1.setInteger("py", primary_y);
		par1.setInteger("pz", primary_z);
		par1.setInteger("dir", dir);
		par1.setInteger("ps", position);

	}

	public void readFromNBT(NBTTagCompound par1) {

		super.readFromNBT(par1);
		this.primary_x = par1.getInteger("px");
		this.primary_y = par1.getInteger("py");
		this.primary_z = par1.getInteger("pz");
		this.dir = par1.getInteger("dir");
		this.position = par1.getInteger("ps");

	}
}
