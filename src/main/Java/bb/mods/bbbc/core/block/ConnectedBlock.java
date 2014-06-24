package bb.mods.bbbc.core.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import bb.mods.bbbc.core.tileentity.ConnectedTileEntity;

public abstract class ConnectedBlock extends BlockContainer {

	private List<Block> canConnect = new ArrayList<Block>();
	
	public final ResourceLocation resLocation;
	
	public ConnectedBlock(Material material,ResourceLocation re) {
		super(material);
		resLocation = re;
		addConnectingBlock(this);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z,
			Block block) {
		super.onNeighborBlockChange(world, x, y, z, block);
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof ConnectedTileEntity) {
			ConnectedTileEntity te = (ConnectedTileEntity) tile;
			te.neighborChanged();
		}
	}
	
	@Override
	public void onPostBlockPlaced(World world, int x,int y, int z, int p_149714_5_) {
		super.onPostBlockPlaced(world, x, y, z,p_149714_5_);
		for(int i = -1;i<=1;i++){
			for(int ii = -1;ii<=1;ii++){
				for(int iii = -1;iii<=1;iii++){
					TileEntity te = world.getTileEntity(x+i,y+ii,z+iii);
					if(te instanceof ConnectedTileEntity){
						ConnectedTileEntity cte = (ConnectedTileEntity) te;
						cte.neighborChanged();
					}
				}
			}
		}
		
	}
	
	@Override
	public void onBlockPreDestroy(World world, int x,
			int y, int z, int p_149725_5_) {
		// TODO Auto-generated method stub
		super.onBlockPreDestroy(world, x, y, z,
				p_149725_5_);
		for(int i = -1;i<=1;i++){
			for(int ii = -1;ii<=1;ii++){
				for(int iii = -1;iii<=1;iii++){
					TileEntity te = world.getTileEntity(x+i,y+ii,z+iii);
					if(te instanceof ConnectedTileEntity){
						ConnectedTileEntity cte = (ConnectedTileEntity) te;
						cte.neighborChanged();
					}
				}
			}
		}
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

}
