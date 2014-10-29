package bb.mods.bbbc.transportation.power;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by BB20101997 on 14.08.2014.
 */
public interface IPowerAcceptor extends IPower {

    /**
     * @param f the amount that should be added     *
     * @return the amount of Energy that does not fit
     * <p/>
     * **
     */
    public float addPowerToAcceptor(float f);
    public float isAccepting(ForgeDirection side);


}
