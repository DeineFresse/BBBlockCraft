package bb.mods.bbbc.unrelated.structuren;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import bb.mods.bbbc.world.gen.structure.Doors;
import bb.mods.bbbc.world.gen.structure.RectangleFilled;
import bb.mods.bbbc.world.gen.structure.RectangleHollow;
import bb.mods.bbbc.world.gen.structure.SingleBlock;
import bb.mods.bbbc.world.gen.structure.StructureBlock;
import bb.mods.bbbc.world.gen.structure.Walls;

public class Structuren {

	public static final StructureBlock[] BrickHouse = brick_house();

	public static StructureBlock[] brick_house() {

		Block Brick = Blocks.brick_block;
		Block BrickStair = Blocks.brick_stairs;
		Block Air = Blocks.air;
		Block BookShelf = Blocks.bookshelf;
		Block doorWood = Blocks.wooden_door;
		Block obsidian = Blocks.obsidian;
		Block glowStone = Blocks.glowstone;
		Block entchantTable = Blocks.enchanting_table;
		Block BrickSlab = Blocks.stone_slab; // 44
		int SlabMeta = 4; // 4

		List<StructureBlock> sbl = new ArrayList<StructureBlock>();

		sbl.add(new RectangleHollow(-4, 0, 0, BrickStair, 2, true, 8, 8));
		sbl.add(new RectangleFilled(-3, 0, 1, Brick, 0, false, 7, 7));
		sbl.add(new Walls(-3, 1, 1, Brick, 0, false, 6, 6, 3));
		sbl.add(new Walls(-2, 1, 2, BookShelf, 0, false, 4, 4, 3));

		for (int i = 0; i < 4; i++) {
			sbl.add(new RectangleHollow(-4 + i, 3 + i, i, BrickStair, 2, true,
					8 - i * 2, 8 - i * 2));
		}

		sbl.add(new Doors(0, 1, 1, doorWood, 0));

		sbl.add(new SingleBlock(0, 1, 2, Air, 0, false));
		sbl.add(new SingleBlock(0, 2, 2, Air, 0, false));
		sbl.add(new SingleBlock(0, 7, 4, BrickSlab, SlabMeta, false));
		sbl.add(new SingleBlock(0, 1, 4, entchantTable, 0, false));
		sbl.add(new SingleBlock(1, 0, 4, glowStone, 0, false));
		sbl.add(new SingleBlock(-1, 0, 4, glowStone, 0, false));
		sbl.add(new SingleBlock(0, 0, 3, glowStone, 0, false));
		sbl.add(new SingleBlock(0, 0, 5, glowStone, 0, false));
		sbl.add(new SingleBlock(1, 0, 5, obsidian, 0, false));
		sbl.add(new SingleBlock(0, 0, 4, obsidian, 0, false));
		sbl.add(new SingleBlock(-1, 0, 3, obsidian, 0, false));
		sbl.add(new SingleBlock(-1, 0, 5, obsidian, 0, false));
		sbl.add(new SingleBlock(1, 0, 3, obsidian, 0, false));

		StructureBlock[] sba = new StructureBlock[sbl.size()];

		for (int i = 0; i < sba.length; i++) {
			sba[i] = sbl.get(i);
		}

		return sba;
	}

}
