package bb.mods.bbbc.world.gen.structure;

public class RectangleFilled extends SingleBlock {

	private int L,W;
	
	RectangleFilled(int x,int y,int z,int id,int meta,boolean rotate,int l,int w){
		super(x,y,z,id,meta,rotate);
		Meta = meta;
		L = l;
		W = w;
	}

	@Override
	public RotatedBlock[] getBlocks(int dir) {
		RotatedBlock[] a = new RotatedBlock[L * W];
		int m = 0;
		for (int i = 0; i < L; i++, m++) {
			for (int ii = 0; ii < W; ii++, m++) {			
					a[m] = new RotatedBlock(XCoord + i, YCoord,
							ZCoord + ii, ID, Meta);
			}
		}

		return a;
	}

}
