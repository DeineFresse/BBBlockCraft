package bb.mods.bbbc.world.gen.structure;

import java.util.ArrayList;
import java.util.List;

public class RectangleFilled extends SingleBlock {

	private int L,W;
	
	public RectangleFilled(int x,int y,int z,int id,int meta,boolean rotate,int l,int w){
		super(x,y,z,id,meta,rotate);
		Meta = meta;
		L = l;
		W = w;
	}

	@Override
	public RotatedBlock[] getBlocks(int dir) {
		List<RotatedBlock> a = new ArrayList<RotatedBlock>();
		for (int i = 0; i < L; i++) {
			for (int ii = 0; ii < W; ii++) {
					a.add(getRotatedBlock(XCoord + i, YCoord,	ZCoord + ii, ID, Meta,dir,Rotat));
			}
		}
		
		RotatedBlock[] r = new RotatedBlock[a.size()];

		for(int i = 0;i<a.size();i++){
			r[i] = a.get(i);
		}
		
		return r;
	}

}
