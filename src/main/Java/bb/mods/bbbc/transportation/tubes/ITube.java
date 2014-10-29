package bb.mods.bbbc.transportation.tubes;

import net.minecraft.inventory.ISidedInventory;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by BB20101997 on 14.08.2014.
 */
public interface ITube extends ISidedInventory{

    public enum TUBE_TYPE{
        /***
         * POWER to transport Energy
         * LIQUID to transpord Fluids
         * ITEM to transport Items
         * DATA to transprot Data like Redstone maybe
         * MULTI multi purpose Pipe for mor than one
         * DUMMY dummy dose nothing
         * ***/
        POWER,LIQUID,ITEM,DATA,MULTI,DUMMY
    }

    public TUBE_TYPE getTubeType();
    public boolean canConnectOnSide(ForgeDirection side);
    public boolean acceptsInputOnSide(ForgeDirection side,TUBE_TYPE type);

}
