package bb.mods.bbbc.world.gen.structure;

public class Doors extends SingleBlock {

	private int XCoord,YCoord,ZCoord,ID,Meta;
	
	Doors(int x,int y,int z,int id,int dir){
		super(x,y,z,id,(dir+1)&3,true);
	}

	@Override
	public RotatedBlock[] getBlocks(int dir) {
		
		RotatedBlock[] rba = new RotatedBlock[2];
		if (ID == 64 || ID == 71) {

			System.out.println("Door");
			
		rba[0] = new SingleBlock(XCoord, YCoord, ZCoord, ID, Meta, Rotat).getBlocks(dir)[0];
		rba[1] = new SingleBlock(XCoord, YCoord + 1, ZCoord, ID, Meta ^ 8, Rotat).getBlocks(dir)[0];			

		}
		return rba;
	}

}
