package bb.mods.bbbc.transportation.power;

/**
 * Created by BB20101997 on 14.08.2014.
 */
public interface IPowerProvider extends IPower {

    public float maxPowerProvided();
    public float removeEnergy(float f);

}
