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
    //TODO Find out how to add names
     ModLoader.addName(BlockOreOne, "My First Ore");
     ModLoader.addName(TestBlock,"The Constructor");
     ModLoader.addName(cloudore,"The Cloud Ore");
     ModLoader.addName(CloudWhite, "Cloud");
 }
 
}
