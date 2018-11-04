package harry.mods.tutorial.util.handlers;

import harry.mods.tutorial.Reference;
import harry.mods.tutorial.blocks.tileentities.TileEntityCopperChest;
import harry.mods.tutorial.blocks.tileentities.TileEntityElectricSinteringFurnace;
import harry.mods.tutorial.blocks.tileentities.TileEntityEnergyStorage;
import harry.mods.tutorial.blocks.tileentities.TileEntityGlowstoneGenerator;
import harry.mods.tutorial.blocks.tileentities.TileEntitySinteringFurnace;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityCopperChest.class, new ResourceLocation(Reference.MODID + ":copper_chest"));
		GameRegistry.registerTileEntity(TileEntitySinteringFurnace.class, new ResourceLocation(Reference.MODID + ":sintering_furnace"));
		GameRegistry.registerTileEntity(TileEntityGlowstoneGenerator.class, new ResourceLocation(Reference.MODID + ":glowstone_generator"));
		GameRegistry.registerTileEntity(TileEntityElectricSinteringFurnace.class, new ResourceLocation(Reference.MODID + ":electric_sintering_furnace"));
		GameRegistry.registerTileEntity(TileEntityEnergyStorage.class, new ResourceLocation(Reference.MODID + ":energy_storage"));
	}
}
