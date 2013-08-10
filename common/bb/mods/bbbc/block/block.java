package bb.mods.bbbc.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;

public class block {

    // Block Definitions
    public static Block BlockOreOne;
    public static Block TestBlock;
    public static Block cloudore;
    public static Block CloudWhite;

 public static void signBlockID(){
    BlockOreOne = new BlockOreOne(160);
    TestBlock = new TestBlock(161);
    cloudore = new cloudore(162);
    CloudWhite = new CloudWhite(163);
    }	
 public static void Blockreg(){
		
		// Register Blocks
		
				ModLoader.registerBlock(BlockOreOne);
				ModLoader.registerBlock(TestBlock);
				ModLoader.registerBlock(cloudore);
				ModLoader.registerBlock(CloudWhite);
		
	}
 
 public static void Blockname(){
    
     ModLoader.addName(block.BlockOreOne, "My First Ore");
     ModLoader.addName(block.TestBlock,"The Constructor");
     ModLoader.addName(block.cloudore,"The Cloud Ore");
     ModLoader.addName(new ItemStack(block.CloudWhite,1,0), "Cloud in White");
 }
 
}
