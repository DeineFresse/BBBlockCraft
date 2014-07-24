package bb.mods.bbbc.world.gen.structure;

import net.minecraft.block.Block;

public abstract class StructureBlock{

	protected int XCoord,YCoord,ZCoord,Meta;
	protected boolean Rotat;
	protected Block ID;
	public StructureBlock(int x, int y, int z, Block id2, int meta,boolean rotmeta) {
		XCoord = x;
		YCoord = y;
		ZCoord = z;
		ID = id2;
		Meta = meta;
		Rotat = rotmeta;
	}
	
	public abstract RotatedBlock[] getBlocks(int dir);
	
	protected static RotatedBlock getRotatedBlock(int x,int y,int z,Block id,int meta,int dir,boolean rotate){
		int[] Cord = rotate?rotXZByDir(x,y,z,meta,dir):rotXZByDir(x,y,z,dir);		
		return new RotatedBlock(Cord[0], Cord[1], Cord[2], id, Cord.length>3?Cord[3]:meta);
	
	}
	
	protected static final int[] rotXZByDir(int x, int y, int z,int dir) {
		if (dir == 0) {
			return new int[] { x, y, z };
		} else if (dir == 1) {
			return new int[] { -z, y, x };
		} else if (dir == 2) {
			return new int[] { -x, y, -z };
		} else {
			return new int[] { z, y, -x };
		}
	}
	
	protected final static int[] rotXZByDir(int x, int y, int z,int meta,int dir) {
		if (dir == 0) {
			return new int[] { x, y, z,};
		} else if (dir == 1) {
			return new int[] { -z, y, x,dreh1(meta)};
		} else if (dir == 2) {
			return new int[] { -x, y, -z, meta^1 };
		} else {
			return new int[] { z, y, -x ,dreh2(meta)};
		}
	}
	
	protected final static int dreh1(int meta){
		switch(meta&3){
		case 0:{return meta^2;}
		case 1:{return meta^2;}
		case 2:{return meta^3;}
		case 3:{return meta^3;}
		default :{return 0;}
		}
	}
	
	protected static final int dreh2(int meta){
		switch(meta&3){
		case 0:{return meta^3;}
		case 1:{return meta^3;}
		case 2:{return meta^2;}
		case 3:{return meta^2;}
		default:{return 0;}
		}
	}
	
	public final int getXCoord() {
		return XCoord;
	}

    public final int getYCoord() {
		return YCoord;
	}

    public final int getZCoord() {
		return ZCoord;
	}

    public final int getMeta() {
		return Meta;
	}

    public final Block getBlock() {
		return ID;
	}
}