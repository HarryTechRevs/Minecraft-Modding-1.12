package harry.mods.tutorial.world.generation.chunks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import harry.mods.tutorial.entity.EntityCentaur;
import harry.mods.tutorial.init.BiomeInit;
import harry.mods.tutorial.init.BlockInit;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorSimplex;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.terraingen.ChunkGeneratorEvent.InitNoiseField;
import net.minecraftforge.event.terraingen.InitNoiseGensEvent.ContextEnd;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ChunkGeneratorEndTemplate implements IChunkGenerator
{
	//Block that replaces End Stone
	protected static final IBlockState MAIN_BLOCK = BlockInit.COPPER_BLOCK.getDefaultState();
    protected static final IBlockState AIR = Blocks.AIR.getDefaultState();
    
    //List of all the mobs you want to spawn
    protected List<SpawnListEntry> spawnableCreatureList = Lists.<SpawnListEntry>newArrayList();
	
    //Keep all these the same
    private final Random rand;
    private final World world;
    private final boolean mapFeaturesEnabled;
    private final BlockPos spawnPoint;
    private Biome[] biomesForGeneration;
    private int chunkX = 0, chunkZ = 0;
    
    private NoiseGeneratorOctaves lperlinNoise1, lperlinNoise2, perlinNoise1, noiseGen5, noiseGen6;
    private static NoiseGeneratorSimplex islandNoise;
    private double[] buffer;
    double[] pnr, ar, br;
    
    //Put map features here
    //e.g. private MapGenEndCity endCityGen = new MapGenEndCity(this);
    
    public ChunkGeneratorEndTemplate(World world, boolean mapFeaturesEnabled, long seed, BlockPos spawn)
    {
        this.world = world;
        this.mapFeaturesEnabled = mapFeaturesEnabled;
        this.spawnPoint = spawn;
        this.rand = new Random(seed);
        
        spawnableCreatureList.add(new SpawnListEntry(EntityCentaur.class, 10, 1, 5));
        spawnableCreatureList.add(new SpawnListEntry(EntityGiantZombie.class, 50, 1, 2));
        
        this.lperlinNoise1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.lperlinNoise2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.perlinNoise1 = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
        this.islandNoise = new NoiseGeneratorSimplex(this.rand);

        ContextEnd ctx = new ContextEnd(lperlinNoise1, lperlinNoise2, perlinNoise1, noiseGen5, noiseGen6, islandNoise);
        ctx = TerrainGen.getModdedNoiseGenerators(world, this.rand, ctx);
        
        this.lperlinNoise1 = ctx.getLPerlin1();
        this.lperlinNoise2 = ctx.getLPerlin2();
        this.perlinNoise1 = ctx.getPerlin();
        this.noiseGen5 = ctx.getDepth();
        this.noiseGen6 = ctx.getScale();
        this.islandNoise = ctx.getIsland();
        
        //Set the map features to be something
        //e.g. this.endCityGen = (MapGenEndCity) TerrainGen.getModdedMapGen(this.endCityGen,InitMapGenEvent.EventType.END_CITY);

    }

    public void setBlocksInChunk(int x, int z, ChunkPrimer primer)
    {
        int i = 2;
        int j = 3;
        int k = 33;
        int l = 3;
        this.buffer = this.getHeights(this.buffer, x * 2, 0, z * 2, 3, 33, 3);

        for (int i1 = 0; i1 < 2; ++i1)
        {
            for (int j1 = 0; j1 < 2; ++j1)
            {
                for (int k1 = 0; k1 < 32; ++k1)
                {
                    double d0 = 0.25D;
                    double d1 = this.buffer[((i1 + 0) * 3 + j1 + 0) * 33 + k1 + 0];
                    double d2 = this.buffer[((i1 + 0) * 3 + j1 + 1) * 33 + k1 + 0];
                    double d3 = this.buffer[((i1 + 1) * 3 + j1 + 0) * 33 + k1 + 0];
                    double d4 = this.buffer[((i1 + 1) * 3 + j1 + 1) * 33 + k1 + 0];
                    double d5 = (this.buffer[((i1 + 0) * 3 + j1 + 0) * 33 + k1 + 1] - d1) * 0.25D;
                    double d6 = (this.buffer[((i1 + 0) * 3 + j1 + 1) * 33 + k1 + 1] - d2) * 0.25D;
                    double d7 = (this.buffer[((i1 + 1) * 3 + j1 + 0) * 33 + k1 + 1] - d3) * 0.25D;
                    double d8 = (this.buffer[((i1 + 1) * 3 + j1 + 1) * 33 + k1 + 1] - d4) * 0.25D;

                    for (int l1 = 0; l1 < 4; ++l1)
                    {
                        double d9 = 0.125D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * 0.125D;
                        double d13 = (d4 - d2) * 0.125D;

                        for (int i2 = 0; i2 < 8; ++i2)
                        {
                            double d14 = 0.125D;
                            double d15 = d10;
                            double d16 = (d11 - d10) * 0.125D;

                            for (int j2 = 0; j2 < 8; ++j2)
                            {
                                IBlockState iblockstate = AIR;

                                if (d15 > 0.0D)
                                {
                                    iblockstate = MAIN_BLOCK;
                                }

                                int k2 = i2 + i1 * 8;
                                int l2 = l1 + k1 * 4;
                                int i3 = j2 + j1 * 8;
                                primer.setBlockState(k2, l2, i3, iblockstate);
                                d15 += d16;
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }

    public void buildSurfaces(ChunkPrimer primer)
    {
        if (!ForgeEventFactory.onReplaceBiomeBlocks(this, this.chunkX, this.chunkZ, primer, this.world)) return;
        for (int i = 0; i < 16; ++i)
        {
            for (int j = 0; j < 16; ++j)
            {
                int k = 1;
                int l = -1;
                IBlockState iblockstate = MAIN_BLOCK;
                IBlockState iblockstate1 = MAIN_BLOCK;

                for (int i1 = 127; i1 >= 0; --i1)
                {
                    IBlockState iblockstate2 = primer.getBlockState(i, i1, j);

                    if (iblockstate2.getMaterial() == Material.AIR)
                    {
                        l = -1;
                    }
                    else if (iblockstate2.getBlock() == Blocks.STONE)
                    {
                        if (l == -1)
                        {
                            l = 1;

                            if (i1 >= 0)
                            {
                                primer.setBlockState(i, i1, j, iblockstate);
                            }
                            else
                            {
                                primer.setBlockState(i, i1, j, iblockstate1);
                            }
                        }
                        else if (l > 0)
                        {
                            --l;
                            primer.setBlockState(i, i1, j, iblockstate1);
                        }
                    }
                }
            }
        }
    }

    @Override
    public Chunk generateChunk(int x, int z)
    {
        this.chunkX = x; this.chunkZ = z;
        this.rand.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
        this.setBlocksInChunk(x, z, chunkprimer);
        this.buildSurfaces(chunkprimer);

        if (this.mapFeaturesEnabled)
        {
        	//Put map feature generation here
        	//e.g. this.endCityGen.generate(this.world, x, z, chunkprimer);
        }

        Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
        byte[] abyte = chunk.getBiomeArray();

        for (int i = 0; i < abyte.length; ++i)
        {
            abyte[i] = (byte)Biome.getIdForBiome(BiomeInit.COPPER);
        }

        chunk.generateSkylightMap();
        return chunk;
    }

    public static float getIslandHeightValue(int x, int z, int p_185960_3_, int p_185960_4_)
    {
        float f = (float)(x * 2 + p_185960_3_);
        float f1 = (float)(z * 2 + p_185960_4_);
        float f2 = 100.0F - MathHelper.sqrt(f * f + f1 * f1) * 8.0F;

        if (f2 > 80.0F)
        {
            f2 = 80.0F;
        }

        if (f2 < -100.0F)
        {
            f2 = -100.0F;
        }

        for (int i = -12; i <= 12; ++i)
        {
            for (int j = -12; j <= 12; ++j)
            {
                long k = (long)(x + i);
                long l = (long)(z + j);

                if (k * k + l * l > 4096L && ChunkGeneratorEndTemplate.islandNoise.getValue((double)k, (double)l) < -0.8999999761581421D)
                {
                    float f3 = (MathHelper.abs((float)k) * 3439.0F + MathHelper.abs((float)l) * 147.0F) % 13.0F + 9.0F;
                    f = (float)(p_185960_3_ - i * 2);
                    f1 = (float)(p_185960_4_ - j * 2);
                    float f4 = 100.0F - MathHelper.sqrt(f * f + f1 * f1) * f3;

                    if (f4 > 80.0F)
                    {
                        f4 = 80.0F;
                    }

                    if (f4 < -100.0F)
                    {
                        f4 = -100.0F;
                    }

                    if (f4 > f2)
                    {
                        f2 = f4;
                    }
                }
            }
        }

        return f2;
    }

    public boolean isIslandChunk(int x, int z)
    {
        return (long)x * (long)x + (long)z * (long)z > 4096L && this.getIslandHeightValue(x, z, 1, 1) >= 0.0F;
    }

    private double[] getHeights(double[] noiseField, int x, int y, int z, int xSize, int ySize, int zSize)
    {
        InitNoiseField event = new InitNoiseField(this, noiseField, x, y, z, xSize, ySize, zSize);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == Event.Result.DENY) return event.getNoisefield();
        if (noiseField == null) noiseField = new double[xSize * ySize * zSize];

        double d0 = 684.412D;
        double d1 = 684.412D;
        d0 = d0 * 2.0D;
        this.pnr = this.perlinNoise1.generateNoiseOctaves(this.pnr, x, y, z, xSize, ySize, zSize, d0 / 80.0D, 4.277575000000001D, d0 / 80.0D);
        this.ar = this.lperlinNoise1.generateNoiseOctaves(this.ar, x, y, z, xSize, ySize, zSize, d0, 684.412D, d0);
        this.br = this.lperlinNoise2.generateNoiseOctaves(this.br, x, y, z, xSize, ySize, zSize, d0, 684.412D, d0);
        int i = x / 2;
        int j = z / 2;
        int k = 0;

        for (int l = 0; l < xSize; ++l)
        {
            for (int i1 = 0; i1 < zSize; ++i1)
            {
                float f = this.getIslandHeightValue(i, j, l, i1);

                for (int j1 = 0; j1 < ySize; ++j1)
                {
                    double d2 = this.ar[k] / 512.0D;
                    double d3 = this.br[k] / 512.0D;
                    double d5 = (this.pnr[k] / 10.0D + 1.0D) / 2.0D;
                    double d4;

                    if (d5 < 0.0D)
                    {
                        d4 = d2;
                    }
                    else if (d5 > 1.0D)
                    {
                        d4 = d3;
                    }
                    else
                    {
                        d4 = d2 + (d3 - d2) * d5;
                    }

                    d4 = d4 - 8.0D;
                    d4 = d4 + (double)f;
                    int k1 = 2;

                    if (j1 > ySize / 2 - k1)
                    {
                        double d6 = (double)((float)(j1 - (ySize / 2 - k1)) / 64.0F);
                        d6 = MathHelper.clamp(d6, 0.0D, 1.0D);
                        d4 = d4 * (1.0D - d6) + -3000.0D * d6;
                    }

                    k1 = 8;

                    if (j1 < k1)
                    {
                        double d7 = (double)((float)(k1 - j1) / ((float)k1 - 1.0F));
                        d4 = d4 * (1.0D - d7) + -30.0D * d7;
                    }

                    noiseField[k] = d4;
                    ++k;
                }
            }
        }

        return noiseField;
    }

    @Override
    public void populate(int x, int z)
    {
        BlockFalling.fallInstantly = true;
        ForgeEventFactory.onChunkPopulate(true, this, this.world, this.rand, x, z, false);
        BlockPos blockpos = new BlockPos(x * 16, 0, z * 16);

        if (this.mapFeaturesEnabled)
        {
        	//Put map feature structure generation here
        	//e.g. this.endCityGen.generateStructure(this.world, this.rand, new ChunkPos(x, z));
        }

        this.world.getBiome(blockpos.add(16, 0, 16)).decorate(this.world, this.world.rand, blockpos);
        long i = (long)x * (long)x + (long)z * (long)z;

        if (i > 4096L)
        {
            float f = this.getIslandHeightValue(x, z, 1, 1);

            if (this.getIslandHeightValue(x, z, 1, 1) > 40.0F)
            {
                int j = this.rand.nextInt(5);

                for (int k = 0; k < j; ++k)
                {
                    int l = this.rand.nextInt(16) + 8;
                    int i1 = this.rand.nextInt(16) + 8;
                    int j1 = this.world.getHeight(blockpos.add(l, 0, i1)).getY();

                    if (j1 > 0)
                    {
                        int k1 = j1 - 1;

                        if (this.world.isAirBlock(blockpos.add(l, k1 + 1, i1)) && this.world.getBlockState(blockpos.add(l, k1, i1)).getBlock() == MAIN_BLOCK.getBlock())
                        {
                        	//Any plants or foliage you want to spawn (usually chorus plants)
                        	//Make sure that the plant can grow on your main block
                        }
                    }
                }
            }
        }

        ForgeEventFactory.onChunkPopulate(false, this, this.world, this.rand, x, z, false);
        BlockFalling.fallInstantly = false;
    }

    @Override
    public boolean generateStructures(Chunk chunkIn, int x, int z)
    {
        return true;
    }

    @Override
    public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos)
    {
        return spawnableCreatureList;
    }

    @Nullable
    @Override
    public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored)
    {
		return null;
    }
    
    @Override
    public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos)
    {
    	return false;
    }

    @Override
    public void recreateStructures(Chunk chunkIn, int x, int z)
    {
    }
}
