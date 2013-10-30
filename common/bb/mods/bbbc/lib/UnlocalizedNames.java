package bb.mods.bbbc.lib;

public class UnlocalizedNames {

	public static String getUnlocalizedName(String type,String name){
		
		StringBuilder uln = new StringBuilder();
		
		uln.append(type.toLowerCase()+".");
		uln.append(Reference.MOD_ID.toLowerCase());
		uln.append(name);
		
		return uln.toString();
	}
	
}