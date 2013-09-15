package bb.mods.bbbc.block;

import bb.mods.bbbc.itemblock.BigBlockItem;
import bb.mods.bbbc.itemblock.CloudWhiteItem;
import bb.mods.bbbc.lib.Block_Names;
import bb.mods.bbbc.lib.LoadedIDs;
import net.minecraft.block.Block;
import net.minecraft.src.ModLoader;

public class block {

    // Block Definitions
    public static Block BlockOreOne;
    public static Block TestBlock;
    public static Block cloudore;
    public static Block CloudWhite;
    public static Block Dark_Stone;
    public static Block Faceblock;
    public static Block BigBlock;

 public static void signBlockID(){
    BlockOreOne = new BlockOreOne(LoadedIDs.Block_BlockOreOne);
    TestBlock = new TestBlock(LoadedIDs.Block_TestBlock);
    cloudore = new cloudore(LoadedIDs.Block_cloudore);
    CloudWhite = new CloudWhite(LoadedIDs.Block_CloudWhite);
    Dark_Stone = new Dark_Stone(LoadedIDs.Block_Dark_Stone);
    Faceblock = new Faceblock(LoadedIDs.Block_Faceblock);
    BigBlock = new BigBlock(LoadedIDs.Block_BigBlock);
    }	
 public static void Blockreg(){
		
		// Register Blocks
		
				ModLoader.registerBlock(BlockOreOne);
				ModLoader.registerBlock(Dark_Stone);
				ModLoader.registerBlock(TestBlock);
				ModLoader.registerBlock(cloudore);
				ModLoader.registerBlock(CloudWhite,CloudWhiteItem.class);
				ModLoader.registerBlock(Faceblock);
				ModLoader.registerBlock(BigBlock,BigBlockItem.class);
		
	}
 
 public static void Blockname(){
     ModLoader.addName(BlockOreOne, Block_Names.BLOCKOREONE);
     ModLoader.addName(TestBlock,Block_Names.TESTBLOCK);
     ModLoader.addName(cloudore,Block_Names.CLOUDORE);
     ModLoader.addName(CloudWhite, Block_Names.CLOUDWHITE);
     ModLoader.addName(Dark_Stone, Block_Names.DARKSTONE);
 }
 
}
