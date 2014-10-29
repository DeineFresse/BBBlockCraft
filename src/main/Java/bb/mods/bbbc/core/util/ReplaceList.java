package bb.mods.bbbc.core.util;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

import java.util.ArrayList;
import java.util.List;

public class ReplaceList {
	private static final List<Block> replaceList = new ArrayList<Block>();

	public static Block[] getReplaceList() {
		
		if(replaceList.size()>=1){
		Block[] a = new Block[replaceList.size()];
		for(int i=0;i<a.length;i++){
			a[i] = replaceList.get(i);
		}
		return a;
		}
		else{
			addToReplaceList(Blocks.air);
			return new Block[]{Blocks.air};
		}
	}
	
	public static void addToReplaceList(Block air){
		if(!replaceList.contains(air)){
		replaceList.add(air);
		}
	}
	
	public static void removeFromReplaceList(Block i){
		while(replaceList.contains(i)){
			replaceList.remove(replaceList.indexOf(i));
		}
	}
}
