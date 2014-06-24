package bb.mods.bbbc.world.gen.structure;

import net.minecraft.block.Block;

public class SingleBlock extends StructureBlock {

	public SingleBlock(int x, int y, int z,Block id, int meta, boolean rotmeta) {
		super(x, y, z, id, meta, rotmeta);
	};

	public RotatedBlock[] getBlocks(int dir) {
		return new RotatedBlock[] { getRotatedBlock(XCoord, YCoord, ZCoord, ID,
				Meta, dir, Rotat) };
	}
}
