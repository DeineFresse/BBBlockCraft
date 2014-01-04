package bb.mods.bbbc.unrelated.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRenderTest extends TileEntity{
	
	public int x=0,y=250,z=0,mX=10,mY=50,mZ=125;
	
		
	public void writeToNBT(NBTTagCompound par1){
		super.writeToNBT(par1);
		par1.setInteger("xPos",x);
		par1.setInteger("yPos",y);
		par1.setInteger("zPos",z);

		par1.setInteger("xMov",mX);
		par1.setInteger("yMov",mY);
		par1.setInteger("zMov",mZ);
		
	}
	
	public void readFromNBT(NBTTagCompound par1){
		super.readFromNBT(par1);
		
		x = par1.getInteger("xPos");
		y = par1.getInteger("yPos");
		z = par1.getInteger("zPos");
             
		mX = par1.getInteger("xMov");
		mY = par1.getInteger("yMov");
		mZ = par1.getInteger("zMov");
		
	}

	public void move() {
		
		if(x>250||x<=-250){
			mX=-mX;
		}
		if(y>500||y<=0){
			mY=-mY;
		}
		if(z>=250||z<=-250){
			mZ=-mZ;
		}
		x+=mX;
		y+=mY;
		z+=mZ;
	}

}
