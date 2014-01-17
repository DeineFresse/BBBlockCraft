package bb.mods.bbbc.unrelated.tileentity;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;

public class Fishes {

		public float xCoord, yCoord, zCoord;
		public float xMove, yMove, zMove;
		public float size;
		
		public Fishes() {
			Random r = new Random();
			xCoord = r.nextFloat()-0.5F;
			yCoord = r.nextFloat();
			zCoord = r.nextFloat()-0.5F;
			xMove = r.nextFloat()/200;
			yMove = r.nextFloat()/200;
			zMove = r.nextFloat()/200;
			size = r.nextFloat();
			if(size<0.1F){
				size = 0.1F;
			}
		}

		public Fishes(float x, float y, float z, float xm, float ym, float zm,float s) {
			xCoord = x;
			yCoord = y;
			zCoord = z;
			xMove = xm;
			yMove = ym;
			zMove = zm;
			size = s;
		}

		public static Fishes fishesFromNBTTagCompound(NBTTagCompound nbttag) {
			return new Fishes(nbttag.getFloat("xCoord"),
					nbttag.getFloat("yCoord"), nbttag.getFloat("zCoord"),
					nbttag.getFloat("xMove"), nbttag.getFloat("yMove"),
					nbttag.getFloat("zMove"),0.75F);
		}
		
		public void moveFish(){
			
			if(xCoord<=-0.5||xCoord>=0.5){
				xMove=-xMove;
			}
			if(yCoord<=0||yCoord>=1){
				yMove=-yMove;
			}
			if(zCoord<=-0.5||zCoord>=0.5){
				zMove=-zMove;
			}
			
			xCoord+=xMove;
			yCoord+=yMove;
			zCoord+=zMove;
			
			if(0.5F>size){
				size+=0.000001F;
			}
			if(0.5F<size){
				size = 0.5F;
			}
			
		}
		

}
