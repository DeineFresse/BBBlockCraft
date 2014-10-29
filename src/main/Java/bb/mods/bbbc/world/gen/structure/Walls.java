package bb.mods.bbbc.world.gen.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;

public class Walls extends StructureBlock {

	private final int L;
    private final int W;
    private final int H;
	
	public Walls(int x,int y,int z,Block id,int meta,boolean rotmeta,int l,int w,int h){
		super(x,y,z,id,meta,rotmeta);
		L = l;
		W = w;
		H = h;
	}
	
	@Override
	public RotatedBlock[] getBlocks(int dir) {
		
		List<RotatedBlock> rl = new ArrayList<RotatedBlock>();
		
		for(int i = 0;i<H;i++){
			 RotatedBlock[] a =new RectangleHollow(XCoord,YCoord+i,ZCoord,ID,Meta,Rotat,L,W).getBlocks(dir);
            rl.addAll(Arrays.asList(a));
		}
		
		RotatedBlock[] ra = new RotatedBlock[rl.size()];
		
		for(int i = 0;i<rl.size();i++){			
			ra[i] = rl.get(i);
		}
		
		return ra;
	}
}
