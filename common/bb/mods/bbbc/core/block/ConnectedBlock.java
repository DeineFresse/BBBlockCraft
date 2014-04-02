package bb.mods.bbbc.core.block;

import bb.mods.bbbc.core.tileentity.ConnectedTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class ConnectedBlock extends BlockContainer {

	public ConnectedBlock(Material material) {
		super(material);
	}
	
	@Override
	public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_,
			int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
		super.onNeighborBlockChange(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_,
				p_149695_5_);
		TileEntity tile = p_149695_1_.getTileEntity(p_149695_2_, p_149695_3_, p_149695_4_);
		if(tile instanceof ConnectedTileEntity) {
			ConnectedTileEntity te  = (ConnectedTileEntity) tile;
			tile.updateEntity();
			
		}{
			
		}
	}
	
	

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new ConnectedTileEntity(null);
	}

}
