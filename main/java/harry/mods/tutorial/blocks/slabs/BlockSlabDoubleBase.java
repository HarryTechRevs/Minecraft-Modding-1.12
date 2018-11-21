package harry.mods.tutorial.blocks.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BlockSlabDoubleBase extends BlockSlabBase
{
	public BlockSlabDoubleBase(String name, Material materialIn, CreativeTabs tab, BlockSlab half) 
	{
		super(name, materialIn, tab, half);
	}

	@Override
	public boolean isDouble() 
	{	
		return true;
	}
}
