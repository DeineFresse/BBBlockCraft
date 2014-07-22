package bb.mods.bbbc.core.util;

import bb.mods.bbbc.core.references.Reference;

public class UnlocalizedNames {

	/**
	 * @param name
	 * the Item/Block/etc. name
	 * **/
	public static String getUnlocalizedName(String name){
		
		StringBuilder uln = new StringBuilder();
		
		uln.append( Reference.MOD_RESOURCE_LOC.toLowerCase()+":");
		uln.append(name);
		
		return uln.toString();
	}
	
}