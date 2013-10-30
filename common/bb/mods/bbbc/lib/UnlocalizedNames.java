package bb.mods.bbbc.lib;

public class UnlocalizedNames {

	@Deprecated
	public static String getUnlocalizedName(String type,String name){
			return getUnlocalizedName(name);
	}
	
	public static String getUnlocalizedName(String name){
		
		StringBuilder uln = new StringBuilder();
		
		uln.append(Reference.MOD_ID.toLowerCase()+":");
		uln.append(name);
		
		return uln.toString();
	}
	
}