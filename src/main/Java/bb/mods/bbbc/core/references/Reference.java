package bb.mods.bbbc.core.references;

public class Reference {

	// Debug-Mode On/Off
	public static final boolean DEBUGMODE = false;

	// General Mod Konstanten
	public static final String MOD_ID = "BBBlockCraftCore";
	public static final String MOD_NAME = "BBBlockCraftCore";
	public static final String MOD_VERSION = "DEV-0.1.1";
	public static final String MOD_CHANNEL = "BB_BBBCCore";
	public static final String MOD_RESOURCE_LOC = "BBBlockCraft";

	public static final String CHATPREFIX = "[" + MOD_CHANNEL + "]";	
	
	private static final String[] SideSufix = new String[] { "top", "bottom",
			"north", "south", "east", "west" };
	/**
	 * @param par5 side
	 * **/
	public static String getSideSufix(int par5) {
		return par5<SideSufix.length&&par5>=0?SideSufix[par5]:null;
	}
}
