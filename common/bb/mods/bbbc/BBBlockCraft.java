package bb.mods.bbbc;

import bb.mods.bbbc.block.block;
import bb.mods.bbbc.item.item;
import bb.mods.bbbc.lib.Reference;
import bb.mods.bbbc.reciepe.crafting;
import bb.mods.bbbc.reciepe.smelting;
import bb.mods.bbbc.world.gen.BBWorldGen;
import bb.mods.bbbc.common.CommonProxy;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(channels = { "BBBlockCraft_alt" }, clientSideRequired = true, serverSideRequired = false, packetHandler = bb.mods.bbbc.common.network.PacketHandler.class)
public class BBBlockCraft {
	static boolean settingdebug = Reference.DEBUGMODE;

	// New Creative Tab

	// Gen Definition

	public static bb.mods.bbbc.world.gen.BBWorldGen worldGen = new BBWorldGen();

	// Achievement´s

	public static Achievement firstAchievement = new Achievement(2001,
			"Getting Ore", 0, 2, Item.diamond, AchievementList.openInventory)
			.setSpecial().registerAchievement();
	public static Achievement secondAchievement = new Achievement(2002,
			"Smelting the Ore", 0, 4, Item.diamond,
			AchievementList.openInventory).registerAchievement();

	// Achivement´s names
	private static void addAchievementName(String ach, String name) {
		LanguageRegistry.instance().addStringLocalization(ach, "en_US", name);
	}

	private static void addAchievementDesc(String ach, String desc) {
		LanguageRegistry.instance().addStringLocalization(ach, "en_US", desc);
	}

	static void addAchievementLocalizations() {
		BBBlockCraft.addAchievementName("firstAchievement", "Got the Ore!");
		BBBlockCraft.addAchievementName("secondAchievement", "Smelt it!");
		BBBlockCraft.addAchievementDesc("firstAchievement", "Get the Ore!");
		BBBlockCraft.addAchievementDesc("secondAchievement",
				"You did it right!");
	}

	// Achievement Page
	public AchievementPage page1 = new AchievementPage("BBBlockCraft",
			firstAchievement, secondAchievement);

	public static BBBlockCraft instance;

	@SidedProxy(clientSide = "bb.mods.bbbc.common.ClientProxy", serverSide = "bb.mods.bbbc.common.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		block.signBlockID();
		block.Blockreg();
		block.Blockname();
		item.signItemID();
		item.Itemname();
	}

	@EventHandler
	public void init(FMLInitializationEvent evtent) {

		BBBlockCraft.addAchievementLocalizations();

		// Register AchivementPage
		AchievementPage.registerAchievementPage(page1);

		smelting.SmeltingRecipe();
		crafting.Recipe();
		crafting.ShapelessRecipe();

		// Add World Gen
		GameRegistry.registerWorldGenerator(worldGen);

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {

	}


}
