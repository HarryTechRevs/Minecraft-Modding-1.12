package harry.mods.tutorial.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class Block3DModelBase extends BlockBase 
{
	public static AxisAlignedBB MODEL_AABB;
	
	public Block3DModelBase(String name, Material material, CreativeTabs tab, double x1, double y1, double z1, double x2, double y2, double z2) 
	{
		super(name, material, tab);
		MODEL_AABB = new AxisAlignedBB(x1, y1, z1, x2, y2, z2);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		return MODEL_AABB;
	}
}
