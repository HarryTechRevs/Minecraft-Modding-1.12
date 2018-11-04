package harry.mods.tutorial.init;

import harry.mods.tutorial.util.ModConfiguration;
import harry.mods.tutorial.world.dimensions.DimensionLibrary;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionInit 
{
	public static final DimensionType COPPER = DimensionType.register("Copper", "_copper", ModConfiguration.DIMENSION_COPPER_ID, DimensionLibrary.class, false);
	
	public static void registerDimensions()
	{
		DimensionManager.registerDimension(ModConfiguration.DIMENSION_COPPER_ID, COPPER);
	}
}
