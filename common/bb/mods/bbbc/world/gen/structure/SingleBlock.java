package bb.mods.bbbc.world.gen.structure;

public class SingleBlock extends StructureBlock{

	/**
	 * 
	 * @param rotmeta If calculating rotation should the meta be rotated like normal or be ignored 
	 * 
	 * 
	 * **/
	public SingleBlock(int x, int z, int y, int id, int meta,boolean rotmeta) {
		super(x, y, z, id, meta,rotmeta);
	};
		
	
	public RotatedBlock[] getBlocks(int dir) {
		int[] Cord = Rotat?rotXZByDir(XCoord,YCoord,ZCoord,Meta,dir):rotXZByDir(XCoord,YCoord,ZCoord,dir);		
		return new RotatedBlock[]{new RotatedBlock(Cord[0], Cord[1], Cord[2], ID, Cord.length>3?Cord[3]:Meta)};
	}
}
