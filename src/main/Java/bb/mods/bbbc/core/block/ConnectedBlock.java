package bb.mods.bbbc.core.block;

import bb.mods.bbbc.core.references.RenderIDS;
import bb.mods.bbbc.core.tileentity.ConnectedTileEntity;
import bb.mods.bbbc.core.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ConnectedBlock extends BlockContainer {

	public final List<Block> canConnect = new ArrayList<Block>();
	
	public ResourceLocation RLocation = null;
    public ResourceLocation RLocationSide = null;
    public ResourceLocation RLocationCorner = null;


    public final Class<ConnectedTileEntity> tileclazz;

    public static final Class<ConnectedTileEntity> DEFAULT_CLASS = ConnectedTileEntity.class;

	public ConnectedBlock(Material material) {
		this(material,DEFAULT_CLASS);

	}

    public ConnectedBlock(Material material,Class<ConnectedTileEntity> te) {
        super(material);
        canConnect.add(this);
        tileclazz = te;

    }

    public ConnectedBlock(Material material,Class<ConnectedTileEntity> te,Block[] blocks){
       this(material, te);
        canConnect.addAll(Arrays.asList(blocks));
    }

	public final Block[] canConnectToBlocks(){
        return canConnect.toArray(new Block[canConnect.size()]);
	}

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public int getRenderType() {
        return RenderIDS.connectedRender;
    }

    @Override
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {

        ConnectedTileEntity te = null;

        try {
            te = tileclazz.newInstance();
            te.setRecourseLocation(RLocation);
        } catch (Exception e) {
            LogHelper.fatal("Failed to instantiate TileEntity in ConnectedBlock.createNewTileEntity(World var1,int var 2).\nCheck if the Constructor without Arguments is visible!");
            e.printStackTrace();
        }

        return te;

	}

    @Override
    public void registerBlockIcons(IIconRegister iir) {
       String  mod = RLocation.getResourceDomain();
       String block = RLocation.getResourcePath();

       blockIcon = iir.registerIcon(RLocation.toString());
    }
}
