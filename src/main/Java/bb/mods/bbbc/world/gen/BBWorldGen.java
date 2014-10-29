package bb.mods.bbbc.world.gen;

import bb.mods.bbbc.core.util.LogHelper;
import bb.mods.bbbc.world.block.block;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class BBWorldGen implements IWorldGenerator {

	/** Generates Ore in a specific pattern
     *
     * @param  only if true only the listed bioms else not the listed Bioms
     *
     * */
	public void generateit(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider,
			Block ID, Block target, String[] bioms, boolean only, int tries) {

		boolean nosucsess;
		int trieCount = 0;
		BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
		int yRandom;
		int zRandom;
		int xRandom;

		if (isBiom(bioms, b.biomeName) == only) {
			do {
				zRandom = random.nextInt(16);
				xRandom = random.nextInt(16);

				int S1 = world.getTopSolidOrLiquidBlock(xRandom + chunkX * 16,
						zRandom + chunkZ * 16);

				if (S1 > 19) {
					yRandom = random.nextInt(S1 - 19);
				} else {
					yRandom = 2;
				}

				int x = chunkX * 16 + xRandom;
				int y = yRandom;
				int z = chunkZ * 16 + zRandom;

				if (world.getBlock(x, y, z).isReplaceableOreGen(world, x, y, z,
						target)
						&& world.getBlock(x, y - 1, z).isReplaceableOreGen(
								world, x, y - 1, z, target)
						&& world.getBlock(x + 1, y, z).isReplaceableOreGen(
								world, x, y, z, target)
						&& world.getBlock(x + 1, y - 1, z).isReplaceableOreGen(
								world, x, y, z, target)) {

					world.setBlock(x, y, z, ID);
					world.setBlock(x, y - 1, z, ID);
					world.setBlock(x + 1, y, z, ID);
					world.setBlock(x + 1, y - 1, z, ID);
					nosucsess = false;
                    LogHelper.debug("Generated "+ID.getLocalizedName()+" at "+ " X: " + x + " Y: " + y + " Z: "+ z);
				} else {
					nosucsess = true;
					trieCount++;
                    LogHelper.debug("Had no sucess,try :"+ trieCount+"/"+tries);
				}

			} while (nosucsess && trieCount < tries);

		}
	}

	private boolean isBiom(String[] bioms, String biomeName) {
		for (String biom : bioms) {
			if (biom.equals(biomeName)) {
				return true;
			}
		}
		return false;
	}

	/** Uses the Function above for every Ore Type */
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		generateit(random, chunkX, chunkZ, world, chunkGenerator,
				chunkProvider, block.BlockOreOne, Blocks.stone,
				new String[] { "Hell" }, false, 10);
		generateit(random, chunkX, chunkZ, world, chunkGenerator,
				chunkProvider, block.cloudore, Blocks.stone,
				new String[] { "Hell" }, false, 10);

        generateit(random,chunkX,chunkZ,world,chunkGenerator,chunkProvider,Blocks.netherrack,Blocks.netherrack,new String[]{"Hell"},true,5);

	}

}
