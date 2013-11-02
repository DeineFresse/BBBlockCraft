package bb.mods.bbbc.block;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import bb.mods.bbbc.BBBlockCraft;
import bb.mods.bbbc.lib.Block_Names;
import bb.mods.bbbc.lib.UnlocalizedNames;
import bb.mods.bbbc.tileentity.TileEntityFirstMachine;

public class FirstMachine extends BlockContainer {

	protected FirstMachine(int par1) {
		super(par1, Material.plants);
		setHardness(0.5f);
		setResistance(5.0f);
		setStepSound(soundStoneFootstep);
		setCreativeTab(CreativeTabs.tabBlock);
		setLightValue(1.0F);
		setUnlocalizedName(UnlocalizedNames.getUnlocalizedName(Block_Names.FIRSTMACHINE));
}

	@Override
	public boolean onBlockActivated(World world,int x,int y,int z,EntityPlayer player,int side,float hitX,float hitY,float hitZ){
		
		if(!world.isRemote){
			FMLNetworkHandler.openGui(player, BBBlockCraft.instance,0, world, x, y, z);		
			
			
		}		
		
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityFirstMachine();
	}

}
