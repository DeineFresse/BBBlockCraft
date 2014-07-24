package bb.mods.bbbc.world.gen.structure;

import net.minecraft.block.Block;

public class Doors extends SingleBlock {
	
	public Doors(int x,int y,int z,Block id,int dir){
		super(x,y,z,id,(dir+1)&3,true);
	}

	@Override
	public RotatedBlock[] getBlocks(int dir) {
		
		RotatedBlock[] rba = new RotatedBlock[2];
			
		rba[0] = getRotatedBlock(XCoord, YCoord, ZCoord, ID, Meta^dir,dir, Rotat);
		rba[1] = getRotatedBlock(XCoord, YCoord + 1, ZCoord, ID, Meta^8^dir,dir, Rotat);			

		return rba;
	}

}
