package harry.mods.tutorial.init;

import java.util.ArrayList;
import java.util.List;

import harry.mods.tutorial.Main;
import harry.mods.tutorial.blocks.Block3DModelBase;
import harry.mods.tutorial.blocks.BlockBase;
import harry.mods.tutorial.blocks.BlockCopperChest;
import harry.mods.tutorial.blocks.BlockDoorBase;
import harry.mods.tutorial.blocks.BlockFluid;
import harry.mods.tutorial.blocks.machines.BlockElectricSinteringFurnace;
import harry.mods.tutorial.blocks.machines.BlockEnergyStorage;
import harry.mods.tutorial.blocks.machines.BlockGlowstoneGenerator;
import harry.mods.tutorial.blocks.machines.BlockSinteringFurnace;
import harry.mods.tutorial.blocks.slabs.BlockSlabDoubleBase;
import harry.mods.tutorial.blocks.slabs.BlockSlabHalfBase;
import harry.mods.tutorial.blocks.trees.BlockDirtBase;
import harry.mods.tutorial.blocks.trees.BlockLeavesBase;
import harry.mods.tutorial.blocks.trees.BlockLogBase;
import harry.mods.tutorial.blocks.trees.BlockSaplingBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;

public class BlockInit 
{	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Copper
	public static final Block COPPER_BLOCK = new BlockBase("copper_block", Material.IRON, Main.TUTORIAL);
	public static final Block COPPER_DIRT = new BlockDirtBase("copper_dirt", Main.TUTORIAL);
	public static final Block COPPER_LEAVES = new BlockLeavesBase("copper_leaves");
	public static final Block COPPER_LOG = new BlockLogBase("copper_log");
	public static final Block COPPER_ORE = new BlockBase("copper_ore", Material.ROCK, Main.TUTORIAL);
	public static final Block COPPER_PLANKS = new BlockBase("copper_planks", Material.WOOD, Main.TUTORIAL);
	public static final Block COPPER_SAPLING = new BlockSaplingBase("copper_sapling");
	public static final Block COPPER_DOOR = new BlockDoorBase("copper_door", Material.ANVIL, Main.TUTORIAL);
	public static final BlockSlab COPPER_SLAB_DOUBLE = new BlockSlabDoubleBase("copper_slab_double", Material.IRON, Main.TUTORIAL, BlockInit.COPPER_SLAB_HALF);
	public static final BlockSlab COPPER_SLAB_HALF = new BlockSlabHalfBase("copper_slab_half", Material.IRON, Main.TUTORIAL, BlockInit.COPPER_SLAB_HALF, BlockInit.COPPER_SLAB_DOUBLE);
	
	//Aluminium
	public static final Block ALUMINIUM_LEAVES = new BlockLeavesBase("aluminium_leaves");
	public static final Block ALUMINIUM_LOG = new BlockLogBase("aluminium_log");
	public static final Block ALUMINIUM_SAPLING = new BlockSaplingBase("aluminium_sapling");
	
	//Custom Models
	public static final Block COPPER_CHEST = new BlockCopperChest("copper_chest");
	public static final Block SANTA_HAT = new Block3DModelBase("santa_hat", Material.CLOTH, Main.TUTORIAL, 0.1875D, 0, 0.1875D, 0.8125D, 0.8125D, 0.8125D);
	
	//Machines
	public static final Block SINTERING_FURNACE = new BlockSinteringFurnace("sintering_furnace");
	public static final Block ELECTRIC_SINTERING_FURNACE = new BlockElectricSinteringFurnace("electric_sintering_furnace");
	public static final Block GLOWSTONE_GENERATOR = new BlockGlowstoneGenerator("glowstone_generator");
	public static final Block ENERGY_STORAGE = new BlockEnergyStorage("energy_storage");
	
	public static final Block MOLTEN_COPPER_BLOCK = new BlockFluid("molten_copper", FluidInit.MOLTEN_COPPER_FLUID, Material.LAVA);
	
}
