package bb.mods.bbbc.world.gen.structure;

public abstract class StructureBlock extends RotatedBlock{

	protected boolean Rotat;

	public StructureBlock(int x, int y, int z, int id, int meta,boolean rotmeta) {
		super(x, y, z, id, meta);
		Rotat = rotmeta;
	}

	
	
	public abstract RotatedBlock[] getBlocks(int dir);

	protected final int[] rotXZByDir(int x, int y, int z, int dir) {
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
	
	protected final int[] rotXZByDir(int x, int y, int z,int meta,int dir) {
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
}
