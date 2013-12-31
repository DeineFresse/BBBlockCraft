package bb.mods.bbbc.world.gen;

import java.util.Random;

import bb.mods.bbbc.world.lib.LoadedIDs;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class BBWorldGen implements IWorldGenerator {

	/** Checks if Block is allowed to be replaced */
	public boolean isitright(int ID) {
		if (ID == Block.dirt.blockID || ID == Block.stone.blockID
				|| ID == Block.gravel.blockID) {
			return true;
		} else {
			return false;
		}
	}

	/** Generates Ore in a specific pattern */
	public void generateit(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider, int ID) {

		boolean nosucsess = true;
		int tries = 0;
		BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
		int Y;
		int Z;
		int X;

		if (b.biomeName != "Hell") {
			do {
				Z = random.nextInt(16);
				X = random.nextInt(16);

				int S1 = world.getTopSolidOrLiquidBlock(X, Z);

				if (S1 > 19) {
					Y = random.nextInt(S1 - 19);
				} else {
					Y = 2;
				}

				int A = chunkX * 16 + X;
				int B = Y;
				int C = chunkZ * 16 + Z;

				if (isitright(world.getBlockId(A, B, C))
						&& isitright(world.getBlockId(A, B - 1, C))
						&& isitright(world.getBlockId(A + 1, B, C))
						&& isitright(world.getBlockId(A + 1, B - 1, C))) {

					world.setBlock(chunkX * 16 + X, Y, chunkZ * 16 + Z, ID);
					world.setBlock(chunkX * 16 + X, Y - 1, chunkZ * 16 + Z, ID);
					world.setBlock(chunkX * 16 + 1 + X, Y, chunkZ * 16 + Z, ID);
					world.setBlock(chunkX * 16 + 1 + X, Y - 1, chunkZ * 16 + Z,
							ID);
					nosucsess = false;
					System.out.println(ID + " X: " + A + " Y: " + B + " Z: "
							+ C);
				} else {
					nosucsess = true;
					tries++;
					System.out
							.println("Had no sucess,try again!Tried:" + tries);
				}

			} while (nosucsess && tries < 10);

		}
	}

	/** Uses the Function above for every Ore Type */
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		generateit(random, chunkX, chunkZ, world, chunkGenerator,
				chunkProvider, LoadedIDs.Block_BlockOreOne);
		generateit(random, chunkX, chunkZ, world, chunkGenerator,
				chunkProvider, LoadedIDs.Block_cloudore);

	}

}
