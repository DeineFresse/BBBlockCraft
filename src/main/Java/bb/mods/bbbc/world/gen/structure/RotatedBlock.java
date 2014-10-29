package bb.mods.bbbc.world.gen.structure;

import net.minecraft.block.Block;

public class RotatedBlock {

	protected final int XCoord;
    protected final int YCoord;
    protected final int ZCoord;
    protected final int Meta;
	protected final Block ID;
	
	public RotatedBlock(int xCoord, int yCoord, int zCoord, Block id, int meta) {
		XCoord = xCoord;
		YCoord = yCoord;
		ZCoord = zCoord;
		ID = id;
		Meta = meta;
	}
	
	public final int getXCoord() {
		return XCoord;
	}

    public final int getYCoord() {
		return YCoord;
	}

    public final int getZCoord() {
		return ZCoord;
	}

    public final int getMeta() {
		return Meta;
	}

    public final Block getBlock() {
		return ID;
	}

}
