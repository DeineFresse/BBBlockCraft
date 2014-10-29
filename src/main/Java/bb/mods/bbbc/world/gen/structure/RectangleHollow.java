package bb.mods.bbbc.world.gen.structure;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class RectangleHollow extends SingleBlock {

	private final int L;
    private final int W;

	public RectangleHollow(int x, int y, int z, Block id, int meta,
			boolean rotmeta, int l, int w) {
		super(x, y, z, id, meta, rotmeta);
		if (isStair(ID)) {
			Meta = 0;
		}
		L = l;
		W = w;
	}

	@Override
	public RotatedBlock[] getBlocks(int dir) {

		List<RotatedBlock> sbl = new ArrayList<RotatedBlock>();
		for (int i = 0; i <= L; i++) {

			sbl.add(getRotatedBlock(XCoord + i, YCoord, ZCoord, ID,
					isStair(ID) ? dreh1(Meta) : Meta, dir, Rotat));
			sbl.add(getRotatedBlock(XCoord + i, YCoord, ZCoord + W, ID,
					isStair(ID) ? dreh2(Meta) : Meta, dir, Rotat));

		}
		for (int i = 0; i <= W; i++) {

			sbl.add(getRotatedBlock(XCoord, YCoord, ZCoord + i, ID, Meta, dir,
					Rotat));
			sbl.add(getRotatedBlock(XCoord + L, YCoord, ZCoord + i, ID,
					isStair(ID) ? Meta^1 : Meta, dir, Rotat));
		}

		RotatedBlock[] rba = new RotatedBlock[sbl.size()];

		for (int i = 0; i < rba.length; i++) {
			rba[i] = sbl.get(i);
		}

		return rba;
	}

	private static boolean isStair(Block id) {
		Block[] s = new Block[] { Blocks.oak_stairs, Blocks.spruce_stairs,
				Blocks.birch_stairs, Blocks.jungle_stairs,
				Blocks.dark_oak_stairs, Blocks.acacia_stairs,Blocks.brick_stairs };
        for (Block value : s) {
            if (id == value) {
                return true;
            }
        }
		return false;
	}

}
