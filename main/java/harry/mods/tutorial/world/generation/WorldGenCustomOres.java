package harry.mods.tutorial.world.generation;

import java.util.Random;

import harry.mods.tutorial.init.BlockInit;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomOres implements IWorldGenerator
{
	private WorldGenerator copper_ore;
	//private WorldGenerator copper_ore_nether, copper_ore_end;
	
	public WorldGenCustomOres() 
	{
		//copper_ore_nether = new WorldGenMinable(BlockInit.COPPER_ORE_NETHER.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.NETHERRACK));
		copper_ore = new WorldGenMinable(BlockInit.COPPER_ORE.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.STONE));
		//copper_ore_end = new WorldGenMinable(BlockInit.COPPER_ORE_END.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.END_STONE));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
		{
		case -1:
			
			//runGenerator(copper_ore_nether, world, random, chunkX, chunkZ, 50, 0, 100);
			
			break;
			
		case 0:
			
			runGenerator(copper_ore, world, random, chunkX, chunkZ, 50, 0, 100);
			
			break;
			
		case 1:
			
			//runGenerator(copper_ore_end, world, random, chunkX, chunkZ, 50, 0, 256);
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
	{
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x,y,z));
		}
	}
}
