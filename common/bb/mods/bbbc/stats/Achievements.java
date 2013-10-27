package bb.mods.bbbc.stats;

import bb.mods.bbbc.block.block;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

public class Achievements {

	public static Achievement firstAchievement = new Achievement(2001,
			"Getting Ore", 0, 2, block.BlockOreOne,
			AchievementList.openInventory).setSpecial().registerAchievement();
	public static Achievement secondAchievement = new Achievement(2002,
			"Smelting the Ore", 2, 2, Block.furnaceBurning, firstAchievement)
			.registerAchievement();

	private static void addAchievementName(String ach, String name) {
		LanguageRegistry.instance().addStringLocalization(ach, "en_US", name);
	}

	private static void addAchievementDesc(String ach, String desc) {
		LanguageRegistry.instance().addStringLocalization(ach, "en_US", desc);
	}

	public static void addAchievementLocalizations() {
		bb.mods.bbbc.stats.Achievements.addAchievementName("firstAchievement",
				"Got the Ore!");
		bb.mods.bbbc.stats.Achievements.addAchievementName("secondAchievement",
				"Smelt it!");

		bb.mods.bbbc.stats.Achievements.addAchievementDesc("firstAchievement",
				"Get the Ore!");
		bb.mods.bbbc.stats.Achievements.addAchievementDesc("secondAchievement",
				"You did it right!");
	}

	public static AchievementPage page1 = new AchievementPage("BBBlockCraft",
			new Achievement[] { AchievementList.openInventory,
					firstAchievement, secondAchievement });

	public static void addAchievementPage() {
		AchievementPage.registerAchievementPage(page1);
	}

}
