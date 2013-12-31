package bb.mods.bbbc.machines.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import bb.mods.bbbc.BBBlockCraftCore;
import bb.mods.bbbc.machines.tileentity.TileEntityFirstMachine;
import bb.mods.bbbc.machines.tileentity.TileEntityHouseMachine;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {

	public GuiHandler(){
		NetworkRegistry.instance().registerGuiHandler(BBBlockCraftCore.instance, this);
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch (ID) {
			case 0:{
				TileEntity te = world.getBlockTileEntity(x, y, z);
				if(te != null && te instanceof TileEntityFirstMachine){
					return new ContainerFirstMachine(player.inventory,(TileEntityFirstMachine)te);
				}
				break;
			}
			case 1:{
				TileEntity te = world.getBlockTileEntity(x, y, z);
				if(te != null && te instanceof TileEntityHouseMachine){
					return new ContainerHouseMachine(player.inventory,(TileEntityHouseMachine)te);
				}
				break;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch (ID) {
		case 0:{
			TileEntity te = world.getBlockTileEntity(x, y, z);
			if(te != null && te instanceof TileEntityFirstMachine){
				return new GuiFirstMachine(player.inventory,(TileEntityFirstMachine)te);
			}
			break;
		}
		case 1:{
			TileEntity te = world.getBlockTileEntity(x, y, z);
			if(te != null && te instanceof TileEntityHouseMachine){
				return new GuiHousemachine(player.inventory,(TileEntityHouseMachine)te);
			}
			break;
		}
	}return null;
	}

}
