package bb.mods.bbbc.world.gen.structure.basic;

import net.minecraft.world.World;

public class Forms {
    
	public static void rectangle(World par1, int x, int y, int z, int lang,
			int breit, int Block) {

		if (Block != 53 && Block != 67 && Block != 108 && Block != 109
				&& Block != 114 && Block != 128 && Block != 134 && Block != 135
				&& Block != 136 && Block != 156) {
			for (int i = 0; i < lang; i++) {
				par1.setBlock(x+i, y, z, Block);
				par1.setBlock(x+i, y, z+breit-1, Block);
			}
			for (int i = 0;i<breit;i++){
				par1.setBlock(x, y, z+i, Block);
				par1.setBlock(x+lang-1, y, z+i, Block);
			}
		}
		else {
			for (int i = 0; i < lang; i++) {
				par1.setBlock(x+i, y, z, Block,2,0x01);
				par1.setBlock(x+i, y, z+breit-1, Block,3,0x01);
			}
			for (int i = 0;i<breit;i++){
				par1.setBlock(x, y, z+i, Block,0,0x01);
				par1.setBlock(x+lang-1, y, z+i, Block,1,0x01);
			}
			 
			
		}

	}
	
}
