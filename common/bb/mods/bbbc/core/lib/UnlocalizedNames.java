package bb.mods.bbbc.core.lib;

public class UnlocalizedNames {

	/**
	 * @param name
	 * the Item/Block/etc. name
	 * **/
	public static String getUnlocalizedName(String name){
		
		StringBuilder uln = new StringBuilder();
		
		uln.append(bb.mods.bbbc.core.lib.Reference.MOD_ID.toLowerCase()+":");
		uln.append(name);
		
		return uln.toString();
	}
	
}