package bb.mods.bbbc.core.tileentity;

import bb.mods.bbbc.core.block.ConnectedBlock;
import bb.mods.bbbc.core.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ConnectedTileEntity extends TileEntity {

    private ResourceLocation re;

    protected boolean hasChanged = true;

    private int connection;

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbttagcompound);

    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readFromNBT(pkt.func_148857_g());
        super.onDataPacket(net, pkt);
    }

    public ConnectedTileEntity(ResourceLocation res) {
        re = res;
    }

    public ConnectedTileEntity() {
    }

    public ResourceLocation getResourceLocation() {
        return re;
    }

    public TileEntity setRecourceLocation(ResourceLocation res) {
        re = res;
        return this;
    }

    @Override
    public void updateEntity() {
        checkConnection();
    }

    public int getConnection() {

        checkConnection();
        return connection;

    }

    private void checkConnection() {

       int tempConnection = 0;

        World w = getWorldObj();

        for(int x=-1,offset = 0;x<=1;x++){
            for(int y=-1;y<=1;y++){
                for(int z=-1;z<=1;z++){
                    Block b = w.getBlock(xCoord+x,yCoord+y,zCoord+z);
                    offset = ((x+1)+3*(y+1)+9*(z+1));
                    if(canConnectTo(b)){

                       tempConnection |= ( 1 << offset);
                    }
                    else{
                        tempConnection &= ~(1<<offset);
                    }
                }
            }
        }

        if(connection != tempConnection) {
            connection = tempConnection;
            LogHelper.debug("Connection on ConnectedTileEntity changed to : "+connection);
            }
    }

    //x,y and z should be  -1,0 or 1
    public boolean relativeConnection(int x,int y,int z){
        int offset = ((x+1)+3*(y+1)+9*(z+1));
        int con = connection & (1<<offset);
        return con != 0;

    }

    public boolean realConnection(int x,int z,int y){
        return relativeConnection(x-xCoord,y-yCoord,z-zCoord);
    }

    private boolean canConnectTo(Block conTo) {
        boolean r = false;
        if (conTo == this.blockType) {
            r = true;
        }
        if (this.blockType instanceof ConnectedBlock) {
            ConnectedBlock con = (ConnectedBlock) this.blockType;
            for (Block b : con.canConnectToBlock()) {
                if (b == conTo) {
                    r = true;
                    break;
                }
            }
        }
        return r;
    }


    public boolean shouldSideBeRendered(ForgeDirection forgeDirection) {
        //TODO Needs Rework since the connection is gererated differently
    return !relativeConnection(forgeDirection.getOpposite().offsetX,forgeDirection.getOpposite().offsetY,forgeDirection.getOpposite().offsetZ);
}
}
