package bb.mods.bbbc.world.gen.structure;

public class SingleBlock extends StructureBlock{


	public SingleBlock(int x, int y, int z, int id, int meta,boolean rotmeta) {
		super(x, y, z, id, meta,rotmeta);
	};
		
	
	public RotatedBlock[] getBlocks(int dir) {

		System.out.println("SB");
		int[] Cord = Rotat?rotXZByDir(XCoord,YCoord,ZCoord,Meta,dir):rotXZByDir(XCoord,YCoord,ZCoord,dir);		
		return new RotatedBlock[]{new RotatedBlock(Cord[0], Cord[1], Cord[2], ID, Cord.length>3?Cord[3]:Meta)};
	}
}
