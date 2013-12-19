package bb.mods.bbbc.world.gen.structure;

public class Walls extends SingleBlock {

	private int L,W,H;
	
	Walls(int x,int y,int z,int id,int meta,boolean rotmeta,int l,int w,int h){
		super(x,y,z,id,meta,rotmeta);
		L = l;
		W = w;
		H = h;
	}
	Walls(int x,int y,int z,int id,int l,int w,int h){
		super(x,y,z,id,0,false);
		L = l;
		W = w;
		H = h;
	}
	
	

	@Override
	public StructureBlock[] getBlocks(int dir) {
		StructureBlock[][] a = new StructureBlock[H][2*L+2*W];
		StructureBlock[] b = new StructureBlock[H*(2*L+2*W)];
		int e = 0;
		for(int i = 0;i<H;i++){
			a[i] = new RectangleHollow(XCoord,YCoord,ZCoord,ID,Meta,Rotat,L,W).getBlocks(dir);
		}
		for(int i = 0;i<a.length;i++,e++){
			for(int ii = 0;ii<a[i].length;ii++,e++){
				b[e]  = a[i][ii];
			}
		}
		
		return b;
	}
}
