package bb.mods.bbbc.world.gen.structure;

public class Doors extends SingleBlock {

	private int XCoord,YCoord,ZCoord,ID,Meta;
	
	Doors(int x,int y,int z,int id,int dir){
		super(x,y,z,id,(dir+1)&3,true);
		XCoord = x;
		YCoord = y;
		ZCoord = z;
		ID = id;
		Meta = (dir+1)&3;
	}
	
	@Override
	public int getXCoord() {
		return XCoord;
	}

	@Override
	public int getYCoord() {
		return YCoord;
	}

	@Override
	public int getZCoord() {
		return ZCoord;
	}

	@Override
	public StructureBlock[] getBlocks(int dir) {
		StructureBlock[] a = new StructureBlock[2];
		if (ID == 64 || ID == 71) {
		a[0] = new StructureBlock(XCoord, YCoord, ZCoord, ID, Meta);
		a[1] = new StructureBlock(XCoord, YCoord + 1, ZCoord, ID, Meta ^ 8);			

		}
		return a;
	}

	@Override
	public int getID() {
		return ID;
	}

	@Override
	public int getMeta() {
		return Meta;
	}

}
