package bb.mods.bbbc.world.gen.structure;

public class RotatedBlock {

	protected int XCoord,YCoord,ZCoord,ID,Meta;
	
	public RotatedBlock(int xCoord, int yCoord, int zCoord, int id, int meta) {
		XCoord = xCoord;
		YCoord = yCoord;
		ZCoord = zCoord;
		ID = id;
		Meta = meta;
	}
	
	public int getXCoord() {
		return XCoord;
	};

	public int getYCoord() {
		return YCoord;
	};
	
	public int getZCoord() {
		return ZCoord;
	};

	public int getMeta() {
		return Meta;
	};

	public int getID() {
		return ID;
	};
	
}
