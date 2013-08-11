package bb.mods.bbbc;

import bb.mods.bbbc.block.block;
import bb.mods.bbbc.lib.Reference;
import bb.mods.bbbc.world.gen.BBWorldGen;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@SuppressWarnings("unused")
@Mod(modid = Reference.MOD_ID , name = Reference.MOD_NAME, version = Reference.MOD_VERSION  )
@NetworkMod(
		channels = {"BBBlockCraft_alt"},
		clientSideRequired = true,
	    serverSideRequired = false//,
/*	    packetHandler = PacketHandler.class*/ )
public class BBBlockCraft {
static boolean settingdebug = false;
	
	// New Creative Tab	
	

	// Item Definitions
		public static Item MyFirstItem;
		public static Item NineBrickStairsItem;
		public static Item Bookwallitem;
		
	//Gen Definition
		
	public static bb.mods.bbbc.world.gen.BBWorldGen worldGen = new BBWorldGen();
	
	//Achievementīs
	
	public static Achievement firstAchievement = new Achievement(2001, "Getting Ore", 0, 2,Item.diamond, AchievementList.openInventory).setSpecial().registerAchievement();
	public static Achievement secondAchievement = new Achievement(2002, "Smelting the Ore",0,4,Item.diamond, AchievementList.openInventory).registerAchievement();
	
	//Achivementīs names
	private static void addAchievementName(String ach,String name)
	{LanguageRegistry.instance().addStringLocalization(ach,"en_US",name);}
	private static void addAchievementDesc(String ach, String desc)
	{LanguageRegistry.instance().addStringLocalization(ach,"en_US",desc);}
	
    static void addAchievementLocalizations()
    {
                    BBBlockCraft.addAchievementName("firstAchievement", "Got the Ore!");
                    BBBlockCraft.addAchievementName("secondAchievement","Smelt it!");
                    BBBlockCraft.addAchievementDesc("firstAchievement", "Get the Ore!");
                    BBBlockCraft.addAchievementDesc("secondAchievement","You did it right!" );
    }
		
	//Achievement Page
	public AchievementPage page1 = new AchievementPage("BBBlockCraft",firstAchievement,secondAchievement);
		
	public static BBBlockCraft  instance;
		
	//@SidedProxy(clientSide = "bb.mods.tutorial.ClientProxy",serverSide = "bb.mods.tutorial.CommonProxy")
	//public static CommonProxy proxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		block.signBlockID();
		block.Blockreg();
		block.Blockname();
	}
	
	@Init
	public void init(FMLInitializationEvent evtent)
	{
       
		BBBlockCraft.addAchievementLocalizations();				
		
		//Register AchivementPage
		AchievementPage.registerAchievementPage(page1);
		
		//??? Blocks/Items
	/*	MyFirstItem = new MyFirstItem(2100);
		NineBrickStairsItem =new NineBrickStairsItem(2101);
		Bookwallitem = new Bookwallitem(2102);
		
		
		*/
		//Blockreg();
		//SmeltingRecipe();
		//Recipe();
		//ShapelessRecipe();
		//Blocknames();
		
		//Add World Gen
		GameRegistry.registerWorldGenerator(worldGen);
		
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent evt)
	{
		
	}
	
	
	
	
	/**To add Smelting Recipes*/
	public void SmeltingRecipe(){
		
		  //Add Furnace Recipe
		
		  ModLoader.addSmelting(160,new ItemStack(MyFirstItem,5),5.0F);
	      ModLoader.addSmelting(162,new ItemStack(block.CloudWhite,1,0),5.0F);
						
		}
	
	
	
	/**To add Recipes*/
	public void Recipe(){
		
		// Add Recipes
		
		ModLoader.addRecipe(new ItemStack(Item.ingotIron,2),new Object[]
		{"   ","XXX","   ",'X',MyFirstItem});
		
		ModLoader.addRecipe(new ItemStack(NineBrickStairsItem,1),new Object[]{
			"XXX","XXX","XXX",'X',Block.stairsBrick});
		
		ModLoader.addRecipe(new ItemStack(NineBrickStairsItem,1,1),new Object[]{
			"XXX","XXX","XXX",'X',new ItemStack(NineBrickStairsItem,1,0)});
			
		ModLoader.addRecipe(new ItemStack(Bookwallitem,1), new Object[]{
			"XXX","XXX","XXX",'X',new ItemStack(Block.bookShelf,1)
		});
	}
	
	
	
	/**To add Shapeless Recipes*/
	public void ShapelessRecipe(){
		
		//Add Shapeless Recipes
		
		ModLoader.addShapelessRecipe(new ItemStack(block.CloudWhite,1,0), new Object[]
				{new ItemStack(Block.cloth,1,0)});
		
		ModLoader.addShapelessRecipe(new ItemStack(block.CloudWhite,1,1), new Object[]
				{new ItemStack(Block.cloth,1,1)});
		
		ModLoader.addShapelessRecipe(new ItemStack(MyFirstItem,3),new Object[]
				{Item.ingotIron,Item.ingotIron});
		
		ModLoader.addShapelessRecipe(new ItemStack(block.BlockOreOne,1),new Object[]
				{MyFirstItem,MyFirstItem,MyFirstItem,MyFirstItem,MyFirstItem});
		
		ModLoader.addShapelessRecipe(new ItemStack(block.TestBlock,1),new Object[]
				{Block.stone,block.BlockOreOne});
		
		ModLoader.addShapelessRecipe(new ItemStack(Block.stairsBrick,9),new Object[]{
		NineBrickStairsItem});
		
		ModLoader.addShapelessRecipe(new ItemStack(block.TestBlock,1),new Object[]{
		new ItemStack(Block.stairsBrick,64),new ItemStack(Block.stairsBrick,18),new ItemStack(Block.bookShelf,34),new ItemStack(Block.enchantmentTable,1),new ItemStack(Block.brick,64),new ItemStack(Block.brick,22),new ItemStack(Block.stoneSingleSlab,1,4)});
	
	
		ModLoader.addShapelessRecipe(new ItemStack(NineBrickStairsItem,9),new Object[]{
			new ItemStack(NineBrickStairsItem,1,1)});
		

		ModLoader.addShapelessRecipe(new ItemStack(Block.bookShelf,9),new Object[]{
			new ItemStack(Bookwallitem,1)
		});

	
		
	}
	
	
	/**To add Block names*/
	public void Blocknames(){
	
		// Add Names
		
				ModLoader.addName(MyFirstItem, "My First Item");
				ModLoader.addName(NineBrickStairsItem,"Brick Stairs");
				ModLoader.addName(Bookwallitem," Bookwall Item ");
				
				
		
	}
	
	
 }
