package bb.mods.bbbc.core.util;

import bb.mods.bbbc.core.references.Reference;

public class TexturesName {

	public static String getTextureName(String BlockName,String ... strings){
		
		StringBuilder Name = new StringBuilder( Reference.MOD_RESOURCE_LOC.toLowerCase());
		Name.append(':');
		Name.append(BlockName);
        for (String string : strings) {
            Name.append(string);
        }
			
		return Name.toString();
	}
	
}
