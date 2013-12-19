package bb.mods.bbbc.world.gen.structure;

public class RectangleHollow extends SingleBlock {

	private int L,W;
	
	RectangleHollow(int x,int y,int z,int id,int meta,boolean rotmeta,int l,int w){
		super(x,y,z,id,meta,rotmeta);
		L = l;
		W = w;
	}
	
	@Override
	public StructureBlock[] getBlocks(int dir) {
		SingleBlock[] a = new SingleBlock[2 * (L + W)];
		int m = 0;
		for (int i = 0; i < L; i++, m++) {
				a[m] = new SingleBlock(XCoord + i, YCoord,ZCoord, ID, isStair(ID)?Meta|2:Meta,Rotat);
				a[m] = new SingleBlock(XCoord + i, YCoord,ZCoord + W, ID, isStair(ID)?Meta|3:Meta,Rotat);		
		}
		for (int i = 0; i <W; i++, m++) {
				a[m] = new SingleBlock(XCoord, YCoord,ZCoord+i, ID,Meta,Rotat);
				a[m] = new SingleBlock(XCoord + L, YCoord,ZCoord + i, ID,isStair(ID)?Meta|1:Meta,Rotat);
		}
		return a;
	}
	
	private static boolean isStair(int id){
		int[] s = new int[]{53,67,108,109,114,128,134,135,136,156};
		for(int i = 0;i<s.length;i++){
			if(id == s[i]){
				return true;
			}
		}
		return false;
	}

}
