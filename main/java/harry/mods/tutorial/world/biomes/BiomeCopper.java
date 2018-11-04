package harry.mods.tutorial.world.biomes;

import harry.mods.tutorial.entity.EntityCentaur;
import harry.mods.tutorial.init.BlockInit;
import net.minecraft.world.biome.Biome;

public class BiomeCopper extends Biome 
{
	public BiomeCopper() 
	{
		super(new BiomeProperties("Copper").setBaseHeight(1.0F).setHeightVariation(1.0F).setRainDisabled().setTemperature(1.0F));
		
		topBlock = BlockInit.COPPER_DIRT.getDefaultState();
		fillerBlock = BlockInit.COPPER_ORE.getDefaultState();	
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCentaur.class, 5, 1, 5));
	}
}
