package bb.mods.bbbc.world.gen.structure;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import bb.mods.bbbc.lib.Reference;

public class BrickHouse {

	static int[] BrickHouse = new int[] { 45, 108, 0, 47, 64, 71, 49, 89, 116,
			44, 4 };
	static int Brick = 45; // 45
	static int BrickStair = 108; // 108
	static int Air = 0;
	static int BookShelf = 47; // 47
	static int doorWood = 64; // 64
	static int doorIron = 71; // 71
	static int obsidian = 49; // 49
	static int glowStone = 89; // 89
	static int entchantTable = 116; // 116
	static int BrickSlab = 44; // 44
	static int SlabMeta = 4; // 4

	static int[] Material;

	public static void BuildBrickHouse(World par1, int par2, int par3,
			int par4, EntityPlayer par5, int f, int ID) {

		Material = BrickHouse;
		if (!Reference.DEBUGMODE) {
			brick_house(par1, par2, par3, par4, par5, f);
		}
		if (f > 5) {
			if (par1.isRemote) {
				par5.addChatMessage("You should google 2888 Donauverse by Michèle Métail");
			}
		}
	}

	public static void brick_house(World par1, int par2, int par3, int par4,
			EntityPlayer par5, int f) {

		List<StructureBlock> sbl = new ArrayList<StructureBlock>();

		sbl.add(new RectangleHollow(-4, 0, 0, BrickStair, 0, true, 8, 8));
		sbl.add(new RectangleFilled(-3, 0, 1, Brick, 0, false, 7, 7));
		sbl.add(new Walls(-3, 1, 1, Brick, 0, false, 6, 6, 3));
		sbl.add(new Walls(-2, 1, 2, BookShelf, 0, false, 4, 4, 3));

		for (int i = 0; i < 4; i++) {
			sbl.add(new RectangleHollow(-4 + i, 3 + i, i, BrickStair, 0, true,
					8 - i * 2, 8 - i * 2));
		}

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
		sbl.add(new Doors(0, 1, 1, doorWood, 0));

		List<RotatedBlock> a = new ArrayList<RotatedBlock>();
		StructureBlock[] sba = new StructureBlock[sbl.size()];
		for (int i = 0; i < sba.length; i++) {
			sba[i] = sbl.get(i);
		}

		a.addAll(convert(sba, f));

		build2(par1, par2, par3, par4, par5, a);

	}

	private static void build2(World par1, int par2, int par3, int par4,
			EntityPlayer par5, List<RotatedBlock> a) {

		System.out.println(a.size());

		for (int i = 0; i < a.size(); i++) {

			if (a != null && a.get(i) != null) {
				int x, y, z, id, meta;
				x = par2 + a.get(i).getXCoord();
				y = par3 + a.get(i).getYCoord();
				z = par4 + a.get(i).getZCoord();
				id = a.get(i).getID();
				meta = a.get(i).getMeta();
				par1.setBlock(x, y, z, id, meta, 7);
			}

		}

		System.out.println("build2 Ende");
	}

	public static List<RotatedBlock> convert(StructureBlock[] structureBlocks,
			int dir) {

		RotatedBlock[] t;
		List<RotatedBlock> a = new ArrayList<RotatedBlock>();

		for (int i = 0; i < structureBlocks.length; i++) {
			t = structureBlocks[i].getBlocks(dir);
			for (int ii = 0; ii < t.length; ii++) {
				a.add(t[ii]);
			}
		}
		return a;
	}
}