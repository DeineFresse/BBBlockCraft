package bb.mods.bbbc.core.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import bb.mods.bbbc.core.tileentity.ConnectedTileEntity;

public abstract class ConnectedBlock extends BlockContainer {

	private List<Block> canConnect = new ArrayList<Block>();
	
	public ResourceLocation resLocation;
	
	public ConnectedBlock(Material material,ResourceLocation re) {
		super(material);
		resLocation = re;
		addConnectingBlock(this);
	}

	public final Block[] canConnectToBlock(){
		Block[] a = new Block[canConnect.size()];
		for(int i =0;i< canConnect.size();i++){
			a[i] = canConnect.get(i);
		}
		return a;
	}
	
	public void addConnectingBlock(Block b){
		canConnect.add(b);
	}
	public void removeConnectingBlock(Block b){
		canConnect.remove(b);
	}
	public void removeConnectingBlockByIndex(int i){
		canConnect.remove(i);
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
		TileEntity te = world.getTileEntity(x, y, z);
		if(te instanceof ConnectedTileEntity){
			ConnectedTileEntity conte = (ConnectedTileEntity) te;
			return conte.shouldSideBeRendered(ForgeDirection.values()[side]);
		}
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new ConnectedTileEntity(null);
	}

    @Override
    public void registerBlockIcons(IIconRegister iir) {
       blockIcon = iir.registerIcon(resLocation.toString());
    }
}
