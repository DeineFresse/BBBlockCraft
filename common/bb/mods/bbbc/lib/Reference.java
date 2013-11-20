package bb.mods.bbbc.lib;

import java.util.ArrayList;
import java.util.List;

public class Reference {

	// Debug-Mode On/Off
	public static final boolean DEBUGMODE = false;

	// General Mod Konstanten
	public static final String MOD_ID = "BBBlockCraft";
	public static final String MOD_NAME = "BBBlockCraft";
	public static final String MOD_VERSION = "DEV-0.1.1";
	public static final String MOD_CHANNEL = "BB_BBBC";

	public static final String CHATPREFIX = "[" + MOD_CHANNEL + "]";

	private static List<Integer> replaceList = new ArrayList<Integer>();

	public static int[] getReplaceList() {
		
		if(replaceList.size()>=1){
		int[] a = new int[replaceList.size()];
		for(int i=0;i<a.length;i++){
			a[i] = replaceList.get(i);
		}
		return a;
		}
		else{
			addToReplaceList(0);
			return new int[]{0};
		}
	}
	
	public static void addToReplaceList(int i){
		if(!replaceList.contains(i)){
		replaceList.add(i);
		}
	}
	
	public static void removeFromReplaceList(int i){
		for(;replaceList.contains(i);){
			replaceList.remove(replaceList.indexOf(i));
		}
	}
	
	
	private static final String[] SideSufix = new String[] { "top", "bottom",
			"north", "south", "east", "west" };
	/**
	 * @param par5 side
	 * **/
	public static String getSideSufix(int par5) {
		return par5<SideSufix.length&&par5>=0?SideSufix[par5]:"";
	}
}
