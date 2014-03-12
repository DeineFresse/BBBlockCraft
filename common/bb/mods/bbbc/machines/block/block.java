package bb.mods.bbbc.machines.block;

import cpw.mods.fml.common.registry.GameRegistry;
import bb.mods.bbbc.machines.block.FirstMachine;
import bb.mods.bbbc.machines.block.Housemachine;
import bb.mods.bbbc.machines.item.FirstMachineItem;
import net.minecraft.block.Block;

public class block {

	// Block Definitions
	public static Block FirstMachine;
	public static Block Housemachine;

	public static void signBlockID() {
		FirstMachine = new FirstMachine();
		Housemachine = new Housemachine();
	}

	public static void Blockreg() {

		// Register Blocks

		GameRegistry.registerBlock(FirstMachine,FirstMachineItem.class, "FirstMachine");
		GameRegistry.registerBlock(Housemachine,"Housemachine");

	}
}