package bb.mods.bbbc.core.lib;

import java.util.ArrayList;
import java.util.List;

public class ReplaceList {
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
}
