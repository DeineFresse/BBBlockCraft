package bb.mods.bbbc.transportation.tubes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by BB20101997 on 14.08.2014.
 */
public interface IItemTube extends  ITube{

    public ItemStack addItemStackToTube(ItemStack is,ForgeDirection side);

    public ItemStack[] containingItemStacks();

    public float getTubeSpeed();

    public int getMaxCapacity();

    public int getContent();


}
