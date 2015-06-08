package bb.mods.bbbc.unrelated.tileentity;

import net.minecraft.nbt.NBTTagCompound;

import java.util.Random;

public class Fishes {

		public float xCoord, yCoord, zCoord;
		public float xMove, yMove, zMove;
		public float size;

		public static final double xMax = 0.4d,xMin = -0.4d,yMax= 0.8d,yMin=0.150d,zMin=0.125d,zMax=1.125d;
		
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
				size = 0.5F;
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

			if(xCoord>xMax||xCoord<xMin){
				xCoord = (float)(xMax+xMin)/2;
			}
			if(yCoord>yMax||yCoord<yMin){
				yCoord = (float)(yMax+yMin)/2;
			}
			if(zCoord>yMax||zCoord<yMin){
				zCoord = (float)(zMax+zMin)/2;
			}
		}

		public static Fishes fishesFromNBTTagCompound(NBTTagCompound nbttag) {
			return new Fishes(nbttag.getFloat("xCoord"),
					nbttag.getFloat("yCoord"), nbttag.getFloat("zCoord"),
					nbttag.getFloat("xMove"), nbttag.getFloat("yMove"),
					nbttag.getFloat("zMove"),nbttag.getFloat("size"));
		}
		
		public void moveFish(){

			
			xCoord+=xMove;
			yCoord+=yMove;
			zCoord+=zMove;

			if(xCoord<xMin||xCoord>xMax){
				xMove=-xMove;
			}
			if(yCoord<yMin||yCoord>yMax){
				yMove=-yMove;
			}
			if(zCoord<zMin||zCoord>zMax){
				zMove=-zMove;
			}

			xCoord = xCoord>xMax?(float)xMax:xCoord<xMin?(float)xMin:xCoord;
			yCoord = yCoord>yMax?(float)yMax:yCoord<yMin?(float)yMin:yCoord;
			zCoord = zCoord>zMax?(float)zMax:zCoord<zMin?(float)zMin:zCoord;
			
			if(1.5F>size){
				size+=0.0025F;
			}
			if(1.5F<size){
				size = 1.5F;
			}
			
		}
		

}
