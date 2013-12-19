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
	
	public final int getXCoord() {
		return XCoord;
	};

	public final int getYCoord() {
		return YCoord;
	};
	
	public final int getZCoord() {
		return ZCoord;
	};

	public final int getMeta() {
		return Meta;
	};

	public final int getID() {
		return ID;
	};
	
}
