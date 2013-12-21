package bb.mods.bbbc.world.gen.structure;

public class Doors extends SingleBlock {
	
	Doors(int x,int y,int z,int id,int dir){
		super(x,y,z,id,(dir+1)&3,true);
	}

	@Override
	public RotatedBlock[] getBlocks(int dir) {
		
		RotatedBlock[] rba = new RotatedBlock[2];
		
			System.out.println("Door");
			
		rba[0] = new SingleBlock(XCoord, YCoord, ZCoord, ID, Meta^dir, Rotat).getBlocks(dir)[0];
		rba[1] = new SingleBlock(XCoord, YCoord + 1, ZCoord, ID, Meta^8^dir, Rotat).getBlocks(dir)[0];			

		return rba;
	}

}
