package harry.mods.tutorial.util.handlers;

import harry.mods.tutorial.Reference;
import harry.mods.tutorial.blocks.containers.ContainerCopperChest;
import harry.mods.tutorial.blocks.containers.ContainerElectricSinteringFurnace;
import harry.mods.tutorial.blocks.containers.ContainerEnergyStorage;
import harry.mods.tutorial.blocks.containers.ContainerGlowstoneGenerator;
import harry.mods.tutorial.blocks.containers.ContainerSinteringFurnace;
import harry.mods.tutorial.blocks.guis.GuiCopperChest;
import harry.mods.tutorial.blocks.guis.GuiElectricSinteringFurnace;
import harry.mods.tutorial.blocks.guis.GuiEnergyStorage;
import harry.mods.tutorial.blocks.guis.GuiGlowstoneGenerator;
import harry.mods.tutorial.blocks.guis.GuiSinteringFurnace;
import harry.mods.tutorial.blocks.tileentities.TileEntityCopperChest;
import harry.mods.tutorial.blocks.tileentities.TileEntityElectricSinteringFurnace;
import harry.mods.tutorial.blocks.tileentities.TileEntityEnergyStorage;
import harry.mods.tutorial.blocks.tileentities.TileEntityGlowstoneGenerator;
import harry.mods.tutorial.blocks.tileentities.TileEntitySinteringFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_SINTERING_FURNACE) return new ContainerSinteringFurnace(player.inventory, (TileEntitySinteringFurnace)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == Reference.GUI_COPPER_CHEST) return new ContainerCopperChest(player.inventory, (TileEntityCopperChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == Reference.GUI_GLOWSTONE_GENERATOR) return new ContainerGlowstoneGenerator(player.inventory, (TileEntityGlowstoneGenerator)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == Reference.GUI_ELECTRIC_SINTERING_FURNACE) return new ContainerElectricSinteringFurnace(player.inventory, (TileEntityElectricSinteringFurnace)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == Reference.GUI_ENERGY_STORAGE) return new ContainerEnergyStorage(player.inventory, (TileEntityEnergyStorage)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_SINTERING_FURNACE) return new GuiSinteringFurnace(player.inventory, (TileEntitySinteringFurnace)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == Reference.GUI_COPPER_CHEST) return new GuiCopperChest(player.inventory, (TileEntityCopperChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == Reference.GUI_GLOWSTONE_GENERATOR) return new GuiGlowstoneGenerator(player.inventory, (TileEntityGlowstoneGenerator)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == Reference.GUI_ELECTRIC_SINTERING_FURNACE) return new GuiElectricSinteringFurnace(player.inventory, (TileEntityElectricSinteringFurnace)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == Reference.GUI_ENERGY_STORAGE) return new GuiEnergyStorage(player.inventory, (TileEntityEnergyStorage)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}
}
