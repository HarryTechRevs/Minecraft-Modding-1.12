package harry.mods.tutorial.blocks;

import harry.mods.tutorial.init.BlockInit;
import harry.mods.tutorial.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluid extends BlockFluidClassic 
{
	public BlockFluid(String name, Fluid fluid, Material material)
	{
		super(fluid, material);
		setUnlocalizedName(name);
		setRegistryName(name);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) 
	{
		return EnumBlockRenderType.MODEL;
	}
}
