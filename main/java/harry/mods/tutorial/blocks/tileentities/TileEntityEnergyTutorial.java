package harry.mods.tutorial.blocks.tileentities;

import harry.mods.tutorial.blocks.energy.CustomEnergyStorage;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;

public class TileEntityEnergyTutorial extends TileEntity implements ITickable
{
	private CustomEnergyStorage storage = new CustomEnergyStorage(10000);
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
	{
		if(capability == CapabilityEnergy.ENERGY) return (T)this.storage;
		return super.getCapability(capability, facing);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
	{
		if(capability == CapabilityEnergy.ENERGY) return true;
		return super.hasCapability(capability, facing);
	}
	
	@Override
	public void update() 
	{
		this.storage.receiveEnergy(100, false);
		this.storage.extractEnergy(200, false);
	}
	
}
