package bb.mods.bbbc.world.gen.structure;

public class Doors extends SingleBlock {

	private int XCoord,YCoord,ZCoord,ID,Meta;
	
	Doors(int x,int y,int z,int id,int dir){
		super(x,y,z,id,(dir+1)&3,true);
	}

	@Override
	public StructureBlock[] getBlocks(int dir) {
		StructureBlock[] a = new StructureBlock[2];
		if (ID == 64 || ID == 71) {
		a[0] = new SingleBlock(XCoord, YCoord, ZCoord, ID, Meta, Rotat);
		a[1] = new SingleBlock(XCoord, YCoord + 1, ZCoord, ID, Meta ^ 8, Rotat);			

		}
		return a;
	}

}
