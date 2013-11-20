package bb.mods.bbbc.lib;

public class UnlocalizedNames {

	/**
	 * @param name
	 * the Item/Block/etc. name
	 * **/
	public static String getUnlocalizedName(String name){
		
		StringBuilder uln = new StringBuilder();
		
		uln.append(Reference.MOD_ID.toLowerCase()+":");
		uln.append(name);
		
		return uln.toString();
	}
	
}