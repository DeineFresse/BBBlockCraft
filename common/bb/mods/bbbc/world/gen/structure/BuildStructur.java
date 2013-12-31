package bb.mods.bbbc.world.gen.structure;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import bb.mods.bbbc.unrelated.structuren.Structuren;
import bb.mods.bbbc.world.lib.Reference;

public class BuildStructur {

	public static void BuildBrickHouse(World par1, int par2, int par3,
			int par4, EntityPlayer par5, int dir) {

		
		if (!Reference.DEBUGMODE) {
			build(par1, par2, par3, par4, par5,dir, Structuren.BrickHouse);
}
		if (dir > 5) {
			if (par1.isRemote) {
				par5.addChatMessage("You should google 2888 Donauverse by Michèle Métail");
			}
		}
	}

	private static void build(World par1, int par2, int par3, int par4,
			EntityPlayer par5,int dir, StructureBlock[] b) {

		 List<RotatedBlock> a = convert(b,dir);		 
		 
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