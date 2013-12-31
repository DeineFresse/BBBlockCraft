package bb.mods.bbbc.core.lib;

public class TexturesName {

	public static String getTextureName(String BlockName,String ... strings){
		
		StringBuilder Name = new StringBuilder(Reference.MOD_ID.toLowerCase());
		Name.append(':');
		Name.append(BlockName);
		for(int i = 0;i<strings.length;i++){
			Name.append(strings[i]);
		}
			
		return Name.toString();
	}
	
}
