package harry.mods.tutorial.blocks.machines;

import harry.mods.tutorial.Main;
import harry.mods.tutorial.Reference;
import harry.mods.tutorial.blocks.BlockBase;
import harry.mods.tutorial.blocks.tileentities.TileEntityGlowstoneGenerator;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockGlowstoneGenerator extends BlockBase 
{
	public BlockGlowstoneGenerator(String name) 
	{
		super(name, Material.IRON, Main.TUTORIAL);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!worldIn.isRemote)
		{
			playerIn.openGui(Main.instance, Reference.GUI_GLOWSTONE_GENERATOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		
		return true;
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) 
	{
		return new TileEntityGlowstoneGenerator();
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) 
	{
		TileEntityGlowstoneGenerator tileentity = (TileEntityGlowstoneGenerator)worldIn.getTileEntity(pos);
		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), tileentity.handler.getStackInSlot(0)));
		super.breakBlock(worldIn, pos, state);
	}

}
