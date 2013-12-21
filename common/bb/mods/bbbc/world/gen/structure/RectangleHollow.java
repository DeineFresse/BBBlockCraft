package bb.mods.bbbc.world.gen.structure;

import java.util.ArrayList;
import java.util.List;

public class RectangleHollow extends SingleBlock {

	private int L, W;

	RectangleHollow(int x, int y, int z, int id, int meta, boolean rotmeta,
			int l, int w) {
		super(x, y, z, id, meta, rotmeta);
		if (isStair(ID)){
			Meta = 0;
			}
		L = l;
		W = w;
	}

	@Override
	public RotatedBlock[] getBlocks(int dir) {
		
		List<RotatedBlock>sbl = new ArrayList<RotatedBlock>();
		for (int i = 0; i <= L; i++) {

			sbl.add(new SingleBlock(XCoord + i, YCoord, ZCoord, ID,isStair(ID) ? Meta | 2 : Meta, Rotat).getBlocks(dir)[0]);
			sbl.add(new SingleBlock(XCoord + i, YCoord, ZCoord + W, ID,isStair(ID) ? Meta | 3 : Meta, Rotat).getBlocks(dir)[0]);
		}
		for (int i = 0; i <= W; i++) {

			System.out.println("RH");
			sbl.add(new SingleBlock(XCoord, YCoord, ZCoord + i, ID, Meta, Rotat).getBlocks(dir)[0]);
			sbl.add(new SingleBlock(XCoord + L, YCoord, ZCoord + i, ID,isStair(ID) ? Meta | 1 : Meta, Rotat).getBlocks(dir)[0]);
		}
		
		
		RotatedBlock[] rba = new RotatedBlock[sbl.size()];
		
		for(int i = 0;i<rba.length;i++){
			rba[i] = sbl.get(i);
		}
		
		return rba;
	}

	private static boolean isStair(int id) {
		int[] s = new int[] { 53, 67, 108, 109, 114, 128, 134, 135, 136, 156 };
		for (int i = 0; i < s.length; i++) {		
			if (id == s[i]) {
				return true;
			}
		}
		return false;
	}

}